package surface;

public interface Surface<T> {
    void init();
    void startMovingObject();
    Position applyMovementCommand(T command, Position position);
}

enum Directions {
    NORTH('N'), EAST('E'), SOUTH('S'), WEST('W');

    char value;

    Directions(char value) {
        this.value = value;
    }

    static Directions getValue(char direction) {
        if (direction == 'N') return NORTH;
        else if (direction == 'E') return EAST;
        else if (direction == 'S') return SOUTH;
        else if (direction == 'W') return WEST;
        else throw new IllegalArgumentException(String.format("%s is not a valid direction!", direction));
    }
}