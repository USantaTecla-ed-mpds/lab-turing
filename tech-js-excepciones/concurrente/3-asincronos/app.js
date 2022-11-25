const { Console } = require("console-mpds");
const https = require('https');

const console = new Console();

function getCountryInfo(code) {
  return new Promise((resolve, reject) => {
    const url = `https://restcountries.com/v3.1/alpha/${code}`;
    https.get(url, (resp) => {
      let data = '';

      resp.on('data', (chunk) => {
        data += chunk;
      });

      resp.on('end', () => {
        if (resp.statusCode !== 200) {
          reject(new Error("País no encontrado Error https "+resp.statusCode));
        } else {
          let country = JSON.parse(data)[0];
          console.writeln(country.name.common);
          resolve(country);
        }
      });

    }).on("error", (err) => {
      reject(err);
    });
  });
}

function getDensity(country) {
    console.writeln(`Country: ${country.name.common}`);
    console.writeln(`Population: ${country.population}`);
    console.writeln(`Area: ${country.area}`);
    let density = country.population / country.area;
    console.writeln(`* Calculated Density: ${density.toFixed(2)}`);
    console.writeln(`\n`);
    return density;
}

async function getBordersInfo(code) {
  let country = await getCountryInfo(code);
  let bordersPromises = [];
  for (let code of country.borders) {
    bordersPromises.push(getCountryInfo(code));
  }
  return await Promise.all(bordersPromises);
}


function isResumed() {
  let error;
  let answer;
  do {
    answer = console.readString(`Do you want to continue? (y/n): `);
    error = answer !== `y` && answer !== `n`;
    if (error) {
      console.writeln(`Please, reply "y" or "n"`);
    }
  } while (error);
  return answer === `y`;
}

function getCountryCode() {
  let error;
  let answer;
  do {
    answer = console.readString(`Enter a country code (XXX): `);
    error = !(isNaN(answer)) || answer.length > 3;
    if (error) {
      console.writeln(`Please, enter an cca2, ccn3, cca3 or cioc country code (XXX)`);
    }
  } while (error);
  return answer;
}

async function main() {
  do {
    try {
      let code = getCountryCode();
      let countries = await getBordersInfo(code);
      let densityAverage = 0;
      for (let country of countries) {
        densityAverage += getDensity(country);
      }
      densityAverage /= countries.length;
      console.writeln(`Density Average of borders countries of ${code} is: ${densityAverage.toFixed(2)} hab/Km2`)
    } catch (err) {
      console.writeln("Error: " + err.message);
    };
  } while (isResumed());
}

main();
console.writeln("Peticion realizada");