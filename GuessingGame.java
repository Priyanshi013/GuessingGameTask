import java.util.*;
class Game{
    int sysInput;
    int userInput;
    int noOfGuess=0;
    Game(){
        Random randomValue = new Random();
        this.sysInput=randomValue.nextInt(100)+1;
    }
    public boolean takeUserInput(){
        if(noOfGuess<10){
            System.out.println("Guess the number -->");
            this.userInput=GussingGame.takeInteger(100);
            noOfGuess++;
            return false;
        }
        else{
            System.out.println("No attempts left :\n");
            System.out.println("Better luck next time\n");
            return true;
        }
    }
    public boolean isCorrectGuess(){
        if(sysInput==userInput){
            System.out.println("Congratulations.... , You got the number "+sysInput+" in "+noOfGuess+" guesses..");
            switch(noOfGuess){
                case 1 -> System.out.println("Your score is 100.");
                case 2-> System.out.println("Your score is 90.");
                case 3 -> System.out.println("Your score is 80.");
                case 4 -> System.out.println("Your score is 70.");
                case 5 -> System.out.println("Your score is 60.");
                case 6 -> System.out.println("Your score is 50.");
                case 7 -> System.out.println("Your score is 40.");
                case 8 -> System.out.println("Your score is 30.");
                case 9 -> System.out.println("Your score is 20.");
                case 10 -> System.out.println("Your score is 10.");
            }
            System.out.println();
            return true;
        }
        else if(noOfGuess<10 && userInput>sysInput){
            if(userInput-sysInput>10){
                System.out.println("Too high..");
            }
            else{
                System.out.println("Little bit high");
            }
        }
        else if(noOfGuess<10){
            if(sysInput-userInput>10){
                System.out.println("Too low..");
            }
            else{
                System.out.println("Little bit low");
            }
        }
        return false;
    }
}
public class GussingGame {
    public static int takeInteger(int limit){
        int input =0;
        boolean flag = false;
        while(!flag){
            try{
                Scanner s = new Scanner(System.in);
                input=s.nextInt();
                flag=true;
                if(input > limit || input < 1){
                    System.out.println("Choose the number between 1 to "+limit+" .");
                    flag=false;
                }
            }
            catch(Exception e){
                System.out.println("Enter only Integer value ");
                flag=false;
            }
        }
        return input;
    }
    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("1.Start the game");
        System.out.println("2. Exit");
        System.out.println("Enter your choice :");
        int choice = takeInteger(2);
        int nextRound;
        int noOfRound=0;
         if(choice == 1)
             while(true){
             Game game = new Game();
             boolean isMatch = false;
             boolean limitCross =false;
             System.out.println("\n Round "+ ++noOfRound + " starts......!");
             while(!isMatch && !limitCross){
                 limitCross = game.takeUserInput();
                 isMatch = game.isCorrectGuess();
             }
             System.out.println("******************************************");
             System.out.println("1.Next Round ");
             System.out.println("2.Exit");
             System.out.println("Enter your choice :");
             nextRound = takeInteger(2);
             if(nextRound != 1){
                 System.exit(0);
             }
         }
         else{
             System.exit(0);
         }
    }
}