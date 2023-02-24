package es.usantatecla.tictactoe_v2.main.views;

import es.usantatecla.tictactoe_v2.main.models.Turn;

public class TurnView {

    private Turn turn;
    private PlayerView[] playerViews;

    public TurnView(Turn turn){
        this.turn = turn;
        this.playerViews = new PlayerView[Turn.getNumberOfPlayers()];
        for (int i = 0; i < Turn.getNumberOfPlayers(); i++){
            this.playerViews[i]=new PlayerView(this.turn.getPlayer(i));
        }
    }

    public void play(){
        this.playerViews[this.turn.getActivePlayerIndex()].play();
        this.turn.play();
    }

    public void writeWinner() {
		this.playerViews[this.turn.getActivePlayerIndex()].writeWinner();
	}
    
}
