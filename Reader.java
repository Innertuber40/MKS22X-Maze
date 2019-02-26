import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
	public static void main(String[] args) {
		File maze = new File("Maze1.txt");
		try {
			Scanner inf = new Scanner(maze);
			String toChar = "";
			int length = 0;
			int height = 1;
			while(inf.hasNext()) {
				length++;
				System.out.print(inf.next());
				toChar += inf.next();
			}
			while(inf.hasNextLine()) {
				System.out.println(inf.nextLine());
				height++;
				toChar += inf.nextLine();
			}
			char[] exists = new char[][length];

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
}
