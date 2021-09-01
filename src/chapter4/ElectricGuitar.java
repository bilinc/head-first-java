package chapter4;

public class ElectricGuitar {

    private String brand;
    private int numOfPickups;
    private boolean rockStarUsesIt;

    public String getBrand() {
        System.out.println("Hello");
        return brand;
    }

    public void setBrand(String aBrand) {
        brand = aBrand;
    }

    public int getNumOfPickups() {
        return numOfPickups;
    }

    public void setNumOfPickups(int num) {
        numOfPickups = num;
    }

    public boolean getRockStarUsesIt() {
        return rockStarUsesIt;
    }

    public void setRockStarUsesIt(boolean yesOrNo) {
        rockStarUsesIt = yesOrNo;
    }

}
