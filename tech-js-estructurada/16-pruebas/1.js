/*Escribe un código que determine si una cadenas de caracteres es un palíndromo,
 sin considerar espacios intermedios ni acentos de la cadena.
  P.e.: "Dabale arroz a la zorra el abad" sí es un palímdromo */

const { Console } = require("console-mpds");
const console = new Console();

let phrase = console.readString("Escribe una frase para determinar si es o no un PALÍNDROMO (sin mayúsculas):");
let compactPhraseArray=[];
let j=0;
for (let i=0;i<phrase.length;i++){
    if (phrase[i]!=" "){
        compactPhraseArray[j]=phrase[i];
        j++;
    }
}
let reverseCompactPhraseArray=[];
for (let i=0;i<compactPhraseArray.length;i++){
    switch(compactPhraseArray[i]){
        case "á":
            compactPhraseArray[i]="a";
            break;
        case "é":
            compactPhraseArray[i]="e";
            break;
        case "í":
            compactPhraseArray[i]="e";
            [i]="i";
            break;
        case "ó":
            compactPhraseArray[i]="o";
            break;
        case "ú":
            compactPhraseArray[i]="u";
            break;
        default:
    }
    reverseCompactPhraseArray[(compactPhraseArray.length-1)-i]=compactPhraseArray[i];
}
let isPalindrome=true;
for (let letterIndex in compactPhraseArray){
    isPalindrome &= compactPhraseArray[letterIndex]===reverseCompactPhraseArray[letterIndex];
}
console.writeln(`La frase "${phrase}" ${isPalindrome?"sí":"no"} es un palíndromo`);



