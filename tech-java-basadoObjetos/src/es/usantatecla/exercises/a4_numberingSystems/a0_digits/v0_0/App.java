package es.usantatecla.exercises.a4_numberingSystems.a0_digits.v0_0;

import es.usantatecla.utils.Console;

public class App {

    public static void main(String[] args) {
        Console console = new Console();
        int number = console.readInt("Dame un número entero (<1000): ");
        final int ones = number % 10;
        number = number - ones;
        number = number / 10;
        final int tens = number % 10;
        number = number - tens;
        number = number / 10;
        final int hundreds = number % 10;
        console.writeln("Unidades: " + ones + "\nDecenas: " + tens + "\nCentenas: " + hundreds);
    }
}
