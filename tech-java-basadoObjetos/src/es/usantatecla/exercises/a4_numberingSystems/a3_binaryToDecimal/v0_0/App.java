package es.usantatecla.exercises.a4_numberingSystems.a3_binaryToDecimal.v0_0;

import es.usantatecla.utils.Console;

public class App {

    public static void main(String[] args) {
        Console console = new Console();
        boolean ok = false;
        int binary;
        do{
            binary = console.readInt("Dame un número inferior a 32 (2^5) en binario (0/1): ");
            if(binary<=11111){
                ok=true;
            }
            else{
                console.writeln("¡¡¡Error número>32!!!");
            }
        }while (!ok);
        String msg = "El número " + binary + " binario corresponde con ";
        int decimal = 0;
        final int firstBit = binary % 10;
        decimal = decimal + firstBit;
        binary = binary - firstBit;
        binary = binary / 10;
        final int secondBit = binary % 10;
        decimal = decimal + secondBit * 2;
        binary = binary - secondBit;
        binary = binary / 10;
        final int thirdBit = binary % 10;
        decimal = decimal + thirdBit * 4;
        binary = binary - thirdBit;
        binary = binary / 10;
        final int fourthBit = binary % 10;
        decimal = decimal + fourthBit * 8;
        binary = binary - fourthBit;
        binary = binary / 10;
        final int fifthBit = binary;
        decimal = decimal + fifthBit * 16;
        binary = binary - fifthBit;
        msg = msg + "el número " + decimal + " decimal";
        console.writeln(msg);
    }

}
