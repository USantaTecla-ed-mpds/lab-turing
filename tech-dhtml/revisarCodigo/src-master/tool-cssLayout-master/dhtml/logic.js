function init() {
    let count = 0;
    for(let item of document.getElementsByClassName("item")){
        item.position = count++;
        item.active = false;
        item.style.backgroundColor = "green";
        item.style.display = "block";
        item.style.position = "static";
        item.style.top = "auto";
        item.style.bottom = "auto";
        item.style.left = "auto";
        item.style.right = "auto";
        item.style.float = "none";
        setInnerHTML(item);
    }
}

function setInnerHTML(item){
    var preffix = "<span>";
    var openTittle = "<b>";
    var closeTittle = "</b>: ";
    var infix = ", ";
    var suffix = "</span>";
    if (item.style.display === "block") {
        preffix = "";
        openTittle = "<h1>";
        closeTittle = "</h1><ul><li>";
        infix = "</li><li>";
        suffix = "</li></ul>";
    }
    item.innerHTML = preffix + openTittle + (item.position+1) + closeTittle +
        "display: " + item.style.display + infix +
        "position: " + item.style.position + infix +
        "top: " + item.style.top + infix +
        "bottom: " + item.style.bottom + infix + 
        "left: " + item.style.left + infix + 
        "right: " + item.style.right + infix +
        "float: " + item.style.float + suffix;
}

function apply() {
    for(let item of document.getElementsByClassName("item")){
        if (item.active) {
            item.style.display = getDisplayForm();
            if (item.style.display == "inline"){
                item.style.width = "auto";
                item.style.height = "auto";
            } else {
                item.style.width = "120px";
                item.style.height = "140px"; 
            }
            item.style.position = getPositionForm();
            item.style.top = getDirectionForm("top");
            item.style.bottom = getDirectionForm("bottom");
            item.style.left = getDirectionForm("left");
            item.style.right = getDirectionForm("right");
            item.style.float = getFloatForm();
            setInnerHTML(item);
        }
    }
}

function getDisplayForm(){
    for(let display of document.getElementsByClassName("display")){
        if (display.checked){
            return display.value;
        }   
    }
}            

function getPositionForm() {
    for(let position of document.getElementsByClassName("position")){
        if (position.checked){
            return position.value;
        }   
    }
}

function getDirectionForm(direction) {
    var text = document.getElementById(direction).value;
    if (text === "auto") {
        return text;
    }
    return parseInt(text,10)+"px";
}

function getFloatForm(){
    for(let float of document.getElementsByClassName("float")){
        if (float.checked){
            return float.value;
        }   
    }
}

function setAllActive(value) {
    for(let item of document.getElementsByClassName("item")) {
        item.active = value;
        setColor(item);
    }
}

function setColor(item){
    item.style.backgroundColor = item.active ? "red" : "green";
}

function alternateActive(item){
    item.active = !item.active;
    setColor(item);
}
                        
function setDisplayForm(display){
    disablePositions();
    disableDirections();
    disableFloat();
    if (display.value !== "none"){
        if (display.value === "block"){
            enableFloat();
        }
        enablePositions();
    }   
}

const DIRECTIONS = ["top", "bottom", "left", "right"];

function enablePositions(){
    for(let position of document.getElementsByClassName("position")){
        if (position.value == "static"){
            position.checked = true;
        }
        position.disabled = false;
    }
}

function disablePositions(){
    for(let position of document.getElementsByClassName("position")){
        position.disabled = true;
    }
}

function enableDirections(){
    for(let direction of DIRECTIONS){
        document.getElementById(direction).disabled = false;
    }
}

function disableDirections(){
    for(let direction of DIRECTIONS){
        let element = document.getElementById(direction);
        element.disabled = true;
        element.value = "auto";
    }
}

function enableFloat(){
    for(let float of document.getElementsByClassName("float")){
        float.disabled = false;
    }
}

function disableFloat(){
    for(let float of document.getElementsByClassName("float")){
        if (float.value == "none"){
            float.checked = true;
        }
        float.disabled = true;
    }
}

function setPositionForm(position) {
    if (position.value === "static"){
        disableDirections();
        enableFloat();
    } else {
        enableDirections();
        disableFloat();
    }
}

function setFloatForm(float) {
    disableDirections();
}
                     


