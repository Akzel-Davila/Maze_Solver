public class MazeSolver {
    private String lastDir;
    private String[][] maze;
    private int row;
    private int col;
    private int endRow;
    private int endCol;
    private String list;

    public MazeSolver(String [][] maze){
        this.maze = maze;
        endRow = maze.length-1;
        endCol = maze[0].length-1;
        lastDir = "";
        list = "";
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
    public void solveMaze(){
        while(row != endRow || col != endCol) {
            if (canGoUp(row, col))
            {
                goUp();
            }
            else if (canGoDown(row, col))
            {
                goDown();
            }
            else if (canGoLeft(row, col))
            {
                goLeft();
            }
            else if (canGoRight(row, col))
            {
                goRight();
            }
            else{
                markDeadEnd(row,col);
                row = 0;
                col = 0;
                list = "(0,0)-->";
                setLastDir("");
            }
        }
        list = list.substring(0,list.length()-3);
        System.out.println(list);
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
    public void goUp(){
        row -= 1;
        list += ("(" + row + ", " + col + ")-->");
    }
    public void goDown(){
        row += 1;
        list += ("(" + row + ", " + col + ")-->");
    }
    public void goLeft(){
        col -= 1;
        list += ("(" + row + ", " + col + ")-->");
    }
    public void goRight(){
        col += 1;
        list += ("(" + row + ", " + col + ")-->");
    }


}
