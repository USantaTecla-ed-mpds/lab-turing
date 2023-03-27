package connect4.models;

import java.io.IOException;

import connect4.utils.exceptions.MessageNotFoundException;

public interface PlayerVisitor {
    void visit(HumanPlayer humanPlayer) throws MessageNotFoundException, ClassNotFoundException, IOException;

    void visit(RandomPlayer randomPlayer) throws MessageNotFoundException, ClassNotFoundException, IOException;

    void visit(MinMaxPlayer minMaxPlayer) throws MessageNotFoundException, ClassNotFoundException, IOException;

}
