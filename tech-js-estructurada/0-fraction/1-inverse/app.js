/*Introduce el numerador de la fracción: 3
Introduce el denominador de la fracción: 18

La fracción 3/18 = 1/6 invertida es la fracción 6/1*/

/*Introduce el numerador de la fracción: 2
Introduce el denominador de la fracción: 5

La fracción 2/5 invertida es la fracción 5/2*/


const { Console } = require("console-mpds");
const console = new Console();

const numerador   = console.readNumber("Introduce el numerador de la fracción: ");;
const denominador = console.readNumber("Introduce el denominador de la fracción: ");;


console.writeln(`La fracción ${numerador}/${denominador} invertida es la fracción ${denominador}/${numerador}`);