import java.util.Stack;

public class TestComplexExpression {

	public static void main(String[] args) {
		String tokenString = "3 4 + 7 2 - * 9 2 * 38 - +";
		ComplexExpression suffixExp = new ComplexExpression(tokenString);
		int result = suffixExp.interpret();
		System.out.println("Ket qua tinh " +tokenString + " la: " + result);
        }
}