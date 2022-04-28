const { Console } = require("console-mpds");

const console = new Console();

const minIntervalo   = console.readNumber("Introduce el mínimo del intervalo: ");
const maxIntervalo   = console.readNumber("Introduce el máximo del intervalo (superior o igual al mínimo): ");
const punto   = console.readNumber("Introduce un punto: ");

const incluido = punto>=minIntervalo && punto<=maxIntervalo;

console.writeln(`El intervalo [${minIntervalo},${maxIntervalo}] ${incluido ?"sí":"no"} incluye el punto ${punto}`);

