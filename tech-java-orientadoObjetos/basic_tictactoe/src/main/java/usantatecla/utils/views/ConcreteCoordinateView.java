package usantatecla.utils.views;

import usantatecla.utils.models.ConcreteCoordinate;

public class ConcreteCoordinateView {

    public ConcreteCoordinate read(String title) {
        Console console = Console.getInstance();
        console.writeln(title);
        int row = console.readInt(ConcreteCoordinate.ROW) - 1;
        int column = console.readInt(ConcreteCoordinate.COLUMN) - 1;
        return new ConcreteCoordinate(row, column);
    }

}
