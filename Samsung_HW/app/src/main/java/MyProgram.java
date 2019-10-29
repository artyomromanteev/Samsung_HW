import java.util.Scanner;

public class MyProgram{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int a = in.nextInt(), b;
		char c = in.next().charAt(0);
		b = in .nextInt();
		switch(c){
			case '*':
				System.out.println(a + " * " + b + " = " + (a * b));
				break;
			case '/':
				System.out.println(a + " / " + b + " = " + (a / b));
				break;
			case '+':
				System.out.println(a + " + " + b + " = " + (a + b));
				break;
			case '-':
				System.out.println(a + " - " + b + " = " + (a - b));
				break;
			default:
				System.out.println("Incorrect character!");
		}
	}
}