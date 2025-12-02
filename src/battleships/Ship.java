package battleships;

public class Ship {

    private String name;
    private String code;
    private int squareCount;
    private boolean horizontal;

    private int x;
    private int y;

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
    public void rotate() {
        this.horizontal = !this.horizontal;
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






    @Override
    public String toString()  {
        final StringBuilder builder = new StringBuilder();
        if (this.horizontal) {
            for(int x = 0; x < this.squareCount; x++) {
                builder.append("O");
            }
            builder.append("\n");
        } else {
            for(int y = 0; y < this.squareCount; y++) {
                builder.append("O\n");
            }
        }
        return builder.toString();
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
