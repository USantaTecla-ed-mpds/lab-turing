const { Console } = require("console-mpds");
const console = new Console();

let numerator;
let isZeroDivision;
do{
    numerator = console.readNumber("Introduce el numerador de la fracción: ");
    isZeroDivision=numerator===0;
    if(isZeroDivision){
        console.writeln("Por favor, introduce un número mayor al 0, para evitar las divisiones por cero");
    }
}
while (isZeroDivision);

let denominator;
do{
    denominator = console.readNumber("Introduce el denominador de la fracción: ");
    isZeroDivision=denominator===0;
    if(isZeroDivision){
        console.writeln("Por favor, introduce un número mayor al 0, para evitar las divisiones por cero");
    }
}   
while (isZeroDivision);
    
let newNumerator = numerator;
let newDenominator = denominator;
let gcd=1;
let dividend=numerator>=denominator ? numerator : denominator;
let divisor= numerator<=denominator ? numerator : denominator;      
while (divisor != 0) {
    gcd = divisor;
    divisor = dividend % divisor;
    dividend = gcd;
}
newNumerator/=gcd;
newDenominator/=gcd;
const msg1= newNumerator+"/"+newDenominator;
const msg2= newDenominator+"/"+newNumerator;

console.writeln(`La fracción ${numerator}/${denominator} = ${msg1} invertida es la fracción ${msg2}`);