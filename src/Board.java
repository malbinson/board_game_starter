public class Board {

    int size = 8;
    String[][] grid = new String[size][size];  //make 8x8 2D array of strings


    //constructor initializes the whole
    // grid with 0's when created
    public Board() {

        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {

                grid[row][col] = "0";

            }
        }

    }

    //************ ALGORITHM #1 ***************
    //displayBoard will output a board to the console
    public void printBoard() {
        System.out.println("Updated board:");
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {

                System.out.print(grid[row][col] + " ");  //prints out each value in each array

            }
            System.out.print("\n");  // "\n" is the character for "new line"
        }


    }

    //************ ALGORITHM #2 ***************
    //makes a move on the board - changes a position to "token value"
    public void makeMove(int row, int col, String token) {

        grid[row][col] = token;  // for Connect-4 you will need to determine the row value
                                 // based on the existing values in the grid (where does the token "drop" to)
    }


    //************ ALGORITHM #3 ***************
    // return true if there are 4 in a row anywhere on the board
    // for now, any move at 0,0 ends game
    public boolean checkWin() {

        if(grid[0][0] != "0") {
            return true;
        }

        return false;

    }



}
