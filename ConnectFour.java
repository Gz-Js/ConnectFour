import java.util.*;
public class ConnectFour
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String[][] gameBoard = new String[6][7];
        for (int r = 0; r < gameBoard.length; r++)
        {
            for (int c = 0; c < gameBoard[r].length; c++)
            {
                gameBoard[r][c] = " ";
            }
        }
        // Create and initialize the game board

        // Print the initial game board
        printGameboard(gameBoard);
        // Set player's turn and initialize variables
        int turn = 1;
        int col;
        boolean playerWon = false;
        String piece;
        // Game loop
        while (!playerWon)
        {
            if (turn == 1)
            {
                System.out.print("Player 1, please pick a column to drop your red disk (Column 0-6) ");
                piece = "r";
                col = scan.nextInt();
                for (int r = gameBoard.length-1; r >= 0 ; r--)
                {
                    if (gameBoard[r][col].equals(" "))
                    {
                        gameBoard[r][col] = piece;
                        break;
                    }
                }
            }
            if (turn == 2)
            {
                System.out.print("Player 2, please pick a column to drop your yellow disk (Column 0-6) ");
                piece = "y";
                col = scan.nextInt();
                for (int r = gameBoard.length-1; r >= 0 ; r--)
                {
                    if (gameBoard[r][col].equals(" "))
                    {
                        gameBoard[r][col] = piece;
                        break;
                    }
                }
            }
            // Get the column where the player wants to drop the disk

            // Drop the disk in the selected column

            // Display the updated game board
            printGameboard(gameBoard);

            // Check if anyone has won or if it's a draw
            if(checkWinner(gameBoard).equals("y"))
            {
                System.out.println("Player 2 Won!");
                playerWon = true;
            }
            else if(checkWinner(gameBoard).equals("r"))
            {
                System.out.println("Player 1 Won!");
                playerWon = true;
            }
            else if (checkWinner(gameBoard).equals("FULL"))
            {
                System.out.println("The game board is full, it's a draw!");
                playerWon = true;
            }
            // Switch player's turn
            if (turn == 1)
            {
                turn++;
            }
            else
            {
                turn--;
            }
        }
        System.out.println("Thanks for playing! See you next time!");
    }
    // Method to print the game board
    public static void printGameboard(String[][] game)
    {
        for (String[] row : game)
        {
            for (String x : row)
            {
                System.out.print("|" + x);
            }
            System.out.println("|");
        }
        System.out.println("---------------");
    }


    // Method to check for a winner or a draw
    public static String checkWinner(String[][] game)
    {
        String sequence = "";
        String winner = "";
    // Check vertical wins
        for (int c = 0; c < game[0].length; c++)
        {
            for (int r = 0; r < game.length; r++)
            {
                sequence += game[r][c];
            }
            for (int i = 0; i < sequence.length()-4; i++)
            {
                if (sequence.substring(i, i+4).equals("yyyy"))
                {
                    winner = "y";
                    return winner;
                }
                else if (sequence.substring(i, i+4).equals("rrrr"))
                {
                    winner = "r";
                    return winner;
                }
            }
        }
        sequence = "";
        for (int r = 0; r < game.length; r++)
        {
            for (int c = 0; c < game[r].length; c++)
            {
                sequence += game[r][c];
            }
            for (int i = 0; i < sequence.length()-4; i++)
            {
                if (sequence.substring(i, i+4).equals("yyyy"))
                {
                    winner = "y";
                    return winner;
                }
                else if (sequence.substring(i, i+4).equals("rrrr"))
                {
                    winner = "r";
                    return winner;
                }
            }
        }
        sequence = "";
        // Check major diagonal wins
        for (int c = 0; c < game[0].length-3; c++)
        {
            for (int r = 0; r < game.length-3; r++)
            {
                sequence += game[r][c];
                sequence += game[r+1][c+1];
                sequence += game[r+2][c+2];
                sequence += game[r+3][c+3];
            }
            for (int i = 0; i < sequence.length()-4; i++)
            {
                if (sequence.substring(i, i+4).equals("yyyy"))
                {
                    winner = "y";
                    return winner;
                }
                else if (sequence.substring(i, i+4).equals("rrrr"))
                {
                    winner = "r";
                    return winner;
                }
            }
        }
        sequence = "";
    // Check minor diagonal wins
        for (int r = game.length-1; r >= 3; r--)
        {
            for (int c = game[r].length-1; c >= 3; c--)
            {
                sequence += game[r-3][c];
                sequence += game[r-2][c-1];
                sequence += game[r-1][c-2];
                sequence += game[r][c-3];
            }
            for (int i = 0; i < sequence.length()-4; i++)
            {
                if (sequence.substring(i, i+4).equals("yyyy"))
                {
                    winner = "y";
                    return winner;
                }
                else if (sequence.substring(i, i+4).equals("rrrr"))
                {
                    winner = "r";
                    return winner;
                }
            }
        }
        sequence = "";
    // Check if the board is full
        for (int c = game[0].length-1; c >= 0; c--)
        {
            sequence += game[0][c];
        }
        if (!sequence.contains(" "))
        {
            winner = "FULL";
        }
    // No winner found, return "FULL" to indicate a draw
        return winner;
    }
}


