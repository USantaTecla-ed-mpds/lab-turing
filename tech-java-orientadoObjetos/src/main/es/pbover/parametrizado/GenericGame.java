package main.es.pbover.parametrizado;

public class  GenericGame<G,V> {
  
        private G game;
        private V gameView;
    
        public GenericGame(G game, V gameView) {
            this.game = game;
            this.gameView = (V) new Object(G);
    
        }
    
        private void play() {
            do {
                this.gameView.start();
                this.gameView.play();
            } while (this.gameView.resume());
        }  
    
}

