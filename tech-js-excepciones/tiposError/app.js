class CustomError extends Error {
    constructor(description) {
        super(description);
        this.name = 'CustomError';
    }
    accept(visitor) {
        visitor.visitCustomError(this);
    }
}
class MyRangeError extends RangeError {
    constructor(description) {
        super(description);
        this.name = "MyRangeError";
    }
    accept(visitor) {
        visitor.visitMyRangeError(this);
    }

}
class AssertionError extends Error {

    constructor(description) {
        super(description);
        this.name = "AssertionError";
    }
    accept(visitor) {
        visitor.visitAssertionError(this);
    }
}

class ErrorVisitor {
    visitCustomError(customError) {
    }
    visitMyRangeError(myRangeError) {
    }
    visitAssertionError(assertionError) {
    }
}


class ErrorThrower extends ErrorVisitor {

    constructor() {
        super();
    }

    interact() {
        console.log(`Sentencia previa`);
        try {
            if (Math.random() < 0.5) {
                throw new MyRangeError("Error por fuera de rango la mitad de las veces");
            }
            if (Math.random() < 0.5) {
                throw new CustomError("Error que se provoca 1/4 de las veces");
            }
            if (Math.random() < 0.5) {
                throw new AssertionError("Error 1/8: Assert de validación");
            }
            if (Math.random() < 0.5) {
                throw "descuidado";
            }
            console.log("Sentencia ejecutada?");

        } catch (exception) {
            if(exception!=="descuidado"){  //Duda: como preguntar si la excepción no viene
                exception.accept(this);  //de ninguna derivada de la clase Error que admita el nuevo metodo accept
            }
            else{
             console.log("Acciones catch: descuidado");
            }
        }
        console.log(`Sentencia posterior`);
    }
    visitCustomError(customError) {
        console.log("Acciones catch: " + customError.name + ": " + customError.message);
    }
    visitMyRangeError(myRangeError) {
        console.log("Acciones catch: " + myRangeError.name + ": " + myRangeError.message);
    }
   visitAssertionError(assertionError) {
        console.log("Acciones catch: " + assertionError.name + ": " + assertionError.message); //No estaría cumpliendo con la teoría de Assertion.
    }

}

const errorThrower = new ErrorThrower()

for (let i = 0; i < 10; i++) {
    errorThrower.interact();
}