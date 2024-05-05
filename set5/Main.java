public class Main {
    public static void main(String[] args) {
        Expression expr = new Subtract(new Multiply(new Add(new Const(4), new Variable("x")), new Variable("a")), new Add(new Const(3), new Variable("x")));
        
        System.out.println("Wyrazenie: " + expr);
        
        expr.setVariable("a", 5);
        expr.setVariable("x", 3);
        System.out.println("Wartosc dla x=3 i a=5: " + expr.evaluate());
    }
}