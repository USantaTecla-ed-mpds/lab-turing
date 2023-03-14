package main.es.pbover.utils;

public class InIntervalDialog {
    #min;
    #max;
    constructor(min, max) {
        super();
        this.#min = min;
        this.#max = max;
        this.errorMessage = `The value must be between ${min} and ${max}`;
        this.suffix = `? [` +
            min + `-` +
            max + `]: `
    }

    readWithSuffix() {
        return console.readNumber(this.suffix);
    }

    isOk() {
        return new ClosedInterval(this.#min, this.#max).isIncluded(this.getAnswer());
    }

}
