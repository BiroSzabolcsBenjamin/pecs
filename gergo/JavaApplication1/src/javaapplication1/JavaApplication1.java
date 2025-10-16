
package javaapplication1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author szabi
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            int guessCount = 0;
            int firstNum = 1;
            int secondNum = 100;

            Random random = new Random();
            int randomNum = random.nextInt(firstNum, secondNum);
            Scanner input = new Scanner(System.in);
            System.out.println("Your Guess");
            int userGuess;

            do {
                userGuess = input.nextInt();

                if (userGuess < randomNum) {
                    System.out.println("higher");
                    guessCount++;
                } else if (userGuess > randomNum) {
                    System.out.println("lower");
                    guessCount++;
                } else {
                    System.out.println("GG");
                    System.out.println(guessCount);
                }
            } while (userGuess != randomNum);
    }

}
