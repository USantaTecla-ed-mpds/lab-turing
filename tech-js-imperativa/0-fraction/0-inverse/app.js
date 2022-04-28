const { Console } = require("console-mpds");

const console = new Console();

const numerador   = console.readNumber("Introduce el numerador de la fracción: ");;
const denominador = console.readNumber("Introduce el denominador de la fracción: ");;


console.writeln(`La fracción ${numerador}/${denominador} invertida es la fracción ${denominador}/${numerador}`);