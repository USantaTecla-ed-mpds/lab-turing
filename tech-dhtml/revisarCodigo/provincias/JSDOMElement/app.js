var datosProvincias = [
    { nombre: "Alava", km2: "238398", poblacion: "98229" },
    { nombre: "Burgos", km2: "34555", poblacion: "77764" },
    { nombre: "Cáceres", km2: "233433", poblacion: "76543" },
    { nombre: "Huesca", km2: "78875", poblacion: "6789" },
    { nombre: "Santa Cruz de Tenerife", km2: "454555", poblacion: "35433" },
  ];

function onload(){
  var table = document.getElementById("tablaProvincias");

  var thead = document.createElement("thead");
  table.appendChild(thead);

  var tr = document.createElement("tr");
  thead.appendChild(tr);

  for (campo in datosProvincias[0]) {
    var td = document.createElement("td");
    tr.appendChild(td);
    var text = document.createTextNode(campo);
    td.appendChild(text);
  }

  var tbody = document.createElement("tbody");
  table.appendChild(tbody);

  for (var i = 0; i < datosProvincias.length; i++) {
    var tr = document.createElement("tr");
    tbody.appendChild(tr);
    tr.setAttribute("class", "provincia");
    tr.setAttribute("id", "provincia" + i);

    for (campo in datosProvincias[i]) {
      var td = document.createElement("td");
      tr.appendChild(td);
      td.setAttribute("class", campo);

      var text = document.createTextNode(datosProvincias[i][campo]);
      td.appendChild(text);
    }
  }
}