package test.java.com.chrisamoah.mazesolver;

import static org.junit.Assert.*;
import org.junit.Test;

import main.java.com.chrisamoah.mazesolver.MazeSolver;

public class MazeSolverTest {

    @Test
    public void testSolvableMaze() {
        char[][] maze = {
            {'S', ' ', 'X', ' '},
            {' ', 'X', ' ', 'X'},
            {' ', ' ', ' ', 'X'},
            {'X', 'X', 'E', ' '}
        };
        assertTrue("Maze should be solvable", MazeSolver.solveMaze(maze));
    }

    @Test
    public void testUnsolvableMaze() {
        char[][] maze = {
            {'S', 'X', 'X', ' '},
            {' ', 'X', ' ', 'X'},
            {' ', 'X', ' ', 'X'},
            {'X', 'X', 'E', 'X'}
        };
        assertFalse("Maze should be unsolvable", MazeSolver.solveMaze(maze));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoStart() {
        char[][] maze = {
            {' ', ' ', 'X', ' '},
            {' ', 'X', ' ', 'X'},
            {' ', ' ', ' ', 'X'},
            {'X', 'X', 'E', ' '}
        };
        MazeSolver.solveMaze(maze);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoEnd() {
        char[][] maze = {
            {'S', ' ', 'X', ' '},
            {' ', 'X', ' ', 'X'},
            {' ', ' ', ' ', 'X'},
            {'X', 'X', ' ', ' '}
        };
        MazeSolver.solveMaze(maze);
    }
}
