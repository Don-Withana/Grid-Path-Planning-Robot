import java.util.Random;

public class Grid {
    private final int rows;
    private final int cols;
    private boolean[][] grid;
    private final RobotState robotState;
    static int endRow;
    static int endCol;
    IntArrayList shortestPath;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new boolean[rows][cols];
        robotState = new RobotState(0, 0);
        endRow = rows - 1;
        endCol = cols - 1;
        randomlyPlaceObstacles();
        shortestPath = findShortestPath(robotState.getRow(), robotState.getCol());
    }

    // Method to get the next step in the shortest path
    public int[] getNextCellToStart() {
        // Get the next step in the shortest path
        if (shortestPath.size() >= 2) {
            return shortestPath.get(1);
        } else {
            return null;
        }
    }

    // Method to get the previous step in the shortest path (before the end cell)
    public int[] getPreviousCellToEnd() {
        // Get the previous step in the shortest path (before the end cell)
        if (shortestPath.size() >= 3) {
            return shortestPath.get(shortestPath.size() - 2);
        } else {
            return null;
        }
    }

    // Method to calculate the obstacle percentage
    private double calculateObstaclePercentage() {
        int totalCells = rows * cols;
        int obstacleCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j]) {
                    obstacleCount++;
                }
            }
        }
        return (double) obstacleCount / totalCells * 100.0;
    }

    // Method to place obstacles randomly
    private void randomlyPlaceObstacles() {
        Random random = new Random();
        int totalCells = rows * cols;
        int numObstacles = totalCells / 5;
        int maxAttempts = 10000; // Maximum attempts to find a valid path

        // Loop until the desired number of obstacles is placed or max attempts reached
        while (numObstacles > 0 && maxAttempts > 0) {
            int randomRow = random.nextInt(rows);
            int randomCol = random.nextInt(cols);

            // Check if the cell is not the start or end point
            if ((randomRow != robotState.getRow() || randomCol != robotState.getCol()) &&
                    (randomRow != endRow || randomCol != endCol)) {
                // Temporarily place the obstacle
                grid[randomRow][randomCol] = true;

                // Check if a path exists between robot and end point
                shortestPath = findShortestPath(robotState.getRow(), robotState.getCol());
                if (shortestPath.size() > 0) {
                    // If a path exists, decrement obstacle count and continue
                    numObstacles--;
                } else {
                    // If no path exists, remove the obstacle and try again
                    grid[randomRow][randomCol] = false;
                }
            }
            maxAttempts--; // Decrement attempts counter
        }
    }

    class CustomQueue {
        private int front, rear;
        private int maxSize;
        private int[][] elements;

        public CustomQueue(int size) {
            maxSize = size;
            elements = new int[size][2];
            front = 0;
            rear = -1;
        }

        public void enqueue(int[] item) {
            if (rear == maxSize - 1) {
                // Queue is full
                return;
            }
            elements[++rear] = item;
        }

        public int[] dequeue() {
            if (isEmpty()) {
                // Queue is empty
                return null;
            }
            int[] item = elements[front++];
            if (front == maxSize) {
                front = 0;
                rear = -1;
            }
            return item;
        }

        public boolean isEmpty() {
            return front > rear;
        }
    }

    IntArrayList findShortestPath(int startRow, int startCol) {
        IntArrayList path = new IntArrayList();
        boolean[][] visited = new boolean[rows][cols];
        int[][] parentRow = new int[rows][cols];
        int[][] parentCol = new int[rows][cols];
        final int INFINITY = Integer.MAX_VALUE;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                parentRow[i][j] = -1; // Initialize parent arrays
                parentCol[i][j] = -1;
            }
        }

        int[] dx = {1, 1, 1, 0, 0, -1, -1, -1}; // Diagonal movements
        int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};

        CustomQueue queue = new CustomQueue(rows * cols);
        queue.enqueue(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        boolean found = false;

        while (!queue.isEmpty()) {
            int[] current = queue.dequeue();
            int currentRow = current[0];
            int currentCol = current[1];

            if (currentRow == endRow && currentCol == endCol) {
                found = true;
                break;
            }

            for (int i = 0; i < 8; i++) { // 8 possible directions
                int nextRow = currentRow + dx[i];
                int nextCol = currentCol + dy[i];

                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols &&
                        !grid[nextRow][nextCol] && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    parentRow[nextRow][nextCol] = currentRow;
                    parentCol[nextRow][nextCol] = currentCol;
                    queue.enqueue(new int[]{nextRow, nextCol});
                }
            }
        }

        if (found) {
            int row = endRow, col = endCol;
            while (row != startRow || col != startCol) {
                path.addFirst(new int[]{row, col});
                int newRow = parentRow[row][col];
                int newCol = parentCol[row][col];
                row = newRow;
                col = newCol;
            }
            path.addFirst(new int[]{startRow, startCol});
        }
        return path;
    }


    public void printGrid1() {
        // Length of each cell in the grid for formatting
        int cellLength = 8;

        System.out.println("\u001B[34m\n★ Cell Coordinates: \u001B[0m");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("\u001B[36m+\u001B[0m");
                for (int k = 0; k < cellLength; k++) {
                    System.out.print("\u001B[36m-\u001B[0m");
                }
            }
            System.out.println("\u001B[36m+\u001B[0m");

            for (int j = 0; j < cols; j++) {
                String content = String.format("(%d,%d)", i, j);
                int spacesBefore = (cellLength - content.length()) / 2;
                int spacesAfter = cellLength - spacesBefore - content.length();
                System.out.print("\u001B[36m┆\u001B[0m");
                for (int k = 0; k < spacesBefore; k++) {
                    System.out.print(" ");
                }
                System.out.print(content);
                for (int k = 0; k < spacesAfter; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println("\u001B[36m┆\u001B[0m");
        }

        for (int j = 0; j < cols; j++) {
            System.out.print("\u001B[36m+\u001B[0m");
            for (int k = 0; k < cellLength; k++) {
                System.out.print("\u001B[36m-\u001B[0m");
            }
        }
        System.out.println("\u001B[36m+\u001B[0m");
    }

    public void printGrid2() {
        int cellWidth = 8;
        int maxPathLengthPerLine = 10; // Maximum path elements per line

        double obstaclePercentage = calculateObstaclePercentage();

        System.out.println("\u001B[34m\n★ Grid After Path: \u001B[0m");
        System.out.println("    Legend: \u001B[32mROBOT\u001B[0m   - Start" +
                "\n            \u001B[32mGOAL\u001B[0m    - End" +
                "\n            XXXXXX  - Obstacle" +
                "\n            \u001B[35m●\u001B[0m       - Path\n");
        System.out.printf("    Obstacle Percentage: \u001B[31m%.2f%%\u001B[0m\n", obstaclePercentage);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("\u001B[36m+\u001B[0m");
                for (int k = 0; k < cellWidth; k++) {
                    System.out.print("\u001B[36m-\u001B[0m");
                }
            }
            System.out.println("\u001B[36m+\u001B[0m");

            // Print cell content based on robot position, obstacles, and path
            for (int j = 0; j < cols; j++) {
                System.out.print("\u001B[36m┆\u001B[0m");
                if (i == robotState.getRow() && j == robotState.getCol()) {
                    System.out.printf("%-" + (cellWidth - 2) + "s", "  \u001B[32mROBOT\u001B[0m ");
                } else if (i == endRow && j == endCol) {
                    System.out.printf("%-" + (cellWidth - 2) + "s", "  \u001B[32mGOAL\u001B[0m  ");
                } else if (grid[i][j]) {
                    System.out.printf("%-" + (cellWidth - 2) + "s", " XXXXXX ");
                } else {
                    boolean isPath = false;
                    for (int p = 0; p < shortestPath.size(); p++) {
                        int[] pathElement = shortestPath.get(p);
                        if (pathElement[0] == i && pathElement[1] == j) {
                            isPath = true;
                            break;
                        }
                    }
                    if (isPath) {
                        System.out.printf("%-" + (cellWidth - 2) + "s", "   \u001B[35m ● \u001B[0m  ");
                    } else {
                        System.out.printf("%-" + (cellWidth - 2) + "s", "        ");
                    }
                }
            }
            System.out.println("\u001B[36m┆\u001B[0m");
        }

        for (int j = 0; j < cols; j++) {
            System.out.print("\u001B[36m+\u001B[0m");
            for (int k = 0; k < cellWidth; k++) {
                System.out.print("\u001B[36m-\u001B[0m");
            }
        }
        System.out.println("\u001B[36m+\u001B[0m");

        System.out.println("\n★ Robot State Before Path:");
        System.out.println("    Position: (" + robotState.getRow() + ", " + robotState.getCol() + ")");
        System.out.println("    Start Orientation: " + determineStartOrientation(robotState.getRow(), robotState.getCol()));

        System.out.println("\n★ Path: ");
        int pathLength = shortestPath.size();
        for (int p = 0; p < pathLength; p++) {
            int[] pathElement = shortestPath.get(p);
            if (p == 0) {
                System.out.print("    "); // Double space added here
            }
            System.out.print("(" + pathElement[0] + "," + pathElement[1] + ")");
            if ((p + 1) % maxPathLengthPerLine == 0 && p != pathLength - 1) {
                System.out.println();
                System.out.print("    "); // Double space added for alignment
            } else if (p != pathLength - 1) {
                System.out.print(" ➤ ");
            }
        }

        // Update robot state and determine orientation
        robotState.setRow(endRow);
        robotState.setCol(endCol);

        if (pathLength >= 2) {
            int[] firstStep = shortestPath.get(1); // Index 0 is the current position, so we take the next step
            determineOrientation(robotState.getRow(), robotState.getCol(), firstStep[0], firstStep[1]);
        }
        System.out.println("\n\n★ Robot State After Path:");
        System.out.println("    Position: (" + robotState.getRow() + ", " + robotState.getCol() + ")");
        System.out.println("    End Orientation: " + determineEndOrientation(robotState.getRow(), robotState.getCol()));
    }

    public void placeRobot(int row, int col) {
        robotState.setRow(row);
        robotState.setCol(col);
        if (shortestPath.size() >= 2) {
            int[] currentPos = shortestPath.get(0);
            int[] nextStep = shortestPath.get(1);
            determineOrientation(currentPos[0], currentPos[1], nextStep[0], nextStep[1]);
        }
    }

    public void placeEndPoint(int row, int col) {
        endRow = row;
        endCol = col;
        if (shortestPath.size() >= 2) {
            int[] firstStep = shortestPath.get(1);
            int[] lastStep = shortestPath.get(shortestPath.size() - 1);
            determineOrientation(firstStep[0], firstStep[1], lastStep[0], lastStep[1]);
        }
    }

    // Determine the orientation based on the change in coordinates
    private void determineOrientation(int startX, int startY, int endX, int endY) {
        int dx = endX - startX;
        int dy = endY - startY;
        if (dx == 0 && dy > 0) {
            robotState.setOrientation(Orientation.EAST);
        } else if (dx == 0 && dy < 0) {
            robotState.setOrientation(Orientation.WEST);
        } else if (dx > 0 && dy == 0) {
            robotState.setOrientation(Orientation.SOUTH);
        } else if (dx < 0 && dy == 0) {
            robotState.setOrientation(Orientation.NORTH);
        } else if (dx > 0 && dy > 0) {
            robotState.setOrientation(Orientation.SOUTHEAST);
        } else if (dx > 0) {
            robotState.setOrientation(Orientation.SOUTHWEST);
        } else if (dx < 0 && dy > 0) {
            robotState.setOrientation(Orientation.NORTHEAST);
        } else if (dx < 0) {
            robotState.setOrientation(Orientation.NORTHWEST);
        }
    }

    // Determine the orientation based on the change in coordinates to the next cell
    private Orientation determineStartOrientation(int startX, int startY) {
        int[] nextCellToStart = getNextCellToStart();

        if (nextCellToStart != null) {
            int dxNext = nextCellToStart[0] - startX;
            int dyNext = nextCellToStart[1] - startY;

            if (dxNext == 0 && dyNext > 0) {
                return Orientation.EAST;
            } else if (dxNext == 0 && dyNext < 0) {
                return Orientation.WEST;
            } else if (dxNext > 0 && dyNext == 0) {
                return Orientation.SOUTH;
            } else if (dxNext < 0 && dyNext == 0) {
                return Orientation.NORTH;
            } else if (dxNext > 0 && dyNext > 0) {
                return Orientation.SOUTHEAST;
            } else if (dxNext > 0) {
                return Orientation.SOUTHWEST;
            } else if (dxNext < 0 && dyNext > 0) {
                return Orientation.NORTHEAST;
            } else if (dxNext < 0) {
                return Orientation.NORTHWEST;
            }
        }

        return null;
    }

    // Determine the orientation based on the change in coordinates from the previous cell to the end cell
    private Orientation determineEndOrientation(int endX, int endY) {
        int[] previousCellToEnd = getPreviousCellToEnd();

        if (previousCellToEnd != null) {
            int dxPrev = previousCellToEnd[0] - endX;
            int dyPrev = previousCellToEnd[1] - endY;

            if (dxPrev == 0 && dyPrev > 0) {
                return Orientation.WEST;
            } else if (dxPrev == 0 && dyPrev < 0) {
                return Orientation.EAST;
            } else if (dxPrev > 0 && dyPrev == 0) {
                return Orientation.NORTH;
            } else if (dxPrev < 0 && dyPrev == 0) {
                return Orientation.SOUTH;
            } else if (dxPrev > 0 && dyPrev > 0) {
                return Orientation.NORTHWEST;
            } else if (dxPrev > 0) {
                return Orientation.NORTHEAST;
            } else if (dxPrev < 0 && dyPrev > 0) {
                return Orientation.SOUTHWEST;
            } else if (dxPrev < 0) {
                return Orientation.SOUTHEAST;
            }
        }

        return null;
    }

}