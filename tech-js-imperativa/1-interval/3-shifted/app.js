const { Console } = require("console-mpds");

const console = new Console();

const minIntervalo   = console.readNumber("Introduce el mínimo del intervalo: ");
const maxIntervalo   = console.readNumber("Introduce el máximo del intervalo (superior o igual al mínimo): ");
const factorDesplaza        = console.readNumber("Introduce un factor de desplazamiento: ");


console.writeln(`El intervalo [${minIntervalo},${maxIntervalo}] con factor de desplazamiento ${escala} es el intervalo [${minIntervalo+factorDesplaza}, ${maxIntervalo+factorDesplaza}]`);

