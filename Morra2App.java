import javax.swing.*;    // Import library for GUI

public class Morra2App{    // Class definition for Morra Application

    public static void main(String args[]){    // Main method

        JFrame selection=new JFrame();    // Declaring a new JFrame for options
        String[]yesNo=new String[2];    // Declaring a string array to store yes/no options
        String[]oddsEvens=new String[2];    // Declaring a string array to store odds/evens options
        int playerSel;    // Declaring a variable for player selection
        int fingerInput=0;    // Declaring and initialising a variable for amount of fingers played
        int another;    // Declaring a variable for starting a new game
        boolean valid;    // Declaring a variable for input validation
        yesNo[0]="Yes";    // Adding "Yes" option to yes/no array
        yesNo[1]="No";    // Adding "No" option to yes/no array
        oddsEvens[0]="Odds";    // Adding "Odds" option to odds/evens array
        oddsEvens[1]="Evens";    // Adding "Evens" option to odds/evens array

        another=JOptionPane.showOptionDialog(selection.getContentPane(),"Welcome to the game of Morra!\n Would you like to play?",
                "The Morra Game",0,JOptionPane.INFORMATION_MESSAGE,null,yesNo,null);    // Displaying yes/no selection

        Morra2 myMorra=new Morra2();    // Declaring a new object of type Morra and instantianting the Morra Class

        while((another==JOptionPane.YES_OPTION)){    // A new game will start each time the user decides to continue

            playerSel=JOptionPane.showOptionDialog(selection.getContentPane(),"What will you choose?",
                    "Decisions decisions...",0,
                    JOptionPane.INFORMATION_MESSAGE,null,oddsEvens,null);    // Displaying odds/evens selection

            myMorra.setPlayerSelection(playerSel);    // Set instance to reflect user selection

            while(myMorra.gamePlaying()){    // While round end condition has not been met
                do{    // Ask user for a number between 1 and 10
                    try{    // Attempt the following

                        fingerInput=Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Choose a number between 1 and 10"));    // Convert user input to a number

                        if (fingerInput<=0||fingerInput>10) {    // Check if the number is smaller or equal to 0 or larger than 10

                            valid=false;
                            JOptionPane.showMessageDialog(null,
                                    "Invalid input, please try again");    // Number not valid
                        }
                        else{

                            valid=true;    // Number valid
                        }

                    }catch(Exception e){    // User input could not be converted

                        valid=false;
                        JOptionPane.showMessageDialog(null,
                                "Invalid input, please try again");    // Number not valid
                    }
                } while(!valid);    // If the input was not valid ask the user again

                myMorra.setFingers(fingerInput);    // Set instance to reflect user input
                myMorra.computeResult();    // Calculate the results of the round
            }
            myMorra.displayRoundHistory();    // Display the number of fingers from each round to GUI
            another=JOptionPane.showOptionDialog(selection.getContentPane(),
                    "Would you like to play another game?","The End?",0,
                    JOptionPane.INFORMATION_MESSAGE,null,yesNo,null);    // Ask user for another game
            myMorra.reset();    // Reset instance for another game
        }
        myMorra.displayGameHistory();    // Display game history to GUI and write to console
        JOptionPane.showMessageDialog(null,"Good bye!");    // Display farewell message
        System.exit(0);    // Close application
    }
}
