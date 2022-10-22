const { Console } = require("console-mpds");
// Options
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

    addOptions(){
    };

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
            ok = interval.isIncluded(answer);
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

    #gameModes;
    #selectedMode=0;

    constructor() {
        this.#gameModes = [];
        for (let string of [`Demo`, `1 Player`, `2 Players`])
            this.#gameModes.push(string);
    }

    add(string) {
        this.#gameModes.push(string);
    }

    remove(index) {
        this.#gameModes.splice(index, 1);
    }

    get(index) {
        return this.#gameModes[index];
    }

    size() {
        return this.#gameModes.length;
    }

    setSelectedMode (index){
        this.#selectedMode=index;
    }

    getSelectedMode (){
        return this.#selectedMode;
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

/*class ListModelOption extends ModelOption {

    constructor (model) {
        super("Listar modos de juego", model);
    }

    interact() {
        for (let i = 0; i < this.model.size(); i++) {
            Option.console.writeln((i + 1) + ". " + this.model.get(i));
        }
        Option.console.writeln();
    }

}*/

class ShowSelectedModeOption extends ModelOption {

    constructor(model) {
        super("Modo Seleccionado", model);
    }

    interact() {
        Option.console.writeln();
        Option.console.writeln((this.model.getSelectedMode()+1)+ ". " + this.model.get(this.model.getSelectedMode()));
        Option.console.writeln();
    }

}

class SetSelectedModeOption extends ModelOption {

    constructor(model) {
        super("Seleccionar", model);
    }

    interact() {
        new ModelDynamicMenu(this.model).interact();
    }

}

/* 

class SetSelectedModeOption extends ModelOption {

    constructor(model) {
        super("Seleccionar Modo", model);
    }

    interact() {
        let mode;
        let ok;
        do {
            mode = Option.console.readNumber("Selecciona un modo de juego [1-" + this.model.size() + "]: ")-1;
            const interval= new ClosedInterval(0, this.model.size()-1);
            ok = interval.isIncluded(mode)
            if (!ok) {
                Menu.console.writeln("Error!!!");
            }
        } while (!ok);
        this.model.setSelectedMode(mode);
    }
}*/

class SelectModelOption extends ModelOption {

    #index;

    constructor(model, index) {
        super("Seleccionar ", model);
        this.model = model;
        this.#index = index;
    }

    getTitle() {
        return super.getTitle() + ": " + this.model.get(this.#index);
    }

    interact() {
        this.model.setSelectedMode(this.#index);
        //this.model.ShowSelectedModeOption();
    }

}

// ModelMenus

class ModelDynamicMenu extends DynamicMenu {

    #model;

    constructor(model) {
        super("Modos de juego");
        this.#model = model;
        this.addOptions();

    }

    addOptions() {
        for (let i = 0; i < this.#model.size(); i++) {
            this.add(new SelectModelOption(this.#model, i));
        }
    }

}

class Connect4ConfigurationMenu extends IterativeMenu {

    #model;

    constructor(model) {
        super("Connec4 Configuration Menu"); //Model Iterative Dynamic Menu
        this.#model = model;
    }

    addOptions() {
        this.add(new ShowSelectedModeOption(this.#model));
        this.add(new SetSelectedModeOption(this.#model));
    }

}

Option.console.writeln("***");
new Connect4ConfigurationMenu(new Model()).interact();