const { Console } = require("console-mpds");
const console = new Console();

let minimum = 0;
let maximum = 0;
let inputOk ;
do {
    minimum = console.readNumber(`Introduce el mínimo del intervalo:`);
    maximum = console.readNumber(`Introduce el máximo del intervalo (superior o igual al mínimo):`);
    inputOk = maximum > minimum;
    if (!inputOk) {
        console.writeln(`Error!!! El máximo debe ser superior o igual al mínimo`);
    }

} while (!inputOk);
let splits;
do {
    splits = console.readNumber(`Introduce una cantidad positiva de intervalos:`);
    inputOk = splits > 0;
    if (!inputOk) {
        console.writeln(`Error!!! La cantidad debe ser positiva`);
    }

} while(!inputOk);
let msg = `El intervalo [${minimum}, ${maximum}] dividido en ${splits} intervalos son `;
const lengthNewIntervals = (maximum - minimum) / splits;
for (let i = 0; i < splits; i++) {
    msg += `[${minimum + i * lengthNewIntervals}, ${minimum + (i + 1) * lengthNewIntervals}]`;
    if (i < splits - 2) {
        msg += `, `;
    }
    else {
        if (i < splits - 1) {
            msg += ` y `;
        }
    }
}
console.writeln(`${msg}`);