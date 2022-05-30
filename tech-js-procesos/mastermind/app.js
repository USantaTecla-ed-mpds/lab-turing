const { Console } = require("console-mpds");
const console = new Console();
playMastermind();

function playMastermind() {
    do {
        start();
    } while (isResumed());

    function start(){
        const COLORS = ['r','g','y','b','m','c'];
        const SECRECT_COMBINATION_LENGHT=4;
        const secretCombination = getSecretCombination(COLORS,SECRECT_COMBINATION_LENGHT);
        let proposedCombinations = [];
        let finished; 
        showBoard(proposedCombinations);
        do{
            finished = proposeCombination(secretCombination, proposedCombinations, COLORS);
        } while(!finished);
    }

    function isResumed(){
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

    function proposeCombination(secretCombination, proposedCombinations, COLORS){
        let proposedCombination;
        let correctProposedCombination;
        do{
            proposedCombination = console.readString(`Propose a combination: `);
            correctProposedCombination = validateProposedCombination(proposedCombination, COLORS, secretCombination.length);
        } while(!correctProposedCombination);

        let success = checkProposedCombination(secretCombination, proposedCombination, proposedCombinations);
        showBoard(proposedCombinations);
        return showResult(proposedCombinations, success);
    }

    function getSecretCombination(COLORS, SECRECT_COMBINATION_LENGHT){
        //TODO: buscar cuatro colores random de COLORS
        return "bycr";
    }

    function showBoard(proposedCombinations) {
        const attemptText = `${proposedCombinations.length} attempt(s):`;
        const secretCombinationText = `****`;
        const proposedCombinationResults = getProposedCombinationsResults(proposedCombinations);
        let msg = `\n${attemptText}\n${secretCombinationText}${ proposedCombinationResults ? `${proposedCombinationResults}`: ``}`;
        console.writeln(msg);
    }

    function getProposedCombinationsResults(proposedCombinations){
        result = ""
        for(let i=0; i< proposedCombinations.length; i++){
            result += `\n${proposedCombinations[i]}`;
        }
        return result;
    }

    function showResult(proposedCombinations, success){
        const MAX_ATTEMPT=10;
        const SUCCESS_ATTEMPT= "You've won!!! ;-)";
        const MAX_ATTEMPT_REACHED="You've lost!!! :-(";
        if(success){
            console.writeln(SUCCESS_ATTEMPT);
            return success;
        } else {
            let finished = proposedCombinations.length == MAX_ATTEMPT;
            if(finished){
                console.writeln(MAX_ATTEMPT_REACHED);
            }
            return finished;
        }
    }

    function validateProposedCombination(proposedCombination, COLORS, secretCombinationLength){
        const WRONG_LENGTH_ERROR = `Wrong proposed combination length`;
        const WRONG_COLOR_ERROR = `Wrong colors, they must be: ${writeColors(COLORS)}`;
        const REPEATED_COLOR_ERROR = `Wrong proposed combination, at least one color is repeated`;
        let correct = proposedCombination.length === secretCombinationLength;
        if(!correct){
            console.writeln(WRONG_LENGTH_ERROR);
        }
        for(let i=0; i<proposedCombination.length && correct; i++){
            correct = isAColor(proposedCombination[i], COLORS);
            if(!correct){
                console.writeln(WRONG_COLOR_ERROR);
            } else {
                correct = !isRepeated(proposedCombination[i], proposedCombination, i);
                if(!correct){
                    console.writeln(REPEATED_COLOR_ERROR);
                }    
            }
        }
        return correct;
    }

    function isAColor(value, COLORS){
        let found = false;
        for (let i = 0; i < COLORS.length && !found; i++) {
            found = COLORS[i] === value;
        }
        return found;
    }

    function writeColors(COLORS){
        let colorsText = "";
        for (let i = 0; i < COLORS.length; i++) {
            colorsText += COLORS[i];
        }
        return colorsText;
    }

    function checkProposedCombination(secretCombination, proposedCombination, proposedCombinations){
        let black=0;
        let white=0;
        for(let i=0; i<secretCombination.length; i++){
            if(secretCombination[i]===proposedCombination[i]){
                black++;
            }else{
                if(isOnSecretCombination(proposedCombination[i], secretCombination)){
                    white++;
                }
            }
        }
        proposedCombinations[proposedCombinations.length]=proposedCombination + ` --> ${black} blacks and ${white} whites`;
        return black === secretCombination.length;
    }

    function isRepeated(color, proposedCombination, indexColor){
        let repeated=false;
        for(let i=0; i<proposedCombination.length && !repeated; i++){
            repeated = proposedCombination[i]===color && i!==indexColor;
        }
        return repeated;
    }

    function isOnSecretCombination(color, secretCombination){
        let found=false;
        for(let i=0; i<secretCombination.length && !found; i++){
            found = secretCombination[i]===color;
        }
        return found;
    }
} 