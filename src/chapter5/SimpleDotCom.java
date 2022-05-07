package chapter5;

public class SimpleDotCom {
    // declare: and int array to hold the location cells. Call it locationCells
    int[] locationCells;
    // declare: an int to hold the number of hits. Call it numOfHits and SET it to 0
    int numOfHits = 0;
    // array storing the hits-cell
    int[] hitsCell = {-1, -1, -1};

    /**
     *     method: void setLocationCells(int[] cellLocations)
     *         get the cell locations as an int array parameter
     *         assign the cell locations parameter to the cell locations instance variable
     *     end method
     */
    // declare: a setLocationCells() setter method that takes an int array (which has the three cell locations as ints (2,3,4,etc)
    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    // declare: a checkYourself() method that takes a String for the user's guess ("1", "3", etc),
    // checks it, and returns a result representing a hit, miss, or kill
    public String checkYourself(String stringGuess) {
        // get the user guess as a String parameter and convert the user guess to an int
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";

        // compare the user guess to the location cell
        // if the user guess matches
        //      increment the number of hits
        //      find out if it was the last location cell
        // if number of hits is 3, return "kill" as the result
        //      else it was not a kill, so return "hit"
        // else the user guess did not match, so return "miss"
        for (int cell: locationCells) {
            if (guess == cell) {
                for (int e: hitsCell) {
                    if (e == guess) {
                        result = "already a hit";
                        System.out.println(result);
                        return result;
                    } else {
                        result = "hit";
                        hitsCell[numOfHits] = guess;
                        numOfHits++;
                        break;
                    }
                }
            }
        }
        if (numOfHits == locationCells.length) {
            result = "kill";
        }
        System.out.println(result);
        return result;
    }
}
