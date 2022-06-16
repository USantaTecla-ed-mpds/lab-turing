const { Console } = require("console-mpds");
const console = new Console();

playMasterMind();

function playMasterMind() {
  do {
    playGame();
  } while (isResumed());

  function playGame() {
    const COLORS_LIST = [`r`, `g`, `b`, `c`, `m`, `y`];
    const MAX_ATTEMPTS = 5; //10
    const LENGTH_COMBINATION = 4;
    const SECRET_COMBINATION = generateSecretCombination(
      COLORS_LIST,
      LENGTH_COMBINATION
    );
    let attempts = 0;
    let isTheWinner = false;
    let boardWithProposedCombinationsAndResults = ``;
    console.writeln(`\n----- MASTERMIND -----`);
    showBoard(
      attempts,
      boardWithProposedCombinationsAndResults,
      SECRET_COMBINATION
    );
    do {
      let proposedCombination = askingForValidCombination(
        COLORS_LIST,
        SECRET_COMBINATION
      );
      attempts++;
      let attemptResult = rateProposedCombination(
        proposedCombination,
        SECRET_COMBINATION
      );
      isTheWinner = attemptResult[0];
      let blacksWhitesTokens = attemptResult[1];
      boardWithProposedCombinationsAndResults += `\n${proposedCombination} --> ${blacksWhitesTokens[0]} negra(s) y ${blacksWhitesTokens[1]} blanca(s)`;
      showBoard(
        attempts,
        boardWithProposedCombinationsAndResults,
        SECRET_COMBINATION
      );
      if (isTheWinner || attempts === MAX_ATTEMPTS) {
        declareWinnerOrLoser(isTheWinner, SECRET_COMBINATION);
      }
    } while (!isTheWinner && attempts < MAX_ATTEMPTS);

    function generateSecretCombination(colorsList, lengthCombination) {
      let secretCombination = [];
      for (let i = 0; i < lengthCombination; i++) {
        let newElement;
        do {
          newElement = parseInt(Math.random() * colorsList.length);
        } while (
          includesColor(secretCombination, colorsList[newElement]) &&
          secretCombination.length < lengthCombination
        );
        secretCombination[secretCombination.length] = colorsList[newElement];
      }
      return secretCombination;
    }

    function includesColor(colorsCombination, color) {
      for (let i = 0; i < colorsCombination.length; i++) {
        if (colorsCombination[i] === color) {
          return true;
        }
      }
      return false;
    }

    function showBoard(
      attempts,
      boardWithProposedCombinationsAndResults,
      secretCombination
    ) {
      console.writeln(
        `\n${attempts} intento(s):\n${generateSecretCombinationStars()}${boardWithProposedCombinationsAndResults}`
      );

      function generateSecretCombinationStars() {
        let stars = "";
        for (let i = 0; i < secretCombination.length; i++) {
          stars += "*";
        }
        return stars;
      }
    }

    function askingForValidCombination(colorsList, secretCombination) {
      let errorCodeMsg;
      do {
        proposedCombination = console.readString(`Propón una combinación: `);
        errorCodeMsg = checkErrorsInProposedCombination(
          proposedCombination,
          colorsList,
          secretCombination
        );
        if (errorCodeMsg != -1) {
          showErrorMessage(errorCodeMsg, colorsList, secretCombination);
        }
      } while (errorCodeMsg != -1);
      return proposedCombination;
    }

    function showErrorMessage(errorCodeMsg, colorsList, secretCombination) {
      const ERROR_CODE_MESSAGES = [
        `-> Longitud incorrecta de la combinación propuesta, debe ser de ${secretCombination.length} caracteres.`,
        `-> Combinación propuesta incorrecta, al menos, un color está repetido.`,
        `-> Colores incorrectos, deben ser: ${colorsList}.`,
      ];
      console.writeln(ERROR_CODE_MESSAGES[errorCodeMsg]);
    }

    function checkErrorsInProposedCombination(
      proposedCombination,
      colorsList,
      secretCombination
    ) {
      let errorCodeMsg = -1;
      if (!checkLengthCombination(proposedCombination, secretCombination))
        errorCodeMsg = 0;
      else if (!checkNoRepeatColorInCombination(proposedCombination))
        errorCodeMsg = 1;
      else if (!checkValidColorsInCombination(proposedCombination, colorsList))
        errorCodeMsg = 2;
      return errorCodeMsg;

      function checkLengthCombination(proposedCombination, secretCombination) {
        if (proposedCombination.length != secretCombination.length) {
          return false;
        }
        return true;
      }

      function checkNoRepeatColorInCombination(proposedCombination) {
        let repeated = false;
        for (let i = 0; !repeated && i < proposedCombination.length; i++) {
          for (
            let j = i + 1;
            !repeated && j < proposedCombination.length;
            j++
          ) {
            repeated = proposedCombination[j] === proposedCombination[i];
          }
        }
        return !repeated;
      }

      function checkValidColorsInCombination(proposedCombination, colorsList) {
        for (let i = 0; i < proposedCombination.length; i++) {
          if (!includesColor(colorsList, proposedCombination[i])) {
            return false;
          }
        }
        return true;
      }
    }

    function rateProposedCombination(proposedCombination, secretCombination) {
      let blackTokens = 0;
      let whiteTokens = 0;
      for (let i = 0; i < secretCombination.length; i++) {
        if (proposedCombination[i] === secretCombination[i]) {
          blackTokens++;
        } else if (includesColor(secretCombination, proposedCombination[i])) {
          whiteTokens++;
        }
      }
      if (proposedCombination === arrayToString(secretCombination)) {
        return [true, [blackTokens, whiteTokens]];
      }
      return [false, [blackTokens, whiteTokens]];
    }

    function declareWinnerOrLoser(isTheWinner, secretCombination) {
      if (isTheWinner) {
        console.writeln(`\n¡¡Has ganado!! ¡Enhorabuena!`);
      } else {
        console.writeln(
          `\n¡¡Has perdido!! Sobrepasaste tu límite de intentos.`
        );
        console.writeln(`Código SECRETO: ${arrayToString(secretCombination)}`);
      }
    }

    function arrayToString(arraySource) {
      let stringTarget = "";
      for (let i = 0; i < arraySource.length; i++) {
        stringTarget += arraySource[i];
      }
      return stringTarget;
    }
  }

  function isResumed() {
    let result;
    let error = false;
    do {
      let answer = console.readString(`¿Quieres seguir jugando? (s/n)`);
      result = answer === `s`;
      error = !result && answer !== `n`;
      if (error) {
        console.writeln(`Por favor, responde "s" o "n"`);
      }
    } while (error);
    return result;
  }
}