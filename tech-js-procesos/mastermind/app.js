const { Console } = require("console-mpds");
const console = new Console();
playMastermind();

function playMastermind() {
    do {
        playGame();
    } while (isResumed());

    function playGame(){
        const COLORS = ['r','g','y','b','m','c'];
        const secretCombination = generateSecretCombination(COLORS);
        console.writeln(secretCombination); //Depurando
        let attempts = [];
        let finished; 
        showBoard(attempts);
        do{
            const proposedCombination = getProposedCombination(secretCombination.length, COLORS);
            const result = checkProposedCombination(secretCombination, proposedCombination);
            finished = showAttemptResult(proposedCombination, attempts, result);
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

    function generateSecretCombination(COLORS){
        const COMBINATION_LENGHT=4;
        let secretCombinationArray = [];
        for (let i = 0; i < COMBINATION_LENGHT; i++) {
            let randomColor;
            let repeated; 
            do {
                randomColor= COLORS[parseInt(Math.random() * COLORS.length)];
                repeated=searchValueInArray(randomColor,secretCombinationArray);
                if(!repeated){
                    secretCombinationArray[i]=randomColor;
                }
            }while(repeated)
		}
        return arrayToString(secretCombinationArray);
    }

    function showBoard(attempts) {
        const attemptText = `${attempts.length} attempt(s):`;
        const secretCombinationText = `****`;
        const attemptsLines = getAttemptsLines(attempts);
        console.writeln(`\n${attemptText}\n${secretCombinationText}${ attemptsLines.length!==0 ? `${attemptsLines}`: ``}`);
    }

    function getAttemptsLines(attempts){
        let lines = ""
        for(let i=0; i< attempts.length; i++){
            lines += `\n${attempts[i]}`;
        }
        return lines;
    }

    function getProposedCombination(combinationLength, COLORS){
        let proposedCombination;
        let correctProposedCombination;
        do{
            proposedCombination = console.readString(`Propose a combination: `);
            correctProposedCombination = validateProposedCombination(proposedCombination, COLORS, combinationLength);
        } while(!correctProposedCombination);
        return proposedCombination;
    }

    function validateProposedCombination(proposedCombination, COLORS, combinationLength){
        const WRONG_LENGTH_ERROR = `Wrong proposed combination length`;
        const WRONG_COLOR_ERROR = `Wrong colors, they must be: ${arrayToString(COLORS)}`;
        const REPEATED_COLOR_ERROR = `Wrong proposed combination, at least one color is repeated`;
        let correct = proposedCombination.length === combinationLength;
        if(!correct){
            console.writeln(WRONG_LENGTH_ERROR);
        }
        else {
            for(let i=0; correct && i<proposedCombination.length; i++){
                correct = searchValueInArray(proposedCombination[i], COLORS);
            }
            if(!correct){
                console.writeln(WRONG_COLOR_ERROR);
            } 
            else {
                correct = !hasRepeatedCharacter(proposedCombination);
                if(!correct){
                console.writeln(REPEATED_COLOR_ERROR);
                }    
            }
        }
        return correct;
    }

    function arrayToString(arraySource){
        let stringTarget = "";
        for (let i = 0; i < arraySource.length; i++) {
            stringTarget += arraySource[i];
        }
        return stringTarget;
    }

    function searchValueInArray(value, arraySource){
        let found = false;
        for (let i = 0; i < arraySource.length && !found; i++) {
            found = arraySource[i] === value;
        }
        return found;
    }

    function hasRepeatedCharacter(combinationString){
        let repeated=false;
        for(let i in combinationString){
            for(let j=0;!repeated && j<combinationString.length; j++){
               if(j!=i){
                   repeated = combinationString[j]===combinationString[i];
               }
            }
        }
        return repeated;
    }

    function checkProposedCombination(secretCombination, proposedCombination){
        let black=0;
        let white=0;
        for(let i=0; i<secretCombination.length; i++){
            if(secretCombination[i]===proposedCombination[i]){
                black++;
            }else{
                if(searchValueInArray(proposedCombination[i], secretCombination)){
                    white++;
                }
            }
        }
        return [black, white];
    }

    function showAttemptResult(proposedCombination, attempts, result){
        let [black, ...white] = result;
        attempts[attempts.length] = proposedCombination + ` --> ${black} blacks and ${white} whites`;
        showBoard(attempts);
        
        const MAX_ATTEMPT=10;
        const SUCCESS_ATTEMPT= "You've won!!! ;-)";
        const MAX_ATTEMPT_REACHED="You've lost!!! :-(";
        let success = black === proposedCombination.length;
        if(success){
            console.writeln(SUCCESS_ATTEMPT);
            return success;
        } else {
            let finished = attempts.length == MAX_ATTEMPT;
            if(finished){
                console.writeln(MAX_ATTEMPT_REACHED);
            }
            return finished;
        }
    }
} 