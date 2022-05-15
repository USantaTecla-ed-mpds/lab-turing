/*Escribe un código que determine si una serie de números positivos (terminada en 0)
 está ordenada ascendentemente */

const { Console } = require("console-mpds");
const console = new Console();

let serial="";
let isZero;
let isGreatherThanLast=true;
do{
    newNumber= console.readString("Introduce números para formar una serie (acabando con 0): ");
    isZero=newNumber==="0";
    if(!isZero){
        serial +=newNumber;
        if(serial.length>1){
            isGreatherThanLast &= newNumber>serial[serial.length-2];
        }
    }
}
while (!isZero);

console.writeln (` La serie ${serial} ${isGreatherThanLast?"sí":"no"} está ordenada ascendentemente`);
