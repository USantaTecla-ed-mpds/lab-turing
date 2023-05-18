package main.es.labturing.utils.framework;

public abstract class GameApp<L extends Logic, V extends ControllersVisitor> {

    protected L logic;
    protected V gameView;

    protected void interact() {
        AcceptorController acceptorController;
        do {
            acceptorController = this.logic.getController();
            if (acceptorController != null)
                acceptorController.accept(this.gameView);
        } while (acceptorController != null);
    }

}
