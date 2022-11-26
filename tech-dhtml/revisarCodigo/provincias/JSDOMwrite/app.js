var datosProvincias = [
    { nombre: "Alava", km2: "238398", poblacion: "98229" },
    { nombre: "Burgos", km2: "34555", poblacion: "77764" },
    { nombre: "Cáceres", km2: "233433", poblacion: "76543" },
    { nombre: "Huesca", km2: "78875", poblacion: "6789" },
    { nombre: "Santa Cruz de Tenerife", km2: "454555", poblacion: "35433" },
];

document.write(`<header>
<p>Ejercicio para generar elementos DOM dinámicamente a partir de un array de provincias con datos (km2, ...) visualizar una tabla</p>
</header>`);

document.write("<table id='tablaProvincias'>");
document.write("<thead><tr>");
for (campo in datosProvincias[0]) {
    document.write("<td>" + campo + "</td>");
}
document.write("</tr></thead>");
document.write("<tbody>");
for (let i = 0; i < datosProvincias.length; i++) {
    document.write("<tr class='provincia' id='provincia'" + i + ">");
    for (campo in datosProvincias[i]) {
        document.write("<td class='" + campo + "'>" + datosProvincias[i][campo] + "</td>");
    }
    document.write("</tr>");
}
document.write("</tbody>");
document.write("</table>");
