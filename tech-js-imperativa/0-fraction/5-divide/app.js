const { Console } = require("console-mpds");

const console = new Console();

console.writeln("Primera fracción:");

const numerador1   = console.readNumber("Introduce el numerador de la fracción: ");
const denominador1 = console.readNumber("Introduce el denominador de la fracción: ");

console.writeln("Segunda fracción:");

const numerador2   = console.readNumber("Introduce el numerador de la fracción: ");
const denominador2 = console.readNumber("Introduce el denominador de la fracción: ");

console.writeln(`El resultado de dividr la fracción ${numerador1}/${denominador1} entre la fracción ${numerador2}/${denominador2} es la fraccion ${numerador1*denominador2}/${denominador1*numerador2}`);