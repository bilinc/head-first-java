package chapter5;

import java.util.Scanner;

public class SimpleDotComGame {
    public static void main (String [] args) {

//        declare: an int variable to hold the humber of user guesses named numOfGuesses, set it to 0.
        int numbOfGuesses = 0;

        GameHelper helper = new GameHelper();
//        make: a new SimpleDotCom instance
        SimpleDotCom simpleDotCom = new SimpleDotCom();
//        compute: a random number between 0 and 4 that will be the starting location cell position
        int randomNum = (int) (Math.random() * 5);
//        make: an int array with 3 ints using the randomly-generated number, that number incremented by 1
//        and that number incremented by 2 ( example 3,4,5)
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
//        invoke: the setLocationsCells() method on the SimpleDotCom instance
        simpleDotCom.setLocationCells(locations);
//        declare: a boolean variable representing the state of the game, named isAlive. SET it to true.
        boolean isAlive = true;

        Scanner scanner = new Scanner(System.in);
        // while the dot com is still alive (isAlive == true):
        while (isAlive) {
//          get user input from the command line
            String guess = helper.getUserInput("enter a number: ");
//          check the user guess
//          invoke the checkYourself() method on the SimpleDotCom instance
            String result = simpleDotCom.checkYourself(guess);
//          increment numOfGuesses variable
            numbOfGuesses++;

//          // check for dot com death
//          if result is "kill"
            if (result.equals("kill")) {
//              set isAlive to false (which means we won't enter the loop again)
                isAlive = false;
//              print the number of user guesses
                System.out.println("You took " + numbOfGuesses + " guesses.");
            }
        }
    }
}
