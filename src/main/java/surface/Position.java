package surface;

import lombok.Data;

@Data
public class Position {
    private int positionX, positionY;
    private char direction;

    public Position() {
        positionX = 0;
        positionY = 0;
        direction = Directions.NORTH.value;
    }

    public Position(int x, int y, char c) {
        positionX = x;
        positionY = y;
        direction = c;
    }

    public Position(int x, int y) {
        positionX = x;
        positionY = y;
        direction = Directions.NORTH.value;
    }

    public void goWest(boolean changeDirection) {
        this.direction = changeDirection ? Directions.WEST.value : this.direction;
        this.positionX--;
    }

    public void goNorth(boolean changeDirection) {
        this.direction = changeDirection ? Directions.NORTH.value : this.direction;
        this.positionY--;
    }

    public void goEast(boolean changeDirection) {
        this.direction = changeDirection ? Directions.EAST.value : this.direction;
        this.positionX++;
    }

    public void goSouth(boolean changeDirection) {
        this.direction = changeDirection ? Directions.SOUTH.value : this.direction;
        this.positionY++;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", positionX, positionY);
    }
}
