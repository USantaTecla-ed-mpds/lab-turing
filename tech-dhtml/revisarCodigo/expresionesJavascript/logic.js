function onLoad() {
    let body = document.getElementsByTagName("body")[0];
    body.appendChild(
        createTree(
            createTree(
                createTree(
                    createOperand("3"),
                    "*",
                    createOperand("35")),
                "+",
                createTree(
                    createOperand("33"),
                    "*",
                    createOperand("5"))),
            "+",
            createTree(
                createOperand("22"),
                "*",
                createOperand("35"))));
    body.appendChild(
        createTree(
            createTree(
                createOperand("'Hola '"),
                "+",
                createOperand("'Mundo'")),
            "+",
            createOperand("'!!!'")));
}

function createTree(left, operator, right) {
    let tree = document.createElement("div");
    tree.setAttribute("class", "tree");
    tree.level = (left.level > right.level ? left.level : right.level) + 1;
    tree.value = eval(left.value + operator + right.value);
    if (typeof tree.value == "string") {
        tree.value = "'" + tree.value + "'";
    }
    tree.appendChild(createAsideColumn(tree, left, "left"));
    tree.appendChild(createCenterColumn(tree, operator));
    tree.appendChild(createAsideColumn(tree, right, "right"));
    return tree;
}

function createAsideColumn(tree, subtree, position) {
    let column = document.createElement("div");
    column.setAttribute("class", "column");
    column.appendChild(createEmptyCell());
    column.appendChild(createMiddle("", " fillCell"));
    for (let i = 0; i < (tree.level - subtree.level) * 2 - 2; i++) {
        column.appendChild(createEmptyCell());
    }
    column.appendChild(subtree);
    return column;
}

function createCenterColumn(tree, operator) {
    let column = document.createElement("div");
    column.setAttribute("class", "column");
    column.appendChild(createValueCell(tree.value));

    for (let i = 0; i < tree.level * 2 - 1; i++) {
        column.appendChild(createMiddle("", " fillCell"));
    }
    column.appendChild(createDown(operator));
    return column;
}

function createEmptyCell() {
    let div = document.createElement("div");
    div.setAttribute("class", "cell");
    return div;
}

function createValueCell(value) {
    let div = document.createElement("div");
    div.appendChild(document.createTextNode(value));
    div.setAttribute("class", "cell value");
    return div;
}

function createMiddle(middle, clazz) {
    let div = document.createElement("div");
    div.appendChild(document.createTextNode(middle));
    div.setAttribute("class", "cell" + clazz);
    return div;
}

function createDown(down) {
    let div = document.createElement("div");
    div.appendChild(document.createTextNode(down));
    div.setAttribute("class", "cell textCell fillCell");
    return div;
}

function createOperand(value) {
    let div = document.createElement("div");
    div.appendChild(document.createTextNode(value));
    div.setAttribute("class", "cell textCell value");
    div.value = value;
    div.level = 0;
    return div;
}
