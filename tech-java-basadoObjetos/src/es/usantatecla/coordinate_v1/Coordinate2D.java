package es.usantatecla.coordinate_v1;

public class Coordinate2D {

    private double abscissa;
    private double ordinate;

    public Coordinate2D() {
        this.abscissa = 0;
        this.ordinate = 0;
    }

    public Coordinate2D(double abscissa, double ordinate) {
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

    public Coordinate2D clone() {
        return new Coordinate2D(this.abscissa, this.ordinate);
    }

    public Coordinate2D shifted(Coordinate2D shiftment) {
        return new Coordinate2D(this.abscissa + shiftment.abscissa, this.ordinate + shiftment.ordinate);
    }

    public Coordinate2D originSymetric() {
        return new Coordinate2D(-this.abscissa, -this.ordinate);
    }

    public Coordinate2D axisSymetric(String axis) {
        if (axis == "abscissa") {
            return new Coordinate2D(this.abscissa, -this.ordinate);
        }
        if (axis == "ordinate"){
            return new Coordinate2D(-this.abscissa, this.ordinate);
        }
        return null;

    }

    public boolean equals(Coordinate2D coordinate) {
        return this.abscissa == coordinate.abscissa && this.ordinate == coordinate.ordinate;
    }

    public double getAbscissa() {
        return this.abscissa;
    }

    public double getOrdinate() {
        return this.ordinate;
    }

}
