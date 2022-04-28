const { Console } = require("console-mpds");

const console = new Console();

console.writeln("Primer intervalo:");
const minIntervalo1  = console.readNumber("Introduce el mínimo del intervalo: ");
const maxIntervalo1  = console.readNumber("Introduce el máximo del intervalo (superior o igual al mínimo): ");

console.writeln("Segundo intervalo:");
const minIntervalo2   = console.readNumber("Introduce el mínimo del intervalo: ");
const maxIntervalo2  = console.readNumber("Introduce el máximo del intervalo (superior o igual al mínimo): ");

const incluido1 = maxIntervalo2>=minIntervalo1 && maxIntervalo2<=maxIntervalo1;
const incluido2= minIntervalo2>=minIntervalo1 && minIntervalo2<=maxIntervalo1;
const intersecta = incluido1 || incluido2 || (maxIntervalo2>maxIntervalo1 && minIntervalo2<minIntervalo1);


if(intersecta) console.writeln(`El intervalo [${minIntervalo1},${maxIntervalo1}] intersección con el intervalo [${minIntervalo2},${maxIntervalo2}] es el intervalo [${minIntervalo2>=minIntervalo1?minIntervalo2:minIntervalo1},${maxIntervalo2<=maxIntervalo1?maxIntervalo2:maxIntervalo1}] `);
else console.writeln(`El intervalo [${minIntervalo1},${maxIntervalo1}] no intersecta con el intervalo [${minIntervalo2},${maxIntervalo2}]`);