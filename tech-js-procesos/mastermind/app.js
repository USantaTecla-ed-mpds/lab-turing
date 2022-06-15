const { Console } = require("console-mpds");
const console = new Console();
playMastermind();

function playMastermind() {
    do {
        playGame();
    } while (isResumed());

    function playGame() {
        const COLORS = ['r', 'g', 'y', 'b', 'm', 'c'];
        const COMBINATION_LENGHT = 4;
        const MAX_ATTEMPT = 10;
        const secretCombination = generateSecretCombination(COLORS, COMBINATION_LENGHT);
        let attempts = [];
        let blacksAndWhites = [];
        console.writeln(`----- MASTERMIND -----`);
        console.writeln(`\n0 attempt(s):\n****`);
        do {
            attempts[attempts.length] = getCorrectProposedCombination(COLORS, COMBINATION_LENGHT);
            blacksAndWhites[blacksAndWhites.length] = getProposedCombinationResult(secretCombination, attempts[attempts.length - 1]);
            showBoard(attempts, blacksAndWhites);
        } while (blacksAndWhites[blacksAndWhites.length - 1][0] < COMBINATION_LENGHT && attempts.length < MAX_ATTEMPT);
        console.writeln(`You've ${attempts.length < MAX_ATTEMPT ? "won!!! ;-)" : "lost!!! :-("}`);

        function generateSecretCombination(COLORS, COMBINATION_LENGHT) {
            let secretCombinationArray = [];
            for (let i = 0; i < COMBINATION_LENGHT; i++) {
                let repeated;
                do {
                    let randomColor = COLORS[parseInt(Math.random() * COLORS.length)];
                    repeated = searchValueInArray(randomColor, secretCombinationArray);
                    if (!repeated) {
                        secretCombinationArray[i] = randomColor;
                    }
                } while (repeated)
            }
            return arrayToString(secretCombinationArray);
        }

        function searchValueInArray(value, arraySource) {
            for (let i = 0; i < arraySource.length; i++) {
                if (arraySource[i] === value) {
                    return true;
                }
            }
            return false;
        }

        function arrayToString(arraySource) {
            let stringTarget = "";
            for (let i = 0; i < arraySource.length; i++) {
                stringTarget += arraySource[i];
            }
            return stringTarget;
        }

        function getCorrectProposedCombination(COLORS, combinationLength) {
            let proposedCombination;
            let errorCodeInCombination;
            do {
                proposedCombination = console.readString(`Propose a combination: `);
                errorCodeInCombination = checkErrorsInProposedCombination(proposedCombination, COLORS, combinationLength);
                if (errorCodeInCombination > 0) {
                    showError(errorCodeInCombination, COLORS);
                }
            } while (errorCodeInCombination != 0);
            return proposedCombination;

            function checkErrorsInProposedCombination(proposedCombination, COLORS, combinationLength) {
                const WRONG_LENGTH_ERROR = 1;
                const WRONG_COLOR_ERROR = 2;
                const REPEATED_COLOR_ERROR = 3;
                let errorCodeInCombination = 0;
                if (!(proposedCombination.length === combinationLength)) {
                    errorCodeInCombination = WRONG_LENGTH_ERROR;
                } else {
                    let found = true;
                    for (let i = 0; found && i < proposedCombination.length; i++) {
                        found = searchValueInArray(proposedCombination[i], COLORS);
                    }
                    if (!found) {
                        errorCodeInCombination = WRONG_COLOR_ERROR;
                    } else {
                        if (hasRepeteadElement(proposedCombination)) {
                            errorCodeInCombination = REPEATED_COLOR_ERROR
                        }
                    }
                }
                return errorCodeInCombination;

                function hasRepeteadElement(arraySource) {
                    for (let i in arraySource) {
                        for (let j = 0; j < i; j++) {
                            if (arraySource[j] === arraySource[i]) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }

            function showError(errorCodeInCombination, COLORS) {
                const errorStrings = [`Wrong proposed combination length`, `Wrong colors, they must be: ${arrayToString(COLORS)}`, `Wrong proposed combination, at least one color is repeated`];
                console.writeln(errorStrings[errorCodeInCombination - 1]);
            }
        }

        function getProposedCombinationResult(secretCombination, proposedCombination) {
            let blacks = 0;
            let whites = 0;
            for (let i = 0; i < secretCombination.length; i++) {
                if (secretCombination[i] === proposedCombination[i]) {
                    blacks++;
                } else {
                    if (searchValueInArray(proposedCombination[i], secretCombination)) {
                        whites++;
                    }
                }
            }
            return [blacks, whites];
        }

        function showBoard(attempts, blacksAndWhites) {
            console.writeln(`\n${attempts.length} attempt(s):\n****`);
            for (let i = 0; i < attempts.length; i++) {
                console.writeln(`${attempts[i]}  --> ${blacksAndWhites[i][0]} blacks and ${blacksAndWhites[i][1]} whites`);
            }
        }
    }

    function isResumed() {
        let error;
        let answer;
        do {
            answer = console.readString(`Do you want to continue? (y/n): `);
            error = answer !== `y` && answer !== `n`;
            if (error) {
                console.writeln(`Please, reply "y" or "n"`);
            }
        } while (error);
        return answer === `y`;
    }
} 