package es.usantatecla.exercises.a5_changeCoins.v1_2;

import es.usantatecla.utils.Console;

public class App {

    public static void main(String[] args) {
        Console console = new Console();
        int amount = console.readInt("Dame la cantidad de céntimos: ");
        final int[] COINS = new int[]{50, 20, 10, 5, 2, 1};
        String msg = "";
        for (int i = 0; i < COINS.length; i++) {
          final int remainder = amount - amount % COINS[i];
          amount -= remainder;
          final int coins = remainder / COINS[i];
          msg += coins > 0 ? coins+" moneda(s) de "+COINS[i]+"\n" : "";
        }
        console.writeln(msg);
    }
}

