package chapter3;

public class Hobbit {
    String name;

    public static void main(String [] args) {

        Hobbit [] h = new Hobbit[3];
        int z = -1;
        while (z < 2) {
            z = z + 1;
            h[z] = new Hobbit() ;
            h[z].name = "Cristiano";
            if (z == 1) {
                h[z].name = "Frodo Baggins";
            }
            if (z == 2) {
                h[z].name = "sam";
            }
            System.out.print(h[z].name + " is a ");
            System.out.println("good Hobbit name");
        }

    }
}
