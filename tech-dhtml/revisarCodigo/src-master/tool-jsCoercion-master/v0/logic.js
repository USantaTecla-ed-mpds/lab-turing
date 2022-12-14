function generate() {
  generateConversions(["Boolean", "Number", "String"]);
  for (let operators of [{
    title: "Operadores artiméticos/concatenación",
    binaryOperators: ["+", "-", "*", "/", "%", "**"],
    unaryOperators: ["+", "-"]
  }, {
    title: "Operadores relacionales",
    binaryOperators: ["===", "==", "!==", "!=", ">", ">=", "<", "<="]
  }, {
    title: "Operadores lógicos",
    binaryOperators: ["&&", "||"],
    unaryOperators: ["!"]
  }, {
    title: "Operadores de bits",
    binaryOperators: ["&", "|", "^", "<<", ">>", ">>>"],
    unaryOperators: ["~"]
  }]) {
    generateOperators(operators);
  }
  
}

const H2 = 2;
const H3 = 3;
const H4 = 4;

function generateConversions(types) {
  let table = generateHeaderTable("Valor", types);
  for (let value of getValues()) {
    const tr = document.createElement("tr");
    table.appendChild(tr);
    let td = document.createElement("td");
    tr.appendChild(td);
    generateStyle(td, value);
    let text = document.createTextNode(toLiteralString(value));
    td.appendChild(text);
    for (let type of types) {
      td = document.createElement("td");
      tr.appendChild(td);
      result = eval(type + "(" + toLiteralString(value) + ")");
      generateStyle(td, result);
      text = document.createTextNode(toLiteralString(result));
      td.appendChild(text);
    }
  }
}

function toLiteralString(value) {
  return typeof value === "string" ? '"' + value + '"' : value;
}

function getValues() {
  return [
    undefined,
    true, false,
    0, 1, 234, -56, 1.1e-1, 023, 0x23, Infinity, NaN,
    '', 'cadena',
    'undefined',
    'true', 'false',
    '0', '1', '234', '-56', '1.1e-1', '023', '0x23', 'Infinity', 'NaN'];
}

function generateOperators({ title, binaryOperators, unaryOperators }) {
  generateTitle(H2, title);
  generateTitle(H3, "Operadores binarios");
  generateBinaryOperators(binaryOperators);
  if (unaryOperators !== undefined) {
    generateTitle(H3, "Operadores unarios");
    generateUnaryOperators(unaryOperators);
  }
}

function generateTitle(level, title) {
  const body = document.getElementById("body");
  const h = document.createElement("h" + level);
  body.appendChild(h);
  const text = document.createTextNode(title);
  h.appendChild(text);
}

function generateBinaryOperators(binaryOperators) {
  for (let binaryOperator of binaryOperators) {
    generateTitle(H4, "Operador " + binaryOperator);
    let table = generateHeaderTable(binaryOperator, getValues());
    for (let value of getValues()) {
      generateBinaryRowTable(binaryOperator, value, table);
    }
  }
}

function generateHeaderTable(operator, values) {
  const table = generateTable("body");
  const tr = generateFirstHeaderTable(operator, table, true);
  for (let value of values) {
    const td = document.createElement("td");
    tr.appendChild(td);
    generateStyle(td, value);
    const b = document.createElement("b");
    td.appendChild(b);
    const text = document.createTextNode(toLiteralString(value));
    b.appendChild(text);
  }
  return table;
}

function generateTable(id) {
  const table = document.createElement("table");
  document.getElementById(id).appendChild(table);
  return table;
}

function generateStyle(td, value) {
  let msg = typeof value;
  if (msg === "number" && isNaN(value)) {
    msg += " NaN";
  } else if (msg === "boolean" && !value) {
    msg += " false";
  }
  td.setAttribute("class", msg);
}

function generateFirstHeaderTable(value, table, title) {
  const tr = document.createElement("tr");
  table.appendChild(tr);
  const td = document.createElement("td");
  tr.appendChild(td);
  if (!title) {
    generateStyle(td, value);
  }
  const b = document.createElement("b");
  td.appendChild(b);
  const text = document.createTextNode(toLiteralString(value));
  b.appendChild(text);
  return tr;
}

function generateBinaryRowTable(operator, leftValue, table) {
  const tr = generateFirstHeaderTable(leftValue, table, false);
  leftValue = typeof leftValue === "string" ? '"' + leftValue + '"' : leftValue;
  for (let rightValue of getValues()) {
    const td = document.createElement("td");
    tr.appendChild(td);
    rightValue = typeof rightValue === "string" ? '"' + rightValue + '"' : rightValue;
    let result = eval("(" + leftValue + ") " + operator + " (" + rightValue + ")");
    generateStyle(td, result);
    const text = document.createTextNode(toLiteralString(result));
    td.appendChild(eval(text));
  }
}

function generateUnaryOperators(unaryOperators) {
  for (let unaryOperator of unaryOperators) {
    generateTitle(H4, "Operador " + unaryOperator);
    let table = generateHeaderTable(unaryOperator, [""]);
    for (let value of getValues()) {
      generateUnaryRowTable(unaryOperator, value, table);
    }
  }
}

function generateUnaryRowTable(operator, value, table) {
  const tr = generateFirstHeaderTable(value, table, false);
  const td = document.createElement("td");
  tr.appendChild(td);
  value = typeof value === "string" ? '"' + value + '"' : value;
  let result = eval(operator + " (" + value + ")");
  generateStyle(td, result);
  const text = document.createTextNode(toLiteralString(result));
  td.appendChild(eval(text));
}


