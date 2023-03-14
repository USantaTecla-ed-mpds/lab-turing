package main.es.pbover.connect4;

public class Connect4 {

    private String title;

    public Connect4(){
        this.title = "Connect4";
    }

    public static void main(String[] args) {
        new Connect4().run();
    }

    private void run(){
        assert this.title.equals("Connect4") : "assert boom!!";

        System.out.println("funciona!");
    }
    
}
