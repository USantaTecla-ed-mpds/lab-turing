package usantatecla.tictactoe.views;

import java.util.List;

class Conversor {

    String arrayToString(Object[] objects) {
        String string = "";
        for (Object object : objects) {
            string += object;
        }
        return string;
    }

    void reorder(List<String> list) {
        list.add(list.size() - 1, list.remove(1));
    }

}
