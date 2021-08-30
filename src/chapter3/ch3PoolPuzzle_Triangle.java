package chapter3;

class ch3PoolPuzzle_Triangle {
    double area;
    int height;
    int length;

    public static void main (String [] args) {
        int x = 0;
        ch3PoolPuzzle_Triangle [] ta = new ch3PoolPuzzle_Triangle[4];

        while (x < 4) {
            ta[x] = new ch3PoolPuzzle_Triangle();
            ta[x].height = (x + 1) * 2;
            ta[x].length = x + 4;
            ta[x].setArea();
            System.out.print("triangle "+x+", area");
            System.out.println(" = " + ta[x].area);
            x = x + 1;
        }
        int y = x;
        ch3PoolPuzzle_Triangle t5 = ta[2];
        ta[2].area = 343;
        System.out.print("y = " + y);
        System.out.println(", t5 area = "+ t5.area);
    }

    void setArea() {
        area = (height + length) / 2;
    }
}
