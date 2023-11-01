package test.java.com.chrisamoah.mazesolver;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import main.java.com.chrisamoah.mazesolver.MazeSolver;

public class MazeSolverTest {

	@Test
	public void testSimpleMaze() {
	    char[][] maze = {
	        {'S', ' ', ' ', ' ', 'X', 'X', 'X', 'X'},
	        {'X', 'X', ' ', 'X', 'X', ' ', ' ', ' '},
	        {'X', 'X', ' ', 'X', 'X', 'X', 'X', ' '},
	        {'X', ' ', ' ', ' ', ' ', ' ', 'X', 'E'},
	        {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
	    };
	    assertTrue(MazeSolver.solveMaze(maze));
	}


    @Test
    public void testUnsolvableMaze() {
        char[][] maze = {
            {'S', '#', ' ', ' ', '#', '#', '#', '#'},
            {'#', '#', ' ', '#', '#', ' ', ' ', ' '},
            {'#', '#', ' ', '#', '#', '#', '#', ' '},
            {'#', ' ', ' ', ' ', ' ', ' ', '#', 'E'},
            {'#', '#', '#', '#', '#', '#', '#', '#'}
        };
        assertFalse(MazeSolver.solveMaze(maze));
    }

    @Test
    public void testMazeWithNoStart() {
        char[][] maze = {
            {' ', ' ', ' ', ' ', '#', '#', '#', '#'},
            {'#', '#', ' ', '#', '#', ' ', ' ', ' '},
            {'#', '#', ' ', '#', '#', '#', '#', ' '},
            {'#', ' ', ' ', ' ', ' ', ' ', '#', 'E'},
            {'#', '#', '#', '#', '#', '#', '#', '#'}
        };
        assertThrows(IllegalArgumentException.class, () -> MazeSolver.solveMaze(maze));
    }

    @Test
    public void testMazeWithNoEnd() {
        char[][] maze = {
            {'S', ' ', ' ', ' ', '#', '#', '#', '#'},
            {'#', '#', ' ', '#', '#', ' ', ' ', ' '},
            {'#', '#', ' ', '#', '#', '#', '#', ' '},
            {'#', ' ', ' ', ' ', ' ', ' ', '#', ' '},
            {'#', '#', '#', '#', '#', '#', '#', '#'}
        };
        assertThrows(IllegalArgumentException.class, () -> MazeSolver.solveMaze(maze));
    }

    // Add more test cases as needed...

}
