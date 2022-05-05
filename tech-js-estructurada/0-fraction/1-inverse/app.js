/*Introduce el numerador de la fracción: 3
Introduce el denominador de la fracción: 18

La fracción 3/18 = 1/6 invertida es la fracción 6/1*/

/*Introduce el numerador de la fracción: 2
Introduce el denominador de la fracción: 5

La fracción 2/5 invertida es la fracción 5/2*/

/*

gcd(int a, int b){
    if (a == b)
        return a;
    else if (a>b)
        return gcd(a-b, b);
    else
        return gcd(a, b-a);
}

*/

const { Console } = require("console-mpds");
const console = new Console();

console.writeln("\n___LA FRACCIÓN REDUCIDA Y SU INVERTIDA___\n");

let numerator;
let denominator;
let isNotZeroDivision=false;

while (!isNotZeroDivision){
    numerator = console.readNumber("Introduce el numerador de la fracción: ");
    if(numerator!=0){
        isNotZeroDivision=true;
    }
    else{
        console.writeln("Por favor, introduce un número mayor al 0, para evitar las divisiones por cero");
    }
}
isNotZeroDivision=false;
while (!isNotZeroDivision){
    denominator = console.readNumber("Introduce el denominador de la fracción: ");
    if(denominator!=0){
        isNotZeroDivision=true;
    }
    else{
        console.writeln("Por favor, introduce un número mayor al 0, para evitar las divisiones por cero");
    }
}
let newNumerator = numerator;
let newDenominator = denominator;

let aux1=1;
let aux2=0;
let mcd=1;

let msg1='';
let msg2='';

if(newNumerator!=newDenominator){
    if(newNumerator<newDenominator){
        aux1=newNumerator;
        aux2=newDenominator;
    }
    else {
        aux1=newDenominator;
        aux2=newNumerator;
    }
        
    while (aux2 != 0) {
        mcd = aux2;
        aux2 = aux1 % aux2;
        aux1 = mcd;
    }
    
    newNumerator/=mcd;
    newDenominator/=mcd;

    msg1= newNumerator+"/"+newDenominator;
    msg2= newDenominator+"/"+newNumerator;
}
else {
    msg1= msg2="1";
}
console.writeln(`La fracción ${numerator}/${denominator} = ${msg1} invertida es la fracción ${msg2}`);