public class MazeSolver {
    private String lastDir;
    private String[][] maze;
    private int row;
    private int col;
    private int endRow;
    private int endCol;

    public MazeSolver(String [][] maze){
        this.maze = maze;
        endRow = maze.length-1;
        endCol = maze[0].length-1;
        lastDir = "";
    }
    public boolean canGoUp(int row, int col){
        this.row = row;
        this.col = col;
        if (! lastDir.equals("Down") && row !=0) {
            if (maze[row - 1][col].equals(".")){
                lastDir = "Up";
            return true;
            }
        }
        return false;
    }
    public boolean canGoDown(int row, int col){
        this.row = row;
        this.col = col;
        if (! lastDir.equals("Up") && row!= endRow) {
            if (maze[row + 1][col].equals(".")){
                lastDir = "Down";
            return true;
        }
        }
        return false;
    }
    public boolean canGoLeft(int row, int col){
        this.row = row;
        this.col = col;
        if (! lastDir.equals("Right") && col!=0) {
            if (maze[row][col - 1].equals(".")) {
                lastDir = "Left";
                return true;
            }
        }
        return false;
    }
    public boolean canGoRight(int row, int col){
        this.row = row;
        this.col = col;
        if (! lastDir.equals("Left")){
            if(maze[row][col+1].equals(".")) {
                lastDir = "Right";
                return true;
            }
        }
        return false;
    }

    public void setLastDir(String lastDir) {
        this.lastDir = lastDir;
    }

    public boolean isDeadEnd(int row, int col)
    {
        return !(canGoRight(row,col) || canGoLeft(row, col) || canGoUp(row, col) || canGoDown(row,col));
    }
    public void markDeadEnd(int row, int col){
        maze[row][col] = "#";
    }
    public void resetStart(){maze[0][0] = ".";}


}
