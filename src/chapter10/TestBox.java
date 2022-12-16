package chapter10;

public class TestBox {
  
  Integer i = 1;
  int j;
  
  public static void main (String[] args) {
    TestBox t = new TestBox();
    t.go();
  }
  
  public void go() {
//    j=i;
    System.out.println(i.getClass());
//    System.out.println(j);
  }
}
