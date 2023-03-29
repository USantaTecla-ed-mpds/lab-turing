public class GenericGame <E> {
  

        private Game game;
        private GameView gameView;
    
        public Connect4() {
            this.game = new Game();
            this.gameView = new GameView(this.game);
    
        }
    
        private void play() {
            do {
                this.gameView.start();
                this.gameView.play();
            } while (this.gameView.resume());
        }
    
        public static void main(final String[] args) {
            new Connect4().play();
        }
    
    
}
