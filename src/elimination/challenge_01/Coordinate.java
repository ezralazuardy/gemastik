package elimination.challenge_01;

import java.awt.geom.Point2D;

/**
 * <h3>Coordinate class</h3>
 * Used to encapsulate a coordinate location of an element
 * with Point2D
 * <p>
 * <h3>Author</h3>
 * Ezra Lazuardy<br/>
 * <a href="mailto:ezralucio@gmail.com">ezralucio@gmail.com</a><br/>
 * <a href="https://ezralazuardy.com">https://ezralazuardy.com</a>
 * </p>
 */
public class Coordinate extends Point2D {

    private double x;
    private double y;

    /**
     * Coordinate constructor
     *
     * @param x double
     * @param y double
     */
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get <code>x</code> coordinate location
     *
     * @return double
     */
    @Override
    public double getX() {
        return this.x;
    }

    /**
     * Get <code>y</code> coordinate location
     *
     * @return double
     */
    @Override
    public double getY() {
        return this.y;
    }

    /**
     * Update <code>x</code> and <code>y</code> coordinate location
     *
     * @param x double
     * @param y double
     */
    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
