package es.usantatecla.coordinate;

public class Coordinate2D {

    public Coordinate2D() {
    }

    public Coordinate2D(int ordinate, int abscissa) {
    }

    public Coordinate2D(double ordinate, double abscissa) {
    }

    public void shift(Coordinate2D shiftment) {
    }

    public Coordinate2D shifted(Coordinate2D shiftment) {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public boolean isOrdinateValid() {
        return true;
    }

    public boolean isAbscissaValid() {
        return true;
    }

    public Coordinate2D orginSymetric() {
        return null;
    }

    public Coordinate2D axisSymetric() {
        return null;
    }

    public boolean equals(Coordinate2D coordinate) {
        return null;
    }

    public boolean equalsOrdinate(Coordinate2D coordinate) {
        return true;
    }

    public boolean equalsAbscissa(Coordinate2D coordinate) {
        return true;
    }

    public void setOrigin(Coordinate2D origin) {
    }

    public Coordinate2D getOrigin() {
        return null;
    }

    public double getOrdinate() {
        return 0.0;
    }

    public double getAbscissa() {
        return 0.0;
    }
}
