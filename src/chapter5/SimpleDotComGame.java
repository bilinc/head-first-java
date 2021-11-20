package chapter5;

import java.util.Scanner;

public class SimpleDotComGame {
    public static void main (String [] args) {
        /*
        declare: an int variable to hold the humber of user guesses named numOfGuesses, set it to 0.
        make: a new SimpleDotCom instance
        compute: a random number between 0 and 4 that will be the starting location cell position
        make: an int array with 3 ints using the randomly-generated number, that number incremented by 1
        and that number incremented by 2 ( example 3,4,5)
        invoke: the setLocationsCells() method on the SimpleDotCom instance
        declare: a boolean variable representing the state of the game, named isAlive. SET it to true.

        while the dot com is still alive (isAlive == true):
            get user input from the command line
            // check the user guess
            invoke the checkYourself() method on the SimpleDotCom instance
            increment numOfGuesses variable
            // check for dot com death
            if result is "kill"
                set isAlive to false (which means we won't enter the loop again)
                print the number of user guesses
            end if
        end while
         */

        int numbOfGuesses;
        SimpleDotCom simpleDotCom = new SimpleDotCom();
        int randomNum = (int) (Math.random() * 5);
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};

        simpleDotCom.setLocationCells(locations);
        boolean isAlive = true;
        Scanner scanner = new Scanner(System.in);

        while (isAlive) {
            String userInput = scanner.nextLine();
            simpleDotCom.checkYourself(userInput);

        }



    }
}
