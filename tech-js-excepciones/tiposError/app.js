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
                throw new MyRangeError("descripcion");
            }
            if (Math.random() < 0.5) {
                throw new CustomError("descripcion");
            }
            if (Math.random() < 0.5) {
                throw new AssertionError("descripcion");
            }
            console.log("Sentencia ejecutada?");
        } catch (exception) {
            exception.accept(this);
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
        console.log("Acciones catch: " + assertionError.name + ": " + assertionError.message);
    }

}

const errorThrower = new ErrorThrower()

for (let i = 0; i < 10; i++) {
    errorThrower.interact();
}