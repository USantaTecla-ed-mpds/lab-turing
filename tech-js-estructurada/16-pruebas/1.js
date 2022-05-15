/*Escribe un código que determine si una cadenas de caracteres es un palíndromo,
 sin considerar espacios intermedios ni acentos de la cadena.
  P.e.: "Dabale arroz a la zorra el abad" sí es un palímdromo */

const { Console } = require("console-mpds");
const console = new Console();

let phrase = console.readString("Escribe una frase para determinar si es o no un PALÍNDROMO (sin mayúsculas):");

let compactPhrase="";

let j=0;
for (let i=0;i<phrase.length;i++){

    if (phrase[i]!=" "){
        compactPhrase[j]=phrase[i];
        j++;
    }
}

for (let i=0;i<compactPhrase.length;i++){
    switch(compactPhrase[i]){
        case "á":
            compactPhrase[i]="a";
            break;
        case "é":
            compactPhrase[i]="e";
            break;
        case "í":
            compactPhrase[i]="i";
            break;
        case "ó":
            compactPhrase[i]="o";
            break;
        case "ú":
            compactPhrase[i]="u";
            break;
        default:
            //
    }
}
console.writeln(compactPhrase);
