package chapter5;

public class Chapter5CodeMagnets_MultiFor {
  public static  void main(String [] args) {
    for (int x = 0; x < 4; x++) {
      for ( int y = 4; y > 2; y--) {
        System.out.println(x + " " + y);
      }
      if (x == 1) {
        x++;
      }
    }
  }
}
