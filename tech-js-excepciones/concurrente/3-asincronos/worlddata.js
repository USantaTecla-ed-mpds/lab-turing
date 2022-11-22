const https = require('https');
const { Console } = require("console-mpds");
const console = new Console();

function getWorldInfo(field) {
  return new Promise((resolve, reject) => {
    const url = `https://restcountries.com/v2/all?fields=name,${field}`; //https://population.un.org/dataportalapi/api/v1/locations PROBAR SEGUIR CON pageSize=100&pageNumber=1,2,3
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

  const field = console.readString("Wich world data do you need?(Enter property of country-object in restcountries.com/v3.1 schema):")

  try {
    let worldData = await getWorldInfo(field);
    let fieldData = 0;
    for (let index in worldData) {
      switch (typeof worldData[index][field]) {
        case 'number':
          fieldData += worldData[index][field];
          break;
        case 'undefined':
          console.writeln(`${worldData[index].name} Data's type is: ${typeof (worldData[index][field])}`);
          break;
        default:
          throw new Error("No es un numero");
      }
    }
    console.writeln(`World at Jan 6, 2015: ${field}: ${fieldData}`);
  } catch (err) {
    console.writeln("Error: " + err.message);
  };
}

main();
console.writeln("Petición realizada");