package chapter10;

class StaticSuper {
  static {
    System.out.println("super static block");
  }
  
  StaticSuper() {
    System.out.println("super constructor");
  }
}
