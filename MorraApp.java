import javax.swing.*;
import java.util.*;

public class MorraApp{

    public static void main(String args[]){

        JFrame selection=new JFrame();
        String[]yesNo=new String[2];
        String[]oddsEvens=new String[2];
        int[][]roundFingers=new int[2][4];
        ArrayList<String>history=new ArrayList<>();
        int roundCounter;
        int gameCounter=0;
        int roundsWon;
        int roundsLost;
        int extraPoints;
        int playerOdds;
        int playerEvens;
        int computerOdds;
        int computerEvens;
        int playerSel;
        int playerFingers=0;
        int computerFingers;
        int playerScore;
        int computerScore;
        int another;
        boolean valid;

        yesNo[0]="Yes";
        yesNo[1]="No";

        oddsEvens[0]="Odds";
        oddsEvens[1]="Evens";

        another=JOptionPane.showOptionDialog(selection.getContentPane(),"Welcome to the game of Morra!\n Would you like to play?","The Morra Game",0,JOptionPane.INFORMATION_MESSAGE,null,yesNo,null);

        while((another!=JOptionPane.NO_OPTION)){

            playerScore=0;
            computerScore=0;
            roundCounter=0;
            roundsWon=0;
            roundsLost=0;
            extraPoints=0;
            playerOdds=0;
            playerEvens=0;
            computerOdds=0;
            computerEvens=0;

            gameCounter++;
            playerSel=JOptionPane.showOptionDialog(selection.getContentPane(),"What will you choose?","Decisions decisions...",0,JOptionPane.INFORMATION_MESSAGE,null,oddsEvens,null);
            Morra myMorra=new Morra(playerSel);

            while(playerScore<6&&computerScore<6){

                do{
                    try{

                        playerFingers=Integer.parseInt(JOptionPane.showInputDialog(null,"Choose a number between 1 and 10"));

                        if (playerFingers<=0||playerFingers>10) {

                            valid=false;
                            JOptionPane.showMessageDialog(null,"Invalid input, please try again");
                        }
                        else{

                            valid=true;
                        }

                    }catch(Exception e){

                        valid=false;
                        JOptionPane.showMessageDialog(null,"Invalid input, please try again");
                    }
                } while(!valid);

                myMorra.setFingers(playerFingers);
                computerFingers=myMorra.getComputerFingers();
                System.out.println(myMorra.getResult());

                roundFingers[0][roundCounter]=playerFingers;
                roundFingers[1][roundCounter]=computerFingers;
                roundCounter++;

                if(playerFingers%2!=0){

                    playerOdds++;
                }
                else{

                    playerEvens++;
                }

                if(computerFingers%2!=0) {

                    computerOdds++;
                }
                else{

                    computerEvens++;
                }

                if(myMorra.getResult()){

                    playerScore+=2;
                    JOptionPane.showMessageDialog(null,"The computer has raised "+computerFingers+" fingers!\nYou won this round!");
                    roundsWon++;
                }
                else{

                    computerScore+=2;
                    JOptionPane.showMessageDialog(null,"The computer has raised "+computerFingers+" fingers!\nYou lost this round!");
                    roundsLost++;
                }

                if(playerFingers>myMorra.getComputerFingers()){

                    JOptionPane.showMessageDialog(null,"You get an extra point!");
                    playerScore++;
                    extraPoints++;
                }
                else if(playerFingers<myMorra.getComputerFingers()){

                    JOptionPane.showMessageDialog(null,"The computer gets an extra point!");
                    computerScore++;
                }
                else{

                    JOptionPane.showMessageDialog(null,"Equal number of fingers raised, nobody gets an extra point...");
                }

                JOptionPane.showMessageDialog(null,"You have " + playerScore + " points and the computer has "+computerScore+" points.");
                System.out.printf("Player score: %d ; Computer score: %d\n\n",playerScore,computerScore);
            }

            if(playerScore>computerScore){

                JOptionPane.showMessageDialog(null,
                        "Congratulations, you have won the game!\n\nRounds:      1  2  3  4\nPlayer:         "+roundFingers[0][0]+
                "  "+roundFingers[0][1]+"  "+roundFingers[0][2]+"  "+roundFingers[0][3]+"\nComputer:  "+roundFingers[1][0]+
                "  "+roundFingers[1][1]+"  "+roundFingers[1][2]+"  "+roundFingers[1][3]);
            }
            else if(playerScore<computerScore){

                JOptionPane.showMessageDialog(null,
                        "Unfortunately you have lost...\n\nRounds:      1  2  3  4\nPlayer:         "+roundFingers[0][0]+
                                "  "+roundFingers[0][1]+"  "+roundFingers[0][2]+"  "+roundFingers[0][3]+"\nComputer:  "+roundFingers[1][0]+
                                "  "+roundFingers[1][1]+"  "+roundFingers[1][2]+"  "+roundFingers[1][3]);
            }
            else{

                JOptionPane.showMessageDialog(null,
                        "The game ended in a tie!\n\nRounds:      1  2  3  4\nPlayer:         "+roundFingers[0][0]+
                                "  "+roundFingers[0][1]+"  "+roundFingers[0][2]+"  "+roundFingers[0][3]+"\nComputer:  "+roundFingers[1][0]+
                                "  "+roundFingers[1][1]+"  "+roundFingers[1][2]+"  "+roundFingers[1][3]);
            }

            history.add("\nGame "+gameCounter+":"+"\n\nRounds won by the player: "+roundsWon+"\nRounds lost by the player:  "+roundsLost+
            "\n\nExtra points received:         "+extraPoints+"\n\nEven numbers chosen by the player: "+playerEvens+
            "\nOdd numbers chosen by the player:  "+playerOdds+"\n\nEven numbers chosen by the computer: "+computerEvens+
            "\nOdd numbers chosen by the computer:  "+computerOdds+"\n");


            another=JOptionPane.showOptionDialog(selection.getContentPane(),"Would you like to play another game?","The End?",0,JOptionPane.INFORMATION_MESSAGE,null,yesNo,null);
        }

        JOptionPane.showMessageDialog(null,"Total Games Played:  "+gameCounter+"\n\n"+history);

        JOptionPane.showMessageDialog(null,"Good bye!");
        System.exit(0);
    }
}
