const { Console } = require("console-mpds");
const console = new Console();
playMastermind();

function playMastermind() {
    do {
        let game = {
            COLORS: ['r', 'g', 'y', 'b', 'm', 'c'],
            COMBINATION_LENGHT: 4,
            MAX_ATTEMPT: 10,
            secretCombination: '',
            attempts: [],
            blacksAndWhites: []
        }
        playGame(game);
    } while (isResumed());

    function playGame(game) {
        let isNotFinished = false;
        game.secretCombination = generateSecretCombination(game);
        console.writeln(`----- MASTERMIND -----`);
        console.writeln(`\n0 attempt(s):\n****`);
        do {
            game.attempts[game.attempts.length] = getCorrectProposedCombination(game);
            game.blacksAndWhites[game.blacksAndWhites.length] = getProposedCombinationResult(game);
            showBoard(game);
            isNotFinished = game.blacksAndWhites[game.blacksAndWhites.length - 1][0] < game.COMBINATION_LENGHT && game.attempts.length < game.MAX_ATTEMPT;
        } while (isNotFinished);
        console.writeln(`You've ${game.attempts.length < game.MAX_ATTEMPT ? "won!!! ;-)" : "lost!!! :-("}`);

        function generateSecretCombination(game) {
            let secretCombination = [];
            for (let i = 0; i < game.COMBINATION_LENGHT; i++) {
                let repeated;
                do {
                    let randomColor = game.COLORS[parseInt(Math.random() * game.COLORS.length)];
                    repeated = searchValueInArray(randomColor, secretCombination);
                    if (!repeated) {
                        secretCombination[i] = randomColor;
                    }
                } while (repeated)
            }
            return arrayToString(secretCombination);
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

        function getCorrectProposedCombination(game) {
            let proposedCombination;
            let errorCodeInCombination;
            do {
                proposedCombination = console.readString(`Propose a combination: `);
                errorCodeInCombination = checkErrorsInProposedCombination(proposedCombination, game.COLORS, game.COMBINATION_LENGHT);
                if (errorCodeInCombination > 0) {
                    showError(errorCodeInCombination, game.COLORS);
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

        function getProposedCombinationResult(game) {
            const proposedCombination = game.attempts[game.attempts.length - 1];
            let blacks = 0;
            let whites = 0;
            for (let i = 0; i < game.secretCombination.length; i++) {
                if (game.secretCombination[i] === proposedCombination[i]) {
                    blacks++;
                } else {
                    if (searchValueInArray(proposedCombination[i], game.secretCombination)) {
                        whites++;
                    }
                }
            }
            return [blacks, whites];
        }

        function showBoard(game) {
            console.writeln(`\n${game.attempts.length} attempt(s):\n****`);
            for (let i = 0; i < game.attempts.length; i++) {
                console.writeln(`${game.attempts[i]}  --> ${game.blacksAndWhites[i][0]} blacks and ${game.blacksAndWhites[i][1]} whites`);
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