// --------------------------------------------------------------
// | Name : Himan Withana                                       |
// | Date : 2023/12/25                                          |
// | AI & Data Science undergrad at Robert Gordon university UK |
// --------------------------------------------------------------

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = 0;
        int cols = 0;

        // Welcome message
        System.out.println("\n\u001B[31m★★★ Welcome to the Grid Path Planning Program ★★★ \u001B[0m");

        // Input the number of rows for the grid
        while (true) {
            try {
                System.out.print("\n★ Enter the number of rows (between 5 and 50): ");
                rows = Integer.parseInt(scanner.nextLine());
                if (rows < 5 || rows > 50) {
                    throw new IllegalArgumentException("    Number of rows must be between 5 and 50.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("    Invalid input. Please enter a valid integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Input the number of columns for the grid
        while (true) {
            try {
                System.out.print("★ Enter the number of columns (between 5 and 50): ");
                cols = Integer.parseInt(scanner.nextLine());
                if (cols < 5 || cols > 50) {
                    throw new IllegalArgumentException("    Number of columns must be between 5 and 50.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("    Invalid input. Please enter a valid integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Create the grid object with the specified dimensions and generate obstacles
        Grid gridObj = new Grid(rows, cols);
        gridObj.printGrid1(); // Print the initial grid layout

        // Input the robot's position
        System.out.println("\n★ Enter the position of the robot:");
        int robotRow, robotCol;
        while (true) {
            try {
                System.out.print("    Row: ");
                robotRow = Integer.parseInt(scanner.nextLine());
                if (robotRow < 0 || robotRow >= rows) {
                    throw new IllegalArgumentException("    Invalid row index. Row index must be between 0 and " + (rows - 1) + ".");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("    Invalid input. Please enter a valid integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("    Column: ");
                robotCol = Integer.parseInt(scanner.nextLine());
                if (robotCol < 0 || robotCol >= cols) {
                    throw new IllegalArgumentException("    Invalid column index. Column index must be between 0 and " + (cols - 1) + ".");
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("    Invalid input. Please enter a valid integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        // Input the end point's position
        System.out.println("\n★ Enter the position of the end point:");
        int endRow, endCol;
        while (true) {
            try {
                System.out.print("    Row: ");
                endRow = Integer.parseInt(scanner.nextLine());
                if (endRow < 0 || endRow >= rows) {
                    throw new IllegalArgumentException("    Invalid row index. Row index must be between 0 and " + (rows - 1) + ".");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("    Invalid input. Please enter a valid integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("    Column: ");
                endCol = Integer.parseInt(scanner.nextLine());
                if (endCol < 0 || endCol >= cols) {
                    throw new IllegalArgumentException("    Invalid column index. Column index must be between 0 and " + (cols - 1) + ".");
                }
                if (endRow == robotRow && endCol == robotCol) {
                    throw new IllegalArgumentException("    End point cannot be the same as the robot's position.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("    Invalid input. Please enter a valid integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        // Place the robot and end point on the grid
        gridObj.placeRobot(robotRow, robotCol);
        gridObj.placeEndPoint(endRow, endCol);

        // Find the shortest path from the robot to the end point
        gridObj.shortestPath = gridObj.findShortestPath(robotRow, robotCol);

        // Print the grid with the path if a valid path is found
        if (gridObj.shortestPath.size() == 0) {
            System.out.println("    No path found.");
        } else {
            gridObj.printGrid2();
        }
    }
}
