public class Teste {
  public static void main(String[] args) {
    System.out.println("chamando m1()");
    try {
      m1();
    } catch (Exception e) {
      System.out.println("tratando exceções longe do local do erro!");
    }
    System.out.println("fim do método main");
  }
  
  private static void m1() throws ArithmeticException {
    System.out.println("chamando m2()");
    m2();
    System.out.println("fim do método m1()");
  }
  
  private static void m2() throws ArithmeticException {
    System.out.println("início do m2()");
    int x = 1 / 0;
    System.out.println("fim do método m2()");
  }
}