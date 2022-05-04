const { Console } = require("console-mpds");
const console = new Console();

const day = console.readNumber(`give me the day:`);
const mounth = console.readNumber(`give me the month:`);
const year = console.readNumber(`give me the year:`);

console.write(`The date ${day}/${mounth}/${year}${day<= 31 && mounth<= 12 ?"yes":"no"} It is valid`);