import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        App app = new App();
        app.start();
    }

    Integer[][] currentGrid = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},//{0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},//{0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
        {1, 1, 1, 0, 0, 0, 0, 0, 0, 0},//{0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
        {1, 1, 1, 1, 0, 0, 0, 0, 0, 0},//{0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},//{0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
    };
    Integer[][] newGrid = currentGrid;
    int width = currentGrid.length;

    /*
    yStart;
    xStart;
    yEnd;
    xEnd;
    yContinue;
    xContinue;
    yInDirection;
    xInDirection;
    yDiagonal;
    xDiagonal;
    yDiagonal2;
    xDiagonal2;
    yPerpendicular;
    xPerpendicular;
    yPerpendicular2;
    xPerpendicular2;
    */
    Direction left = new Direction(0, 0, width, width, 1, 1, 0, -1, -1, -1, 1, -1, -1, 0, 1, 0);
    Direction right = new Direction(0, width - 1, width, -1, 1, -1, 0, 1, -1, 1, 1, 1, -1, 0, 1, 0);

    public void start() throws Exception {
        print();
        while (true) {
            createNewGrid(right);
            print();
            Thread.sleep(500);
        }
    }
    // problem when go right move 1 from 0 to 1 then next for round it look if 1 is 1 and then over and over until bumm
    public void createNewGrid(Direction direction) {
        if (direction.yEnd > 0) {
            for (int y = direction.yStart; y < direction.yEnd; y = y += direction.yContinue) {
                xLoop(direction, y);
            }
        } else {
            for (int y = direction.yStart; y > direction.yEnd; y = y += direction.yContinue) {
                xLoop(direction, y);
            }
        }
        currentGrid = newGrid;
    }

    public void xLoop(Direction direction, int y) {
        if (direction.xEnd > 0) {
            for (int x = direction.xStart; x < direction.xEnd; x += direction.xContinue) {
                executeLogic(direction, y, x);
            }
        } else {
            for (int x = direction.xStart; x > direction.xEnd; x += direction.xContinue) {
                executeLogic(direction, y, x);
            }
        }
    }

    public void executeLogic(Direction direction, int y, int x) {
        if (currentGrid[y][x] == 1 && x + direction.xInDirection >= 0 && x + direction.xInDirection < width) {
            if (currentGrid[y + direction.yInDirection][x + direction.xInDirection] == 0) {
                newGrid[y + direction.yInDirection][x + direction.xInDirection] = 1;
                newGrid[y][x] = 0;
            } else if (y + direction.yDiagonal > -1 && y + direction.yDiagonal < width && currentGrid[y + direction.yDiagonal][x + direction.xDiagonal] == 0 && y + direction.yDiagonal2 > -1 && y + direction.yDiagonal2 < width && currentGrid[y + direction.yDiagonal2][x + direction.xDiagonal2] == 0) {
                boolean randomBool = new Random().nextBoolean();
                if (randomBool) {
                    newGrid[y + direction.yDiagonal][x + direction.xDiagonal] = 1;
                    newGrid[y][x] = 0; 
                } else {
                    newGrid[y + direction.yDiagonal2][x + direction.xDiagonal2] = 1;
                    newGrid[y][x] = 0;
                }
            } else if (y + direction.yDiagonal > -1 && y + direction.yDiagonal < width && currentGrid[y + direction.yDiagonal][x + direction.xDiagonal] == 0) {
                newGrid[y + direction.yDiagonal][x + direction.xDiagonal] = 1;
                newGrid[y][x] = 0; 
            } else if (y + direction.yDiagonal2 > -1 && y + direction.yDiagonal2 < width && currentGrid[y + direction.yDiagonal2][x + direction.xDiagonal2] == 0) {
                newGrid[y + direction.yDiagonal2][x + direction.xDiagonal2] = 1;
                newGrid[y][x] = 0;
            } else if (y + direction.yPerpendicular > -1 && y + direction.yPerpendicular < width && currentGrid[y + direction.yPerpendicular][x + direction.xPerpendicular] == 0 && y + direction.yPerpendicular2 > -1 && y + direction.yPerpendicular2 < width && y - 1 > -1 && currentGrid[y + direction.yPerpendicular2][x + direction.xPerpendicular2] == 0) {
                boolean randomBool = new Random().nextBoolean();
                if (randomBool) {
                    newGrid[y + direction.yPerpendicular][x + direction.xPerpendicular] = 1;
                    newGrid[y][x] = 0; 
                } else {
                    newGrid[y + direction.yPerpendicular2][x + direction.xPerpendicular2] = 1;
                    newGrid[y][x] = 0;
                }
            } else if (y + direction.yPerpendicular > -1 && y + direction.yPerpendicular < width && currentGrid[y + direction.yPerpendicular][x + direction.xPerpendicular] == 0) {
                newGrid[y + direction.yPerpendicular][x + direction.xPerpendicular] = 1;
                newGrid[y][x] = 0; 
            } else if (y + direction.yPerpendicular2 > -1 && y + direction.yPerpendicular2 < width && currentGrid[y + direction.yPerpendicular2][x + direction.xPerpendicular2] == 0) {
                newGrid[y + direction.yPerpendicular2][x + direction.xPerpendicular2] = 1;
                newGrid[y][x] = 0;
            }
        }
    }

    public void print() {
        int counter = 0;
        System.out.print("---\n");
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < width; x++) {
                if (x < width - 1) {
                    System.out.print(currentGrid[y][x]);
                } else {
                    System.out.print(currentGrid[y][x] + "\n");
                }
                if (currentGrid[y][x] == 1) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}

class Direction {
    int yStart;
    int xStart;
    int yEnd;
    int xEnd;
    int yContinue;
    int xContinue;
    int yInDirection;
    int xInDirection;
    int yDiagonal;
    int xDiagonal;
    int yDiagonal2;
    int xDiagonal2;
    int yPerpendicular;
    int xPerpendicular;
    int yPerpendicular2;
    int xPerpendicular2;

    public Direction(int yStart, int xStart, int yEnd, int xEnd, int yContinue, int xContinue, int yInDirection, int xInDirection, int yDiagonal, int xDiagonal, 
                     int yDiagonal2, int xDiagonal2, int yPerpendicular, int xPerpendicular, 
                     int yPerpendicular2, int xPerpendicular2) {
        this.yStart = yStart;
        this.xStart = xStart;
        this.yEnd = yEnd;
        this.xEnd = xEnd;
        this.yContinue = yContinue;
        this.xContinue = xContinue;
        this.yInDirection = yInDirection;
        this.xInDirection = xInDirection;
        this.yDiagonal = yDiagonal;
        this.xDiagonal = xDiagonal;
        this.yDiagonal2 = yDiagonal2;
        this.xDiagonal2 = xDiagonal2;
        this.yPerpendicular = yPerpendicular;
        this.xPerpendicular = xPerpendicular;
        this.yPerpendicular2 = yPerpendicular2;
        this.xPerpendicular2 = xPerpendicular2;
    }
}