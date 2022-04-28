const { Console } = require("console-mpds");

const console = new Console();

const minIntervalo   = console.readNumber("Introduce el mínimo del intervalo: ");
const maxIntervalo   = console.readNumber("Introduce el máximo del intervalo (superior o igual al mínimo): ");
const escala         = console.readString("Introduce un factor de escala positivo: ");

let longIntervalo = maxIntervalo-minIntervalo;
const centro = longIntervalo/2 + minIntervalo;
longIntervalo *=  escala;


console.writeln(`El intervalo [${minIntervalo},${maxIntervalo}] con factor de escala ${escala} es el intervalo [${centro-longIntervalo/2}, ${centro+longIntervalo/2}]`);

