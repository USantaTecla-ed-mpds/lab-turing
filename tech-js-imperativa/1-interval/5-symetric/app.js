const { Console } = require("console-mpds");

const console = new Console();

const minIntervalo   = console.readNumber("Introduce el mínimo del intervalo: ");
const maxIntervalo   = console.readNumber("Introduce el máximo del intervalo (superior o igual al mínimo): ");

console.writeln(`El intervalo [${minIntervalo},${maxIntervalo}] simétrico al origen es [${-maxIntervalo}, ${-minIntervalo}]`);