const COUNTRIES = [
  { name: "Alava", density: 238398, population: 98229 },
  { name: "Burgos", density: 34555, population: 77764 },
  { name: "Cáceres", density: 233433, population: 76543 },
  { name: "Huesca", density: 78875, population: 6789 },
  { name: "Santa Cruz de Tenerife", density: 454555, population: 35433 },
];

document.addEventListener("DOMContentLoaded", function (){
  let appView = this.getElementById('appView'); //Duda: let myBody = document.body.innerHTML; vs let myBody = document.body
  createHeader(appView);
  createTable(appView, COUNTRIES);
  createFooter(appView);
});

function createHeader(appView) {
  let h1 = this.document.createElement('h1');
  h1.appendChild(this.document.createTextNode("DHTML exercice"));
  appView.appendChild(h1);
}

function createTable(appView, countries) {
  let table = document.createElement('table');
  createHeaders(table);
  createBody(table, countries);
  appView.appendChild(table);
}

function createHeaders(table) {
  let tr = document.createElement('tr');
  for(text of ['Name', 'Density', 'Population']){
    let th = document.createElement('th');
    th.appendChild(document.createTextNode(text));
    tr.appendChild(th);
  }
  table.appendChild(tr);
}

function createBody(table, countries) {
  for(country of countries){
    let tr = document.createElement("tr");
    for(key of ['name', 'density', 'population']){
      let td = document.createElement("td");
      td.appendChild(document.createTextNode(country[key]));
      tr.appendChild(td);
    }
    table.appendChild(tr);
  }
}

function createFooter(appView) {
  let p = document.createElement('p');
  p.append(
    "La media de población total es " +
    getAverage(
      COUNTRIES
        .map(country => country.population)) + " y la media de densidad total es " +
    getAverage(
      COUNTRIES
        .map(country => country.density))
  );
  let div = document.createElement('div');
  div.append(p);
  div.classList.add("info-box");
  appView.append(div);
}

function getAverage(amounts) {
  let sum = 0;
  let count = 0;
  for (let amount of amounts) {
    if (typeof amount == "number") {
      sum += amount;
      count++;
    }
  }
  return sum / count;
}

