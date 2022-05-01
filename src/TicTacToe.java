import java.util.Scanner;

public class TicTacToe
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String player = "X";
        int moveCount = 0;
        int row = -1;
        int col = -1;
        final int fastestWin = 5;
        final int fastestTie = 7;
        boolean continueGame= true;
        boolean finishGame = false;
        do
        {
            player = "X";
            continueGame = true;
            moveCount = 0;
            clearBoard();
            do
            {
                do
                {
                    display();
                    System.out.println("Player " + player + ", it is your move");
                    row = SafeInput.getRangedInt(in, "Enter the row", 1, 3);
                    row--;
                    col = SafeInput.getRangedInt(in, "Enter the column", 1, 3);
                    col--;
                }while(!isValidMove(row,col));
                board[row][col] = player;
                moveCount++;
                if (moveCount >= fastestWin)
                {
                    if (isWin(player))
                    {
                        display();
                        System.out.println(" Player " + player + " has won!");
                        continueGame = false;
                    }
                }
                if (moveCount >= fastestTie)
                {
                    if(isTie())
                    {
                        display();
                        System.out.println("It is a Tie!");
                        continueGame = false;
                    }
                }
                if (player.equals("X"))
                {
                    player = "O";
                }
                else
                {
                    player = "X";
                }
            }while (continueGame);
            finishGame = SafeInput.getYNConfirm(in, "Do you want to quit?");

        }while(!finishGame);
    }

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];
    private static void clearBoard()
    {
        for(int row = 0;row<ROW;row++)
        {
            for (int col =0; col<COL; col++)
            {
                board[row][col] = " ";
            }
        }
    }
    private static void display()
    {
        for(int row=0;row<ROW;row++)
        {
            System.out.print("| ");
            for(int col = 0;col<COL;col++)
            {
                System.out.print(board[row][col]+ " | ");
            }
            System.out.println("");
        }

    }
    private static boolean isValidMove(int row, int col)
    {
        boolean spaceVal = false;
        if(board[row][col].equals(" "))
        {
            spaceVal = true;
        }
        else
        {
            System.out.println("You entered an invalid move, try again.");
        }

        return spaceVal;
    }
    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
    }
    private static boolean isColWin(String player)
    {
        for (int col =0; col < COL;col++)
        {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isRowWin(String player)
    {
        for (int row =0; row < ROW;row++)
        {
            if (board[row][0].equals(player)&&board[row][1].equals(player)&&board[row][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isDiagonalWin(String player)
    {
        if (board[0][0].equals(player)&&board[1][1].equals(player)&&board[2][2].equals(player))
        {
            return true;
        }
        if (board[0][2].equals(player)&&board[1][1].equals(player)&&board[2][0].equals(player))
        {
            return true;
        }
        return false;
    }
    private static boolean isTie()
    {
        boolean xTie= false;
        boolean oTie = false;
        for (int col =0; col <COL;col++)
        {
            if (board[0][col].equals("X") | board[1][col].equals("X") || board[2][col].equals("X"))
            {
                xTie = true;
            }
            if (board[0][col].equals("O") | board[1][col].equals("O") || board[2][col].equals("O"))
            {
                oTie = true;
            }
            if (!(xTie &&oTie))
            {
                return false;
            }
            xTie = oTie = false;
        }
        for (int row =0; row <ROW;row++)
        {
            if (board[row][0].equals("X") | board[row][1].equals("X") || board[row][2].equals("X"))
            {
                xTie = true;
            }
            if (board[row][0].equals("O") | board[row][1].equals("O") || board[row][2].equals("O"))
            {
                oTie = true;
            }
            if (!(xTie &&oTie))
            {
                return false;
            }
            xTie = oTie = false;
        }
        if (board[0][0].equals("X")||board[1][1].equals("X")||board[2][2].equals("X"))
        {
            xTie = true;
        }
        if(board[0][0].equals("O")||board[1][1].equals("O")||board[2][2].equals("O"))
        {
            oTie=true;
        }
        if (!(xTie &&oTie))
        {
            return false;
        }
        xTie = oTie = false;
        if (board[0][2].equals("X")||board[1][1].equals("X")||board[2][0].equals("X"))
        {
            xTie = true;
        }
        if(board[0][2].equals("O")||board[1][1].equals("O")||board[2][0].equals("O"))
        {
            oTie=true;
        }
        if (!(xTie &&oTie))
        {
            return false;
        }
        xTie = oTie = false;
        return true;
    }
}
