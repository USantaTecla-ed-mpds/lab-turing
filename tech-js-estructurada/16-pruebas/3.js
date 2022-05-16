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
let middleInterval=maxOfIntervalSearched/2;
do{
    userAnswer=console.readString(`¿Es menor, igual o mayor que ${middleInterval}?:`);
    switch (userAnswer){
        case "menor":
            maxOfIntervalSearched=middleInterval-1;
            
            break;
        case "mayor":
            minOfIntervalSearched=middleInterval+1;
            break;
        case "igual":
            isFound=true;
            break;
        default:
            console.writeln(`Escribe una respuesta de las posibles (menor/mayor/igual)`);
    }
    middleInterval=((maxOfIntervalSearched+minOfIntervalSearched)-(maxOfIntervalSearched+minOfIntervalSearched)%2)/2;
    counterAttemps++;
}while(!isFound);

console.writeln(`He adivinado tu número ${maxOfIntervalSearched} en ${counterAttemps} intentos`);