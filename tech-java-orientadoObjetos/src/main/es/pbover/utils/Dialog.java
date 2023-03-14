package main.es.pbover.utils;

public class Dialog {
    message;
    errorMessage;
    suffix;
    #answer;

    constructor() {
        this.message = ``;
        this.suffix = ``;
        this.errorMessage=``;
    }

    read(message) {
        let ok;
        do {
            new Message(message).write();
            this.#answer = this.readWithSuffix();
            ok = this.isOk();
            if (!ok) {
                new Message(this.errorMessage).writeln();
            }
        } while (!ok);
    }

    readWithSuffix() {
    }

    isOk() { }

    getAnswer() {
        return this.#answer;
    }
}
