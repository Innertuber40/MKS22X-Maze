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
		inf = new Scanner(myMaze);
		for (int i = 0; i < height; i++) {
			String thisLine = inf.nextLine();
			for (int j = 0; j < length; j++) {
				maze[i][j] = thisLine.charAt(j);
			}
		}
		animate = false;
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
