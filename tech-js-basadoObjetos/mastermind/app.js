const { Console } = require("console-mpds");
const console = new Console();
playMastermind();

function playMastermind() {
  do {
    playGame();
  } while (isResumed());

  function playGame() {
    let game = initGame();
    showBoard(game);
    do {
      setAttempt(game);
      getProposedCombination(game);
      checkProposedCombination(game);
      showBoard(game);
    } while (!checkEndGame(game));
    showGameResult(game);
  }

  function initGame() {
    let game = {
        COLORS: "rgybmc",
        COMBINATION_LENGHT: 4,
        MAX_ATTEMPT: 10,
        secretCombination: "",
        attempts: [],
        states: { PLAYER_LOOSE: 0, PLAYER_WIN: 1, PLAYER_CONTINUE: 2 }
    }
    game.secretCombination = generateSecretCombination(game.COLORS, game.COMBINATION_LENGHT);
    console.writeln(`----- MASTERMIND -----`);
    return game;

    function generateSecretCombination(COLORS, COMBINATION_LENGHT) {
        let secretCombination = "";
        for (let i = 0; i < COMBINATION_LENGHT; i++) {
          let repeated;
          do {
            let randomColor = COLORS[parseInt(Math.random() * COLORS.length)];
            repeated = searchColor(randomColor, secretCombination);
            if (!repeated) {
              secretCombination += randomColor;
            }
          } while (repeated);
        }
        return secretCombination;
    }
  }

  function searchColor(color, values) {
    for (let i = 0; i < values.length; i++) {
      if (values[i] === color) {
        return true;
      }
    }
    return false;
  }

  function showBoard({attempts}) {
    console.writeln(`\n${attempts.length} attempt(s):\n****`);
    for (let i = 0; i < attempts.length; i++) {
      console.writeln(`${attempts[i].proposedCombination} --> ${attempts[i].black} blacks and ${attempts[i].white} whites`);
    }
  }

  function setAttempt(game){
    game.attempts[game.attempts.length] = getAttempt();

    function getAttempt(){
        let attempt = {
            proposedCombination: "",
            black:0,
            white:0,
            result: ""
        }
        return attempt;
    }
  }

  function getProposedCombination(game) {
    let attempt = getLastAttempt(game);
    let correctProposedCombination;
    do {
      attempt.proposedCombination = console.readString(`Propose a combination: `);
      let errors = checkErrorsInProposedCombination(attempt.proposedCombination, game.COMBINATION_LENGHT, game.COLORS);
      correctProposedCombination = errors.length === 0;
      if (!correctProposedCombination) {
        showErrorMessage(errors);
      }
    } while (!correctProposedCombination);

    function checkErrorsInProposedCombination(proposedCombination, COMBINATION_LENGHT, COLORS) {
      let errorCodes = getErrorCodes(COLORS);
      let errors = [];
      if (proposedCombination.length !== COMBINATION_LENGHT) {
        errors[errors.length] = errorCodes.WRONG_LENGTH_ERROR;
      }
      if (!validateColors(proposedCombination, COLORS)) {
        errors[errors.length] = errorCodes.WRONG_COLOR_ERROR;
      }
      if (!validateUniqueColors(proposedCombination)) {
        errors[errors.length] = errorCodes.REPEATED_COLOR_ERROR;
      }
      return errors;

      function getErrorCodes(COLORS){
        let errorCodes = {
          WRONG_LENGTH_ERROR: `Wrong proposed combination length`,
          WRONG_COLOR_ERROR: `Wrong colors, they must be: ${COLORS}`, 
          REPEATED_COLOR_ERROR: `Wrong proposed combination, at least one color is repeated` 
        }
        return errorCodes;
      }

      function validateColors(proposedCombination, COLORS) {
        let validColor = true;
        for (let i = 0; validColor && i < proposedCombination.length; i++) {
          validColor = searchColor(proposedCombination[i], COLORS);
        }
        return validColor;
      }

      function validateUniqueColors(proposedCombination) {
        let uniqueColor = true;
        for (let i = 0; uniqueColor && i < proposedCombination.length; i++) {
          for (let j = i + 1; uniqueColor && j < proposedCombination.length; j++) {
            uniqueColor = proposedCombination[j] !== proposedCombination[i];
          }
        }
        return uniqueColor;
      }
    }

    function showErrorMessage(errors) {
      for (let i = 0; i < errors.length; i++) {
        console.writeln(errors[i]);
      }
    }
  }
  function getLastAttempt(game){
    return game.attempts[game.attempts.length-1];
 }
  function checkProposedCombination(game) {
    let attempt = getLastAttempt(game);
     for (let i = 0; i < game.COMBINATION_LENGHT; i++) {
      if (game.secretCombination[i] === attempt.proposedCombination[i]) {
        attempt.black++;
      } else {
        if (searchColor(attempt.proposedCombination[i], game.secretCombination)) {
            attempt.white++;
        }
      }
    }
  }

  function checkEndGame(game) {
    let attempt = getLastAttempt(game);
    if (attempt.black === game.COMBINATION_LENGHT) {
        attempt.result = game.states.PLAYER_WIN;
    } else if (game.attempts.length === game.MAX_ATTEMPT) {
        attempt.result = game.states.PLAYER_LOOSE;
    } else{
        attempt.result = game.states.PLAYER_CONTINUE;
    }
    return attempt.result!==game.states.PLAYER_CONTINUE;
  }

  function showGameResult(game) {
    const MESSAGES = ["You've lost!!! :-(", "You've won!!! ;-)"];
    let result = getLastAttempt(game).result;
    console.writeln(MESSAGES[result]);
    if(result===game.states.PLAYER_LOOSE){
        console.writeln(`The secret combination was ${game.secretCombination}`);
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