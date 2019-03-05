import java.util.*;
import java.io.*;

public class Maze {
	private char[][] maze;
	private boolean animate;
	
	public Maze(String filename) throws FileNotFoundException{
        	File myMaze = new File(filename);
		Scanner inf = new Scanner(myMaze);
		int height = 1;
		int length = inf.nextLine().length();
		while (inf.hasNextLine()) {
			height++;
			inf.nextLine();
		}
		maze = new char[height][length];
		inf.close();
		inf = new Scanner(myMaze);
		for (int i = 0; i < height; i++) {
			String thisLine = inf.nextLine();
			for (int j = 0; j < length; j++) {
				maze[i][j] = thisLine.charAt(j);
			}
		}
		animate = false;
		inf.close();
	}
	public String toString() {
		String returns = "";
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				returns += maze[i][j];
			}
			returns += "\n";
		}
		return returns;
	}

	public int solve() {
		int x = -1;
		int y = -1;
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if (maze[i][j] == 'S') {
					maze[i][j] = ' ';
					x = j;
					y = i;
				}
			}
		}
		return solver(x, y, 0);
	}
	private int solver(int x, int y, int distance) {
		if(animate){
			clearTerminal();
			char save = maze[y][x];
            maze[y][x] = '\u2588';
            System.out.println(this);
			maze[y][x] = save;
			wait(20);
		}
		if (maze[y][x] == 'E') {
			return distance;
		}
		if (maze[y][x] == ' ') {
			maze[y][x] = '@';
			int right = solver(x + 1, y, distance + 1);
			int left = solver(x - 1, y, distance + 1);
			int down = solver(x, y + 1, distance + 1);
			int up = solver(x, y - 1, distance + 1);
			if (right != -1) {
				return right;
			}
			if (left != -1) {
				return left;
			}
			if (down != -1) {
				return down;
			}
			if (up != -1) {
				return up;
			}
			maze[y][x] = '.';
		}
		return -1;
	}


	private void wait(int millis){
		try {
			Thread.sleep(millis);
		}
		catch (InterruptedException e) {
		}
	}
	public void setAnimate(boolean b){
		animate = b;
	}
	public void clearTerminal() {
        	System.out.println("\033[2J\033[1;1H");
    	}
}
