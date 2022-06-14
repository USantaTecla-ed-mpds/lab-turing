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
        console.writeln(`----- MASTERMIND -----`);
        console.writeln(`\n0 attempt(s):\n****`);
        do {
            const proposedCombination = getCorrectProposedCombination(COLORS, COMBINATION_LENGHT);
            attempts[attempts.length] = getProposedCombinationResult(secretCombination, proposedCombination);
            showBoard(attempts);
        } while(attempts[attempts.length - 1][1] < COMBINATION_LENGHT && attempts.length < MAX_ATTEMPT);
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
            let found = false;
            for (let i = 0; !found && i < arraySource.length; i++) {
                found = arraySource[i] === value;
            }
            return found;
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
            let errorCode;
            do {
                proposedCombination = console.readString(`Propose a combination: `);
                errorCode = checkErrorsInProposedCombination(proposedCombination, COLORS, combinationLength);
                if (errorCode > 0) {
                    showError(errorCode, COLORS);
                }
            } while (errorCode != 0);
            return proposedCombination;

            function checkErrorsInProposedCombination(proposedCombination, COLORS, combinationLength) {
                const WRONG_LENGTH_ERROR = 1;
                const WRONG_COLOR_ERROR = 2;
                const REPEATED_COLOR_ERROR = 3;
                let errorCode = 0;
                if (!(proposedCombination.length === combinationLength)) {
                    errorCode = WRONG_LENGTH_ERROR;
                } else {
                    let found = true;
                    for (let i = 0; found && i < proposedCombination.length; i++) {
                        found = searchValueInArray(proposedCombination[i], COLORS);
                    }
                    if (!found) {
                        errorCode = WRONG_COLOR_ERROR;
                    } else {
                        if (hasRepeteadElement(proposedCombination)) {
                            errorCode = REPEATED_COLOR_ERROR
                        }
                    }
                }
                return errorCode;
            }

            function showError(errorCode, COLORS) {
                const errorArray = [0, `Wrong proposed combination length`, `Wrong colors, they must be: ${arrayToString(COLORS)}`, `Wrong proposed combination, at least one color is repeated`];
                console.writeln(errorArray[errorCode]);
            }
        }

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
            return [proposedCombination, blacks, whites];
        }
        function showBoard(attempts) {
            console.writeln(`\n${attempts.length} attempt(s):\n****`);
            for (let i = 0; i < attempts.length; i++) {
                console.writeln(`${attempts[i][0]}  --> ${attempts[i][1]} blacks and ${attempts[i][2]} whites`);
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