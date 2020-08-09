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

    @Override
    public String toString() {
        return String.format("[%d, %d]", positionX, positionY);
    }
}
