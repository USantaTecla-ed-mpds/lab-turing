
const { Console } = require("console-mpds");

class ClosedInterval {

    #min;
    #max;

    constructor(min, max) {
        this.#min = min;
        this.#max = max;
    }

    isIncluded(value) {
        return this.#min <= value && value <= this.#max;
    }

}

// Options

class Option {

    static console = new Console();
    #title;

    constructor(title) {
        this.#title = title;
    }

    interact() {};

    showTitle(index) {
        Option.console.writeln(index + ". " + this.getTitle());
    }

    getTitle() {
        return this.#title;
    }

}

class QuitOption extends Option {

    #executed;

    constructor() {
        super("Salir");
        this.#executed = false;
    }

    interact() {
        this.#executed = true;
    }

    isExecuted() {
        return this.#executed;
    }

}

// menus

class Menu {

    static console = new Console();
    #title;
    #options;

    constructor(title) {
        this.#title = title;
        this.#options = [];
    }

    interact() {
        this.addOptions();
        this.interact_();
    }

    addOptions(){};

    interact_() {
        this.showTitles();
        this.execChoosedOption();
    }

    showTitles() {
        this.#showTitle();
        for (let i = 0; i < this.#options.length; i++) {
            this.#options[i].showTitle(i + 1);
        }
    }

    #showTitle() {
        let string = "\n" + this.#title + "\n";
        for (let i = 0; i < this.#title.length; i++) {
            string += "-";
        }
        Menu.console.writeln(string);
    }

    execChoosedOption() {
        let answer;
        let ok;
        do {
            answer = this.#readInt("Opción? [1-" + this.#options.length + "]: ") - 1;
            const interval= new ClosedInterval(0,this.#options.length-1);
            ok = interval.isIncluded(answer)
            if (!ok) {
                Menu.console.writeln("Error!!!");
            }
        } while (!ok);
        this.#options[answer].interact();
    }

    #readInt(prompt){
        return Number.parseInt(Menu.console.readNumber(prompt));
    }

    add(option) {
        this.#options.push(option);
    }

    removeOptions() {
        this.#options = [];
    }

    hasOption(option) {
        return this.#options.includes(option);
    }

}

class QuitMenu extends Menu {

    #quitOption;

    constructor(title) {
        super(title);
        this.#quitOption = new QuitOption();
    }

    showTitles() {
        this.addquitOption();
        super.showTitles();
    }

    addquitOption() {
        if (!this.hasOption(this.#quitOption)) {
            this.add(this.#quitOption);
        }
    }

    isExecutedquitOption() {
        return this.#quitOption.isExecuted();
    }

}

class IterativeMenu extends QuitMenu {

    constructor(title) {
        super(title);
    }

    interact() {
        this.addOptions();
        do {
            this.interact_();
        } while (!this.isExecutedquitOption());
    }

}

class DynamicMenu extends IterativeMenu {

    constructor(title) {
        super(title);
    }

    interact() {
        do {
            this.removeOptions();
            this.addOptions();
            this.interact_();
        } while (!this.isExecutedquitOption());
    }

}

// model

class Model {

    #strings;

    constructor() {
        this.#strings = [];
        for (let string of [`Ana`, `Bea`, `Cio`])
            this.#strings.push(string);
    }

    add(string) {
        this.#strings.push(string);
    }

    remove(index) {
        this.#strings.splice(index, 1);
    }

    get(index) {
        return this.#strings[index];
    }

    size() {
        return this.#strings.length;
    }

}

// ModelOptions

class ModelOption extends Option {

    model;

    constructor(string, model) {
        super(string);
        this.model = model;
    }

    interact() {};

}

class ListModelOption extends ModelOption {

    constructor (model) {
        super("Listar", model);
    }

    interact() {
        for (let i = 0; i < this.model.size(); i++) {
            Option.console.writeln((i + 1) + ". " + this.model.get(i));
        }
        Option.console.writeln();
    }

}

class InverseListModelOption extends ModelOption {

    constructor(model) {
        super("Listar inverso", model);
    }

    interact() {
        for (let i = this.model.size() - 1; i >= 0; i--) {
            Option.console.writeln((i + 1) + ". " + this.model.get(i));
        }
        Option.console.writeln();
    }

}

class AddModelOption extends ModelOption {

    constructor(model) {
        super("Añadir", model);
    }

    interact() {
        let string;
        do {
            string = Option.console.readString("Dame una cadena de caracteres: ");
        } while (string.trim() ==="");
        this.model.add(string.trim());
    }

}

class DuplicationModelOption extends ModelOption {

    constructor(model) {
        super("Duplicar", model);
    }

    interact() {
        const SIZE = this.model.size();
        for(let i=0; i< SIZE; i++){
            this.model.add(this.model.get(i));
        }
    }

}

class RemoveModelsOption extends ModelOption {

    constructor(model) {
        super("Eliminar", model);
    }

    interact() {
        new ModelDynamicMenu(this.model).interact();
    }

}

class RemoveModelOption extends ModelOption {

    #index;

    constructor(model, index) {
        super("Eliminar ", model);
        this.model = model;
        this.#index = index;
    }

    getTitle() {
        return super.getTitle() + ": " + this.model.get(this.#index);
    }

    interact() {
        this.model.remove(this.#index);
    }

}

// ModelMenus

class ModelMenu extends Menu {

    #model;

    constructor(model) {
        super("Model Menu");
        this.#model = model;
    }

    addOptions() {
        this.add(new ListModelOption(this.#model));
        this.add(new InverseListModelOption(this.#model));
    }

}

Option.console.writeln("***");
new ModelMenu(new Model()).interact();

class ModelQuitMenu extends QuitMenu {

    #model;

    constructor(model) {
        super("Model Quit Menu");
        this.model = model;
    }

    addOptions() {
        this.add(new ListModelOption(this.model));
        this.add(new InverseListModelOption(this.model));
    }

}

Option.console.writeln("***");
new ModelQuitMenu(new Model()).interact();

class ModelIterativeMenu extends IterativeMenu {

    #model;

    constructor(model) {
        super("Model Iterative Menu");
        this.#model = model;
    }

    addOptions() {
        this.add(new ListModelOption(this.#model));
        this.add(new InverseListModelOption(this.#model));
    }

}

Option.console.writeln("***");
new ModelIterativeMenu(new Model()).interact();

class ModelDynamicMenu extends DynamicMenu {

    #model;

    constructor(model) {
        super("Model Dynamic Menu");
        this.#model = model;
        this.addOptions();

    }

    addOptions() {
        for (let i = 0; i < this.#model.size(); i++) {
            this.add(new RemoveModelOption(this.#model, i));
        }
    }

}

class ModelIterativeDynamicMenu extends IterativeMenu {

    #model;

    constructor(model) {
        super("Model Iterative Dynamic Menu");
        this.#model = model;
    }

    addOptions() {
        this.add(new ListModelOption(this.#model));
        this.add(new InverseListModelOption(this.#model));
        this.add(new AddModelOption(this.#model));
        this.add(new RemoveModelsOption(this.#model));
        this.add(new DuplicationModelOption(this.#model));
    }

}

Option.console.writeln("***");
new ModelIterativeDynamicMenu(new Model()).interact();