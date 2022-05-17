const NAMES = require('./names');
const { Console } = require("console-mpds");
const console = new Console();

let optionSelected;
do {

    optionSelected = console.readNumber(` 1. Ver países \n\ 2. Buscar país\n\ 3. Salir \n\ Escoge opción? [1-3]:`);
    switch (optionSelected) {
        case 1:
            console.writeln(`${NAMES}`);
            break;
        case 2:
            const searchedCountry = console.readString("Dame el nombre del país(en inglés):");
            let found = false;
            for (let i in NAMES) {
                if (NAMES[i] === searchedCountry) {
                    found = true;
                }
            }
            console.writeln(`El país "${searchedCountry}" ${found ? 'sí' : 'no'} está incluido`)
            break;
        default:
    }


} while (optionSelected != 3);

