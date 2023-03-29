package connect4.views;

import java.io.IOException;
import connect4.utils.exceptions.MessageNotFoundException;

public interface ColumnablePlayer {
    public int getColumn() throws MessageNotFoundException, ClassNotFoundException, IOException;
}