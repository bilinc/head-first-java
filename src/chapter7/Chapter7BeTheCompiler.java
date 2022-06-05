package chapter7;

import org.w3c.dom.ls.LSOutput;

public class Chapter7BeTheCompiler {
  public static void main(String [] args ) {
    Monster [] ma = new Monster[3];
    ma[0] = new Vampire();
    ma[1] = new Dragon();
    ma[2] = new Monster();
    
    for (int x = 0; x < 3; x++ ) {
      ma[x].frighten(x);
    }
  }
  
  static class Monster {
    boolean frighten(int d) {
      System.out.println("arrrgh");
      return true;
    }
  }
  
  static class Vampire extends Monster {
    boolean frighten(int x) {
      System.out.println("a bite?");
      return false;
    }
  }
  
  static class Dragon extends Monster {
    boolean frighten(int degree) {
      System.out.println("breath fire");
      return true;
    }
  }
}
