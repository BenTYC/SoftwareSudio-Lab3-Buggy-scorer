package netdb.courses.softwarestudio.buggyscorer;

public class Calculator {
	public static int add(int a, int b) {
		return a + b;
	}

	public static int sub(int a, int b) {
		return a - b;
	}

	public static int mul(int a, int b) {
		return a * b;
	}

	public static double div(int a, int b) {
		return (double)a / (double)b;
	}

}

//4.div(int a, int b)中(double) (a / b)先除成0才轉換type
//改成：(double)a / (double)b
