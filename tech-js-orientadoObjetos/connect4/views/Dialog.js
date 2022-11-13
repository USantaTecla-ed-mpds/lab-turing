import { ClosedInterval } from '../models/utils/ClosedInterval.js'
import { Message } from './Message.js';
import { console } from './utils/console.js'


class Dialog {
    message;
    suffix;
    #answer;

    constructor() {
        this.message = ``;
        this.suffix = ``;
    }

    read(message) {
        let ok;
        do {
            new Message(message).write();
            this.#answer = this.readWithSuffix();
            ok = this.isOk();
            if (!ok) {
                new Message(message).writeln();
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
class InIntervalDialog extends Dialog {
    #min;
    #max;
    constructor(min, max) {
        super();
        this.#min = min;
        this.#max = max;
        this.message = `The value must be between ${min} and ${max}`;
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

class YesNoDialog extends Dialog {

    static #AFFIRMATIVE = `y`;
    static #NEGATIVE = `n`;

    constructor() {
        super();
        this.message = `The value must be ${YesNoDialog.#AFFIRMATIVE} or ${YesNoDialog.#NEGATIVE}`;
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

export { InIntervalDialog, YesNoDialog };