const https = require('https');
const { Console } = require("console-mpds");
const console = new Console();

function getWorldInfo(code) {
  return new Promise((resolve, reject) => {
    const url = `https://restcountries.com/v2/all?fields=${code}`; //https://population.un.org/dataportalapi/api/v1/locations
    https.get(url, (resp) => {
      let data = '';

      resp.on('data', (chunk) => {
        data += chunk;
      });

      resp.on('end', () => {
        let worldData = JSON.parse(data);
        resolve(worldData);
      });

    }).on("error", (err) => {
      reject(err);
    });
  });
}

async function main() {

  const code = console.readString("Wich world data do you need?(name of country object property of restcountries.com/v3.1 schema):")

  try {
    let worldData = await getWorldInfo(code);
    let codeData;
    console.writeln(typeof (worldData[0][code]));
    switch (typeof (worldData[0][code])) {
      case 'number':
        codeData = 0;
        break;
      case 'object':
          codeData = [];
          break;
      default:
        throw new Error("No es un numero");
    }
    for (let country in worldData) {
      switch (typeof (worldData[country][code])) {
        case 'number':
          codeData += worldData[country][code];
          break;
        case 'object':
            codeData [worldData.indexOf[country]]= worldData[country][code];
            break;
        default:
          throw new Error("No es un numero");
      }
    }
    console.writeln(`World at Jan 6, 2015: ${code}: ${codeData}`);
  } catch (err) {
    console.writeln("Error: " + err.message);
  };
}

main();
console.writeln("Petición realizada");