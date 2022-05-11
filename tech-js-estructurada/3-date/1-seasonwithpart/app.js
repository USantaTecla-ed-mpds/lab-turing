const { Console } = require("console-mpds");
const console = new Console();
let day = 0;
let month = 0;
let year = 0;

const FIRST_DAY_SPRING = 2 * 30 + 21;
const FIRST_DAY_SUMMER = 5 * 30 + 21;
const FIRST_DAY_AUTUMN = 8 * 30 + 21;
const FIRST_DAY_WINTER = 11 * 30 + 21;
do {
    day = console.readNumber(`Escriba un día (1-30):`);
} while (day < 1 || day > 30);
do {
    month = console.readNumber(`Escriba un mes (1-12):`);
} while (month < 1 || month > 12);
do {
    year = console.readNumber(`Escriba un año (1-...):`);
} while (year < 1);
let msg = `El día ${day} del ${month} de ${year} cae a `;
let msgSeason = ``;
let firstDate = 0;
let msgPeriod = ``;
let dayOfYear = day + (month - 1) * 30;
console.writeln(dayOfYear);

if (dayOfYear >= FIRST_DAY_SPRING && dayOfYear < FIRST_DAY_SUMMER) 
    {
        firstDate = FIRST_DAY_SPRING;
        msgSeason += `primavera`;
    }
else if (dayOfYear >= FIRST_DAY_SUMMER && dayOfYear < FIRST_DAY_AUTUMN) 
    {
        firstDate = FIRST_DAY_SUMMER;
        msgSeason += `verano`;
    }
else if(dayOfYear >= FIRST_DAY_AUTUMN && dayOfYear < FIRST_DAY_WINTER)
    {
        firstDate = FIRST_DAY_AUTUMN;
        msgSeason += `otoño`;
    }
else 
    {
        msgSeason += `invierno`;
        dayOfYear >= FIRST_DAY_WINTER ? msgPeriod = ` primeros de `:``;
    }
    

if (msgPeriod === ``) {
    let period  = (dayOfYear - firstDate) / 30;
    if (period < 1) 
        {
            msgPeriod = `primeros de `;
        }
    else if(period < 2) 
        {
            msgPeriod = `mediados de `;
        }
    else 
        {
            msgPeriod = `finales de `;
        }
    }

msg += msgPeriod + msgSeason;
console.writeln(`${msg}`);