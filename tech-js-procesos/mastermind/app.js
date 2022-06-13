const { Console } = require("console-mpds");
const console = new Console();
playMastermind();

function playMastermind() {
    do {
        playGame();
    } while (isResumed());

    function playGame() {
        const COLORS = ['r', 'g', 'y', 'b', 'm', 'c'];
        const secretCombination = generateSecretCombination(COLORS);
        let attempts = [];
        let result;
        console.writeln(`----- MASTERMIND -----`);
        showBoard(attempts);
        do {
            const proposedCombination = getProposedCombination(secretCombination.length, COLORS);
            result = checkResult(secretCombination, proposedCombination, attempts);
            showBoard(attempts);
            if (result != "continue") {
                showResult(result);
            }
        } while (result === "continue");

        function generateSecretCombination(arrayValuesCombination) {
            const COMBINATION_LENGHT = 4;
            let secretCombinationArray = [];
            for (let i = 0; i < COMBINATION_LENGHT; i++) {
                let randomColor;
                let repeated;
                do {
                    randomColor = arrayValuesCombination[parseInt(Math.random() * arrayValuesCombination.length)];
                    repeated = searchValueInArray(randomColor, secretCombinationArray);
                    if (!repeated) {
                        secretCombinationArray[i] = randomColor;
                    }
                } while (repeated)
            }
            return arrayToString(secretCombinationArray);
        }

        function showBoard(attempts) {
            console.writeln(`\n${attempts.length} attempt(s):\n**** ${arrayToString(attempts)}`);
        }

        function getProposedCombination(combinationLength, arrayValuesCombination) {
            let proposedCombination;
            let correctProposedCombination;
            do {
                proposedCombination = console.readString(`Propose a combination: `);
                correctProposedCombination = validateProposedCombination(proposedCombination, arrayValuesCombination, combinationLength);
            } while (!correctProposedCombination);
            return proposedCombination;

            function validateProposedCombination(proposedCombination, arrayValuesCombination, combinationLength) {
                const WRONG_LENGTH_ERROR = `Wrong proposed combination length`;
                const WRONG_COLOR_ERROR = `Wrong colors, they must be: ${arrayToString(arrayValuesCombination)}`;
                const REPEATED_COLOR_ERROR = `Wrong proposed combination, at least one color is repeated`;
                let correct = proposedCombination.length === combinationLength;
                if (!correct) {
                    console.writeln(WRONG_LENGTH_ERROR);
                }
                else {
                    for (let i = 0; correct && i < proposedCombination.length; i++) {
                        correct = searchValueInArray(proposedCombination[i], arrayValuesCombination);
                    }
                    if (!correct) {
                        console.writeln(WRONG_COLOR_ERROR);
                    }
                    else {
                        correct = !hasRepeatedCharacter(proposedCombination);
                        if (!correct) {
                            console.writeln(REPEATED_COLOR_ERROR);
                        }
                    }
                }
                return correct;

                function hasRepeatedCharacter(stringSource) {
                    let repeated = false;
                    for (let i in stringSource) {
                        for (let j = 0; !repeated && j < i; j++) {
                            repeated = stringSource[j] === stringSource[i];
                        }
                    }
                    return repeated;
                }
            }
        }

        function arrayToString(arraySource) {
            let stringTarget = "";
            for (let i = 0; i < arraySource.length; i++) {
                stringTarget += arraySource[i];
            }
            return stringTarget;
        }

        function searchValueInArray(value, arraySource) {
            let found = false;
            for (let i = 0; !found && i < arraySource.length; i++) {
                found = arraySource[i] === value;
            }
            return found;
        }

        function checkResult(secretCombination, proposedCombination, attempts) {
            let [black, white] = checkProposedCombination(secretCombination, proposedCombination);
            attempts[attempts.length] = `\n${proposedCombination}  --> ${black} blacks and ${white} whites`;
            const MAX_ATTEMPT = 10;
            let result = "continue";
            if (black === proposedCombination.length) {
                result = "success"
            } else {
                if (attempts.length == MAX_ATTEMPT) {
                    result = "finished"
                }
            }
            return result;

            function checkProposedCombination(secretCombination, proposedCombination) {
                let black = 0;
                let white = 0;
                for (let i = 0; i < secretCombination.length; i++) {
                    if (secretCombination[i] === proposedCombination[i]) {
                        black++;
                    } else {
                        if (searchValueInArray(proposedCombination[i], secretCombination)) {
                            white++;
                        }
                    }
                }
                return [black, white];
            }
        }

        function showResult(result) {
            if (result === "success") {
                console.writeln("You've won!!! ;-)");
            }
            else if (result === "finished") {
                console.writeln("You've lost!!! :-(");
            }
        }
    }

    function isResumed() {
        let result;
        let answer;
        let error = false;
        do {
            answer = console.readString(`Do you want to continue? (y/n): `);
            result = answer === `y`;
            error = !result && answer !== `n`;
            if (error) {
                console.writeln(`Please, reply "y" or "n"`);
            }
        } while (error);
        return result;
    }
} 