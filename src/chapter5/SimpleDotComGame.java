package chapter5;

public class SimpleDotComGame {
    /*
    declare: and int array to hold the location cells. Call it locationCells
    declare: an int to hold the number of hits. Call it numOfHits and SET it to 0

    declare: a checkYourself() method that takes a String for the user's guess ("1", "3", etc),
    checks it, and returns a result representing a hit, miss, or kill
    declare: a setLocationCells() setter method that takes an int array (which has the three cell locations as ints (2,3,4,etc)

    method: String checkYourself(String userGuess)
        get the user guess as a String parameter
        convert the user guess to an int
        repeat with each of the location cells in the int array
            // compare the user guess to the location cell
            if the user guess matches
                increment the number of hits
                // find out if it was the last location cell
                if number of hits is 3, return "kill" as the result
                else it was not a kill, so return "hit"
                end if
            else the user guess did not match, so return "miss"
            end if
        end repeat
    end method

    method: void setLocationCells(int[] cellLocations)
        get the cell locations as an int array parameter
        assign the cell locations parameter to the cell locations instance variable
    end method
    * */
    int[] locationCells;
    int numOfHits = 0;

    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";

        for (int cell: locationCells) {
            if (guess == cell) {
                result = "hit";
                numOfHits++;
                break;
            }

        }
        if (numOfHits == locationCells.length) {
            result = "kill";
        }
        System.out.println(result);
        return result;
    }
}
