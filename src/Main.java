import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        String [][] maze = getMaze("Mazes/Super_Maze");
        MazeSolver m = new MazeSolver(maze);
        int endRow = maze.length-1;
        int endCol = maze[0].length-1;
        int currRow = 0;
        int currCol = 0;
        String list = "";
        printMaze(maze);
        while(currRow != endRow || currCol != endCol) {
            if (m.canGoUp(currRow, currCol))
            {
                currRow -= 1;
                list += ("(" + currRow + ", " + currCol + ")-->");
            }
            else if (m.canGoDown(currRow, currCol))
            {
                currRow += 1;
                list += ("(" + currRow + ", " + currCol + ")-->");
            }
            else if (m.canGoLeft(currRow, currCol))
            {
                currCol -= 1;
                list += ("(" + currRow + ", " + currCol + ")-->");
            }
            else if (m.canGoRight(currRow, currCol))
            {
                currCol += 1;
                list += ("(" + currRow + ", " + currCol + ")-->");
            }
            else{
                m.markDeadEnd(currRow,currCol);
                currRow = 0;
                currCol = 0;
                list = "";
                m.setLastDir("");
            }
        }
        printMaze(maze);
        list = list.substring(0,list.length()-3);
        System.out.println(list);
    }

    public static void printMaze(String [][] maze){
        for(String[] row: maze){
            System.out.println(Arrays.toString(row));
        }
    }
    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = d.charAt(j) + "";
            }
        }
        return maze;

    }

}