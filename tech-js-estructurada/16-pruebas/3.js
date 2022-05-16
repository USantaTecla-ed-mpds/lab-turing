/* Escribe un código para "adivinar" el número del usuario en 0 y 1.000.000 inclusives mediante la búsqueda
 binaria: ¿es igual o mayor que 500.000? Mayor; ¿es igual o mayor que 750.000? ... Igual */

const { Console } = require("console-mpds");
const console = new Console();

const MAXINTERVALDEFAULT=100;
let userAnswer;
let isFound=false;
let counterAttemps=0;

let maxOfIntervalSearched=MAXINTERVALDEFAULT;
let minOfIntervalSearched=0;
let intervalToAsk=maxOfIntervalSearched/2;
do{
    userAnswer=console.readString(`¿Es menor, igual o mayor que ${intervalToAsk}?:`);
    switch (userAnswer){
        case "menor":
            maxOfIntervalSearched=intervalToAsk;
            intervalToAsk=(maxOfIntervalSearched-minOfIntervalSearched)/2;
            break;
        case "mayor":
            minOfIntervalSearched=intervalToAsk;
            intervalToAsk=3*(maxOfIntervalSearched)/4;
            break;
        case "igual":
            isFound=true;
            break;
        default:
            console.writeln(`Escribe una respuesta de las posibles (menor/mayor/igual)`);
    }
    counterAttemps++;
}while(!isFound);

console.writeln(`He adivinado tu número ${maxOfIntervalSearched} en ${counterAttemps} intentos`);