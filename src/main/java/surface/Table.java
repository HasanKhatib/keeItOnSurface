package surface;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Table implements Surface<Integer> {
    Scanner scanner = new Scanner(System.in);
    // Table dimensions
    int xDimension, yDimension;
    Position objPosition = new Position();
    List<Integer> commandsList;

    @Override
    public void init() {
        System.out.printf("Starting position is: %s facing %s\n", objPosition.toString(), objPosition.getDirection());
        // Setting up the table!
        System.out.println("Enter the table dimensions & the starting position ({tableX}, {tableY}, {objectX}, {objectY})");
        String[] dimensions = scanner
                .nextLine()
                .replaceAll("\\s+", "")
                .split(",");
        xDimension = Integer.parseInt(dimensions[0]);
        yDimension = Integer.parseInt(dimensions[1]);
        objPosition.setPositionX(Integer.parseInt(dimensions[2]));
        objPosition.setPositionY(Integer.parseInt(dimensions[3]));

        validatePosition(objPosition);

        // Fetch movement commands!
        System.out.println("Enter movement commands (a combination of integers from 0 to 4)");
        commandsList = Arrays.stream(scanner
                .nextLine()
                .split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    @Override
    public void startMovingObject() {
        // Apply movement commands
        for (int command : commandsList)
            objPosition = applyMovementCommand(command, objPosition);

        // Report final position
        System.out.printf("%d %d %c\n",
                objPosition.getPositionX(),
                objPosition.getPositionY(),
                objPosition.getDirection());
    }

    @Override
    public Position applyMovementCommand(Integer command, Position position) {
        if (command > 4 || command < 0)
            throw new IllegalArgumentException(String.format("Command %d is not supported!", command));

        if (command == 0) {
            System.out.println(position.toString());
            System.exit(0);
        }

        switch (position.getDirection()) {
            case 'N':
                if (command == 1) {
                    position.setPositionY(position.getPositionY() - 1);
                    position.setDirection(Directions.NORTH.value);
                } else if (command == 2) {
                    position.setPositionY(position.getPositionY() + 1);
                } else if (command == 3) {
                    position.setPositionX(position.getPositionX() + 1);
                    position.setDirection(Directions.EAST.value);
                } else {
                    position.setPositionX(position.getPositionX() - 1);
                    position.setDirection(Directions.WEST.value);
                }
                break;
            case 'E':
                if (command == 1) {
                    position.setPositionX(position.getPositionX() + 1);
                    position.setDirection(Directions.EAST.value);
                } else if (command == 2) {
                    position.setPositionX(position.getPositionX() - 1);
                } else if (command == 3) {
                    position.setPositionY(position.getPositionY() + 1);
                    position.setDirection(Directions.SOUTH.value);
                } else {
                    position.setPositionY(position.getPositionY() - 1);
                    position.setDirection(Directions.NORTH.value);
                }
                break;
            case 'S':
                if (command == 1) {
                    position.setPositionY(position.getPositionY() + 1);
                    position.setDirection(Directions.SOUTH.value);
                } else if (command == 2) {
                    position.setPositionY(position.getPositionY() - 1);
                } else if (command == 3) {
                    position.setPositionX(position.getPositionX() - 1);
                    position.setDirection(Directions.WEST.value);
                } else {
                    position.setPositionX(position.getPositionX() + 1);
                    position.setDirection(Directions.EAST.value);
                }
                break;
            case 'W':
                if (command == 1) {
                    position.setPositionX(position.getPositionX() - 1);
                    position.setDirection(Directions.WEST.value);
                } else if (command == 2) {
                    position.setPositionX(position.getPositionX() + 1);
                } else if (command == 3) {
                    position.setPositionY(position.getPositionY() - 1);
                    position.setDirection(Directions.NORTH.value);
                } else {
                    position.setPositionY(position.getPositionY() + 1);
                    position.setDirection(Directions.SOUTH.value);
                }
                break;
        }
        validatePosition(position);

        return position;
    }

    public void validatePosition(Position objPosition) {
        if (objPosition.getPositionX() < 0 || objPosition.getPositionX() >= getxDimension()
                || objPosition.getPositionY() < 0 || objPosition.getPositionY() >= getyDimension()) {
            System.out.println("[-1,-1]");
            throw new IndexOutOfBoundsException(String.format("Objects's position exceeded table dimensions! %s", objPosition.toString()));
        }
    }
    public int getxDimension() {
        return xDimension;
    }

    public int getyDimension() {
        return yDimension;
    }
}