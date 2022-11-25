function onLoad() {
  for (let div of document.getElementsByTagName("div")) {
    // div.addEventListener("click", alertBubblingFromListener);
    // div.addEventListener("click", alertTricklingFromListener, true);
    div.addEventListener("click"
      , alertBubblingFromListenerWithoutPropagation);
    div.addEventListener("click"
      , alertTricklingFromListenerWithoutPropagation, true);
  }
}

function getMsg(event, element) {
  if (event.count == undefined) {
    event.count = 0;
  }
  event.count++;
  return element.getAttribute("class") + " con " + event.count;
}

function alertBubblingFromHTML(event, element) {
  console.log("Bubbling form HTML: " + getMsg(event, element));
}

function alertBubblingFromListener(event) {
  console.log("Bubbling form addEventListener: " + getMsg(event, this));
}

function alertTricklingFromListener(event) {
  console.log("Trickling form addEventListener: "
    + getMsg(event, this));
}

function alertBubblingFromListenerWithoutPropagation(event) {
  console.log("Bubbling form addEventListener without Propagation: "
    + getMsg(event, this));
  if (this.getAttribute("class") === "nivel-2 derecha") {
    console.log("PARA burbujeo");
    event.stopPropagation();
  }
}

function alertTricklingFromListenerWithoutPropagation(event) {
  console.log("Trickling form addEventListener without Propagation: "
    + getMsg(event, this));
  if (this.getAttribute("class") === "nivel-3 izquierda") {
    console.log("PARA goteo");
    event.stopPropagation();
  }
}
