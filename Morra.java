//import java.util.*;
//
//public class Morra {
//
//    private int playerSel;
//    private int playerFingers;
//    private int computerFingers;
//
//    public Morra(int playerSel){
//
//        this.playerSel=playerSel;
//        System.out.println("Player selection is: "+playerSel);
//    }
//
//    public void setFingers(int playerFingers){
//
//        this.playerFingers=playerFingers;
//        System.out.printf("Player has raised %d fingers\n",playerFingers);
//        computerFingers=new Random().nextInt(9)+1;
//        System.out.printf("The computer has raised %d fingers\n",computerFingers);
//    }
//
//    public int getComputerFingers(){
//
//        return computerFingers;
//    }
//
//    public boolean getResult(){
//
//        if(playerSel==0){
//
//            return((playerFingers+computerFingers)%2!=0);
//        }
//        else{
//
//            return((playerFingers+computerFingers)%2==0);
//        }
//    }
//}

import java.util.*;
public class Morra {
    private int playerSel;
    private int playerFingers;
    private int computerFingers;
    public Morra(int playerSel){
        this.playerSel=playerSel;
        System.out.println("Player selection is: "+playerSel);
    }
    public void setFingers(int playerFingers){
        this.playerFingers=playerFingers;
        System.out.printf("Player has raised %d fingers\n",playerFingers);
        computerFingers=new Random().nextInt(9)+1;
        System.out.printf("The computer has raised %d fingers\n",computerFingers);
    }
    public int getComputerFingers(){
        return computerFingers;
    }
    public boolean getResult(){
        if(playerSel==0){
            return((playerFingers+computerFingers)%2!=0);
        }
        else{
            return((playerFingers+computerFingers)%2==0);
        }
    }
}