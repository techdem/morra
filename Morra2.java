import java.util.*;    // Import library for array list
import javax.swing.JOptionPane;    // Import library for GUI

public class Morra2{    // Class definition for Morra Game

    private int playerSel;    // Variable for player selection
    private int playerFingers;    // Variable for player number of fingers
    private int computerFingers;    // Variable for computer number of fingers
    private int roundCounter;    // Variable to count rounds in a game
    private int gameCounter;    // Variable to count total number of games
    private int roundsWon;    // Variable to count number of rounds won
    private int roundsLost;    // Variable to count number of rounds lost
    private int extraPoints;    // Variable to count number of rounds won
    private int playerOdds;    // Variable to count amount of times the player picked an odd number
    private int playerEvens;    // Variable to count amount of times the player picked an even number
    private int computerOdds;    // Variable to count amount of times the computer generated an odd number
    private int computerEvens;    // Variable to count amount of times the computer generated an even number
    private int playerScore;    // Variable to keep track of player score
    private int computerScore;    // Variable to keep track of computer score
    private int[][]roundFingers;    // Variable to store round history
    private ArrayList<String>history;    // Variable to store game history

    public Morra2(){    // Class default constructor

        roundFingers=new int[2][4];    // Initialising round history array
        history=new ArrayList<>();    // Initialising game history array
    }

    public void setPlayerSelection(int playerSel) {    // Method to receive selection input

        this.playerSel=playerSel;    // Set instance variable to player selection
        System.out.println("Player Selection: "+playerSel);    // Print player selection to console
    }

    public void setFingers(int fingerInput){    // Method to receive finger input

        this.playerFingers=fingerInput;    // Set instance variable to player fingers
        System.out.printf("Player has raised %d fingers\n",playerFingers);    // Print number of fingers to console
        computerFingers=new Random().nextInt(9)+1;    // Generate a random number between 1 (including) and 10
        System.out.printf("The computer has raised %d fingers\n",computerFingers);    // Print generated number to console
    }

    public void computeResult(){

        if(playerSel==0&&(playerFingers+computerFingers)%2!=0||playerSel!=0&&(playerFingers+computerFingers)%2==0){    // Determines who is the winner

            playerScore+=2;
            JOptionPane.showMessageDialog(null,
                    "The computer has raised "+computerFingers+" fingers!\nYou won this round!");    // Player won message
            roundsWon++;    // Increment number of rounds won
        }
        else {

            computerScore+=2;
            JOptionPane.showMessageDialog(null,
                    "The computer has raised "+computerFingers+" fingers!\nYou lost this round!");    // Player lost message
            roundsLost++;    // Increment number of rounds lost
        }

        if(playerFingers%2!=0){    // Check if player has selected an odd number

            playerOdds++;    // Increment amount of times player has picked an odd number
        }
        else{

            playerEvens++;    // Increment amount of times player has chosen an even number
        }

        if(computerFingers%2!=0){    // Check if computer has generated an odd number

            computerOdds++;    // Increment amount of times computer has picked an odd number
        }
        else{

            computerEvens++;    // Increment amount of times computer has picked an even number
        }

        if(playerFingers>computerFingers){    // Check if the player has the largest number

            JOptionPane.showMessageDialog(null,"You get an extra point!");
            playerScore++;
            extraPoints++;    // Player gets an extra point which is added to history
        }
        else if(playerFingers<computerFingers){    // Check if the computer generated number is the largest

            JOptionPane.showMessageDialog(null,"The computer gets an extra point!");
            computerScore++;    // Computer gets an extra point
        }
        else{

            JOptionPane.showMessageDialog(null,
                    "Equal number of fingers raised, nobody gets an extra point...");    // No extra points
        }

        JOptionPane.showMessageDialog(null,"You have "
                +playerScore+" points and the computer has "+computerScore+" points.");    // Display current score
        System.out.printf("Player score: %d ; Computer score: %d\n\n",playerScore,computerScore);    // Write score to console

        roundFingers[0][roundCounter]=playerFingers;    // Add value to player fingers column
        roundFingers[1][roundCounter]=computerFingers;    // Add value to computer generated column
        roundCounter++;    // Increment round counter
    }

    public void displayRoundHistory(){    // Display round history to GUI

        if(playerScore>computerScore){    // Check if the player has finished with the highest score

            JOptionPane.showMessageDialog(null,
                    "Congratulations, you have won the game!\n\nRounds:       1   2   3   4\nPlayer:         "+roundFingers[0][0]+
                            "  "+roundFingers[0][1]+"  "+roundFingers[0][2]+"  "+roundFingers[0][3]+"\nComputer:  "+roundFingers[1][0]+
                            "  "+roundFingers[1][1]+"  "+roundFingers[1][2]+"  "+roundFingers[1][3]);
        }
        else if(playerScore<computerScore){    // Check if the computer has finished with the highest score

            JOptionPane.showMessageDialog(null,
                    "Unfortunately you have lost...\n\nRounds:       1   2   3   4\nPlayer:         "+roundFingers[0][0]+
                            "  "+roundFingers[0][1]+"  "+roundFingers[0][2]+"  "+roundFingers[0][3]+"\nComputer:  "+roundFingers[1][0]+
                            "  "+roundFingers[1][1]+"  "+roundFingers[1][2]+"  "+roundFingers[1][3]);
        }
        else{    // Check if the final score is even

            JOptionPane.showMessageDialog(null,
                    "The game ended in a tie!\n\nRounds:       1   2   3   4\nPlayer:         "+roundFingers[0][0]+
                            "  "+roundFingers[0][1]+"  "+roundFingers[0][2]+"  "+roundFingers[0][3]+"\nComputer:  "+roundFingers[1][0]+
                            "  "+roundFingers[1][1]+"  "+roundFingers[1][2]+"  "+roundFingers[1][3]);
        }
    }

    public void displayGameHistory(){    // Display the game history to the GUI

        JOptionPane.showMessageDialog(null,"Total Games Played:  "+gameCounter+"\n\n"+history);
        System.out.println("Total Games Player:  "+gameCounter+"\n\n"+history);    // Write history to console
    }

    public boolean gamePlaying(){    // Check if the game is still being played

        if(playerScore<6&&computerScore<6){    // Check if the score hasn't reached 6

            return true;
        }
        else {

            gameCounter++;    // Increment game counter

            history.add("\nGame "+gameCounter+":"+"\n\nRounds won by the player: "+roundsWon+"\nRounds lost by the player:  "
                    +roundsLost+"\n\nExtra points received:         "+extraPoints+"\n\nEven numbers chosen by the player: "+playerEvens+
                    "\nOdd numbers chosen by the player:  "+playerOdds+"\n\nEven numbers chosen by the computer: "+computerEvens+
                    "\nOdd numbers chosen by the computer:  "+computerOdds+"\n");    // Add game details to separate entry in ArrayList

            return false;
        }
    }

    public void reset(){    // Reset instance variables for a new game

        roundCounter=0;
        playerScore=0;
        computerScore=0;
        roundsWon=0;
        roundsLost=0;
        extraPoints=0;
        playerEvens=0;
        playerOdds=0;
        computerEvens=0;
        computerOdds=0;

        for(int i=0;i<roundFingers.length;i++){    // Reset each element in round history array to 0
            for(int y=0;y<roundFingers[i].length;y++){
                roundFingers[i][y]=0;
            }
        }
    }
}
