
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author coleb
 */
public class ControlFlowProject {
    
    public static void main(String args[]) {
        
        ArrayList<Integer> myList = new ArrayList<>();
        final int maxMagic = 75;
        final int maxNorm = 65;
        boolean continueLoop = true;
        
        Random rand = new Random();
        int randNum1 = rand.nextInt(9) + 1; 
        int randNum2 = rand.nextInt(9) + 1;
        
        AsciiChars.printNumbers();
        AsciiChars.printUpperCase();
        AsciiChars.printLowerCase();
        
        System.out.println("-------------------------------------------------------");
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = input.nextLine();
        System.out.println("Hello " + name);
        
        while(continueLoop) {
        
        System.out.println("Do you wish to continue to the interactive portion?");
        String answer = input.next();
        if (answer.equals("yes") || answer.equals("y")) {
            System.out.println("Do you have a red car (yes, no)");
            String car = input.next();
            if (car.equals("yes")) {
                boolean redCar = true;
            }
            else {
                boolean redCar = false;
            }
            System.out.println("What is the name of your favorite pet?");
            String petName = input.next();
            myList.add((int) petName.charAt(2)); //first lottery num
            
            System.out.println("What is your pets age?");
            int age = input.nextInt();
            
            System.out.println("What is your lucky number?");
            int num = input.nextInt();
            
            int magicNum;
            System.out.println("Do you have a favorite QB? (y/n)");
            String favQB = input.next();
            if(favQB.equals("y")) {
                System.out.println("What is his number?");
                int numQB = input.nextInt();
                magicNum = numQB * randNum1;
            }
            else {
                magicNum = num * randNum2;
            }
            
            System.out.println("Two digit model year of car");
            int modelYear = input.nextInt();
            myList.add(modelYear + num); //2nd num
            
            System.out.println("First name of your fav actor/actress?");
            String actor = input.next();
            myList.add((int)actor.charAt(0)); //3rd
            myList.add((int)actor.charAt(actor.length()-1)); //4th
            
            int randNum = -1;
            while (randNum < 1 && randNum >50) {
                System.out.println("Enter a random number between 1-50");
                randNum = input.nextInt();
            }
            myList.add(42); //5th
            
            for(int i = 0; i < 5; i++) {
                while (myList.get(i) > maxNorm) {
                    myList.set(i, myList.get(i) - maxNorm);
                }
            }
            
            while (magicNum > maxMagic) {
                magicNum = magicNum - maxMagic;
            }
            
            System.out.println("Lottery Numbers: " + myList.toString().substring(1, myList.toString().length() - 1) + " Magic Number: " + magicNum);
            
            System.out.println("Would you like to play again? (y/n)");
            if(input.next().equals("y")) myList.clear();
            else continueLoop = false;
            
        }
        else {
            System.out.println("Okay, return later to complete the survey");
            System.exit(0);
        }
        
        }
        System.out.println("Thank you for playing");
    }
    
}
