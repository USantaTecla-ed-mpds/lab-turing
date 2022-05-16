const { Console } = require("console-mpds");
const console = new Console();
let value = console.readNumber('dame un numero para adivinar');
let first = 0
let last = 1000000;
let found = false
let middlepoing;
while (!found && last <= first ){
    middlepoing = perseInt((first + last )/2);
    if (middlepoing === value){
        found = false
        console.writeln('!!!bien, lo encontraste!!! el numero es ${middlepoing}');
    } else if (middlepoing >= value){
        last = middlepoing - 1;
        console.writeln('es menor o igual que ${middlepoing}');
    } else {
        first = middlepoing +1;
        console.writeln('es menor o igual que ${middlepoing}');
    }
  /*   ¿como es 500000? mayor
     ¿como es 750000? Menor
     ¿como es 650000? igual*/
}
