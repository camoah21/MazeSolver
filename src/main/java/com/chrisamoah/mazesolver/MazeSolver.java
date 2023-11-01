package main.java.com.chrisamoah.mazesolver;

public class MazeSolver {

    private static final char WALL = 'X';
    private static final char START = 'S';
    private static final char END = 'E';
    private static final char PATH = '.';
    private static final char VISITED = '+';

    private final char[][] maze;
    @SuppressWarnings("unused")
	private boolean solved = false;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    public boolean solve() {
        // Find the start position and call the recursive solve function
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (maze[row][col] == START) {
                    // Starting the recursive backtracking algorithm
                    return solveFrom(row, col);
                }
            }
        }
        return false;
    }
    
    public static boolean solveMaze(char[][] maze) {
        MazeSolver solver = new MazeSolver(maze);

        // Check for the start 'S' and end 'E'
        boolean startFound = false, endFound = false;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    startFound = true;
                } else if (maze[i][j] == 'E') {
                    endFound = true;
                }
                if (startFound && endFound) break;
            }
            if (startFound && endFound) break;
        }

        if (!startFound || !endFound) {
            throw new IllegalArgumentException("Maze must have both start 'S' and end 'E'.");
        }

        return solver.solve();
    }

    private boolean solveFrom(int row, int col) {
        // Check bounds and for walls or visited cells.
        if (!isValid(row, col)) return false;
        
        // If it's the end, we've solved the maze.
        if (maze[row][col] == END) return true;
        
        // If it's not an open cell or the start, return false.
        if (maze[row][col] != ' ' && maze[row][col] != START) return false;
        
        // Mark this cell as visited.
        maze[row][col] = VISITED;
        
        // Try all available directions.
        if (solveFrom(row - 1, col) || // Up
            solveFrom(row + 1, col) || // Down
            solveFrom(row, col - 1) || // Left
            solveFrom(row, col + 1)) { // Right
            // If one of the directions is true, mark it as part of the path
            maze[row][col] = PATH;
            return true;
        }
        
        // If none of the directions work, unmark it (backtrack) and return false.
        maze[row][col] = ' ';  // Backtrack
        return false;
    }

    // Checks if the current position is inside the maze and not a wall
    private boolean isValid(int row, int col) {
        return row >= 0 && row < maze.length &&
               col >= 0 && col < maze[row].length &&
               maze[row][col] != WALL && maze[row][col] != VISITED;
    }



    // Method to print the maze to console - for debugging purposes
    public void printMaze() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                System.out.print(maze[row][col]);
            }
            System.out.println();
        }
    }

    // Helper method to call the maze solver and print the solution
    public static void solveAndPrint(char[][] maze) {
        MazeSolver solver = new MazeSolver(maze);
        if (solver.solve()) {
            System.out.println("Maze solved:");
            solver.printMaze();
        } else {
            System.out.println("Maze cannot be solved.");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        char[][] maze = {
            {'S', ' ', 'X', ' '},
            {' ', 'X', ' ', 'X'},
            {' ', ' ', ' ', 'X'},
            {'X', 'X', 'E', ' '}
        };

        solveAndPrint(maze);
    }
}

