package battleships;

import java.awt.geom.Rectangle2D;

public class Ship {

    private String name;
    private String code;
    protected int squareCount;
    private boolean horizontal;
    protected int x;
    protected int y;
    private int hits;

    public Ship(String name, String code, int squareCount) {
        this.name = name;
        this.code = code;
        this.squareCount = squareCount;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setLocation(int x, int y) {
        this.x = x; this.y = y;
    }



    public int getWidth() {
        if (this.horizontal) {
            return this.squareCount;
        } else {
            return 1;
        }
    }

    public int getHeight() {
        if (this.horizontal) {
            return 1;
        } else {
            return this.squareCount;
        }
    }

    public boolean overlap(final Ship other) {
        final Rectangle2D rectThis = new Rectangle2D.Double(this.x, this.y, this.getWidth(), this.getHeight());
        final Rectangle2D rectOther = new Rectangle2D.Double(other.x, other.y, other.getWidth(), other.getHeight());
        final Rectangle2D intersection = rectThis.createIntersection(rectOther);
        return (intersection.getWidth() >= 0) && (intersection.getHeight() >= 0);
    }

    public boolean incrementHitCount() {
        if (this.hits < this.squareCount) {
            this.hits++;
        }
        return (this.hits == this.squareCount);
    }

    public boolean isSunk() {
        return (this.hits == this.squareCount);
    }







    public void addToBoard(final Board board) {
        if (this.horizontal) {
            for(int x = 0; x < this.squareCount; x++) {
                board.getSquare(x + this.x, this.y).setShip(this);
            }
        } else {
            for(int y = 0; y < this.squareCount; y++) {
                board.getSquare(this.x, y + this.y).setShip(this);
            }
        }
    }
}
