import javax.swing.*;

public class MorraApp{

    public static void main(String args[]){

       JFrame selection=new JFrame();
       String[]yesNo=new String[2];
       String[]oddsEvens=new String[2];
       int playerSel;
       int playerFingers=0;
       int computerFingers=0;
       int playerScore=0;
       int computerScore=0;
       int another;
       boolean valid=false;

       yesNo[0]="Yes";
       yesNo[1]="No";

       oddsEvens[0]="Odds";
       oddsEvens[1]="Evens";

       another=JOptionPane.showOptionDialog(selection.getContentPane(),"Welcome to the game of Morra!\n Would you like to play?","The Morra Game",0,JOptionPane.INFORMATION_MESSAGE,null,yesNo,null);

       while((another!=JOptionPane.NO_OPTION)){

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

               if(myMorra.getResult()){

                   playerScore+=2;
                   JOptionPane.showMessageDialog(null,"The computer has raised "+computerFingers+" fingers!\nYou won this round!");
               }
               else{

                   computerScore+=2;
                   JOptionPane.showMessageDialog(null,"The computer has raised "+computerFingers+" fingers!\nYou lost this round!");
               }

               if(playerFingers>myMorra.getComputerFingers()){

                   JOptionPane.showMessageDialog(null,"You get an extra point!");
                   playerScore++;
               }
               else if(playerFingers<myMorra.getComputerFingers()){

                   JOptionPane.showMessageDialog(null,"The computer gets an extra point!");
                   computerScore++;
               }
               else{

                   JOptionPane.showMessageDialog(null,"Equal number of fingers raised, nobody gets an extra point...");
               }

               JOptionPane.showMessageDialog(null,"You have " + playerScore + " points and the computer has "+computerScore+" points");
               System.out.printf("Player score: %d ; Computer score: %d\n\n",playerScore,computerScore);
           }
           playerScore=0;
           computerScore=0;
           another=JOptionPane.showOptionDialog(selection.getContentPane(),"Would you like to play another game?","The End?",0,JOptionPane.INFORMATION_MESSAGE,null,yesNo,null);
       }
       JOptionPane.showMessageDialog(null,"Good bye!");
       System.exit(0);
   }
}
