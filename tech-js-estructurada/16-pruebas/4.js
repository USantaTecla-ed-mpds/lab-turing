/* Escribe un código que a partir de un número de filas y columnas muestre por pantalla una retícula
 correspondiente de cuadrados de 5x5 asteriscos rellenos de puntos */
 /*PARA CORREGIR CON DIEGO*/
/*const { Console } = require("console-mpds");
const console = new Console();
const max = 5;
const rows = console.readNumber('introduce el numero de filas')* max;
const columns = console.readNumber('introduce el numero de columnas')* max;
console.writeln(rows);
for(i = 0; i < columns; i++){
    for(j = 0; j < rows; j++){
        console.writeln(i === 0  j === 0 i % (max) === max -1  );
    }
    console.writeln();
}*/

/* Escribe un código que a partir de un número de filas y columnas muestre por pantalla una retícula
 correspondiente de cuadrados de 5x5 asteriscos rellenos de puntos */
 /*PARA CORREGIR CON DIEGO*/
 const { Console } = require("console-mpds");
 const console = new Console();
 /*const max = 5;
 const rows = console.readNumber('introduce el numero de filas')* max;
 const columns = console.readNumber('introduce el numero de columnas')* max;
 console.writeln(rows);
 for(i = 0; i < columns; i++){
     for(j = 0; j < rows; j++){
         console.writeln(i === 0  j === 0 i % (max) === max -1  );
     }
     console.writeln();
 }*/
 /*ejercicio de papaucla*/
 const SIZE_OF_SIDE = 5;
 const BORDER_CHARACTER = ` * `;
 const INTERIOR_CHARACTER = ` · `;
 const rows = console.readNumber(`Escribe el número de filas: `);
 const columns = console.readNumber(`Escribe el número de columnas: `);
 for (let i = 0; i <  SIZE_OF_SIDE * rows - (rows - 1); i++) {
     let isTopOrBottomRow = i % (SIZE_OF_SIDE - 1) === 0;
     for (let j = 0; j < SIZE_OF_SIDE * columns - (columns - 1); j++) {
         let isAsterisk = isTopOrBottomRow || j % (SIZE_OF_SIDE - 1) === 0;
         console.write(isAsterisk ? BORDER_CHARACTER : INTERIOR_CHARACTER);
     }
     console.writeln();
 }