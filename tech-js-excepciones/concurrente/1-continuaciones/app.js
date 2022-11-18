const https = require('https');

getCountryInfo("ESP", showErrorOrDensity);
console.log("Petición realizada");
console.log("---");
getCountryInfo("XXX", showErrorOrDensity);
console.log("Petición realizada");
console.log("---");

function getCountryInfo(code, callback) {
    const url = `https://restcountries.com/v3.1/alpha/${code}`;
    https
        .get(url, (resp) => {
            let data = '';

            resp.on('data', (chunk) => {
                data += chunk;
            });

            resp.on('end', () => {
                if (resp.statusCode === 404) {
                    callback(new Error("País no encontrado"));
                } else {
                    let country = JSON.parse(data)[0];
                    callback(undefined, country);
                }
            });
        })
        .on("error", (err) => {
            callback(err);
        });
}

function showErrorOrDensity(err, country) {
    if (err !== undefined) {
        console.log("Error: " + err.message);
    } else {
        const remainder = country.population %  country.area;
        const integer = country.population - remainder;
        const quotient = integer /  country.area;
        console.log(`Density of ${country.name.common}: ${country.population}(hab)/${country.area}(Km2)=${quotient}(hab/Km2)`);
    }
    console.log(`\n`);
}
