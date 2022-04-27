/*Primera fracción:
Introduce el numerador de la fracción: 2
Introduce el denominador de la fracción: 3
Segunda fracción:
Introduce el numerador de la fracción: 3
Introduce el denominador de la fracción: 4

La suma de la fracción 2/3 y la fracción 3/4 es la fracción 17/12*/

const { Console } = require("console-mpds");

const console = new Console();

console.writeln("Primera fracción:");

const numerador1   = console.readNumber("Introduce el numerador de la fracción: ");
const denominador1 = console.readNumber("Introduce el denominador de la fracción: ");

console.writeln("Segunda fracción:");

const numerador2   = console.readNumber("Introduce el numerador de la fracción: ");
const denominador2 = console.readNumber("Introduce el denominador de la fracción: ");

console.writeln(`La suma de la fracción ${numerador1}/${denominador1} y la fracción ${numerador2}/${denominador2} es la fraccion ${numerador1*denominador2+numerador2*denominador1}/${denominador1*denominador2}`);