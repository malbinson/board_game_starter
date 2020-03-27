//import the Scanner class used for user input
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        //make instances
        Human h = new Human("Alby", "X");
        Computer c = new Computer("O");
        Scanner sc =  new Scanner(System.in);
        Board b = new Board();
        String currentToken = h.token;

        //game loop - alternate moves
        while(!b.checkWin(currentToken)) {

            //set up vars
            boolean legalCol = false;
            int moveCol = -1;

            //human move: validate input and move
            while(!legalCol) {

                //col move
                System.out.println("Enter col to move:");
                //hasNextInt will return true if user input is an int
                if(sc.hasNextInt()) {
                    moveCol = sc.nextInt()-1;
                    legalCol = true;

                    if(moveCol > 8) {
                        System.out.println("Enter a legal col!");
                        legalCol = false;
                        sc.next();
                    }

                    if(moveCol < 8 && !b.colHasRoom(moveCol)){
                        System.out.println("Colun is Full");
                        legalCol = false;
                        sc.next();
                    }
                }
                else {
                    System.out.println("Enter a legal col!");
                    sc.next();  //very important, resets the input from the "bad" one
                }



                if(legalCol && b.colHasRoom(moveCol)) {
                    b.makeMove(moveCol,h.token);
                    currentToken = h.token;
                }
            }

            //computer move
            int cMove = c.determineMove();
            b.makeMove(cMove,c.token);
            currentToken = c.token;

            //all done moving, display and repeat
            b.printBoard();

        }

        System.out.print("Game Over!");

    }

}
