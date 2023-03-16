package main.es.pbover.utils;

public class YesNoDialog {
    static #AFFIRMATIVE = `y`;
    static #NEGATIVE = `n`;

    constructor() {
        super();
        this.errorMessage = `The value must be ${YesNoDialog.#AFFIRMATIVE} or ${YesNoDialog.#NEGATIVE}`;
        this.suffix = `? (` +
            YesNoDialog.#AFFIRMATIVE + `/` +
            YesNoDialog.#NEGATIVE + `): `;
    }

    readWithSuffix() {
        return console.readString(this.suffix);
    }

    isOk() {
        return this.isAffirmative() || this.isNegative();
    }

    isAffirmative() {
        return this.getAnswer() === YesNoDialog.#AFFIRMATIVE;
    }

    isNegative() {
        return this.getAnswer() === YesNoDialog.#NEGATIVE;
    }

    getAnswer() {
        return super.getAnswer().toLowerCase()[0];
    }
}
