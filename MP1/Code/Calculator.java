import java.util.*;

class Calculator{

	public double answer;
	public String operation;
    public String name;


	public void addition(double doubleA, double doubleB){
		double answer= doubleA + doubleB;
		System.out.println("The sum of "  + doubleA +  " + " + doubleB + " is " + answer);
	}
	public void subtraction(double doubleA, double doubleB){
		double answer= doubleA - doubleB;
		System.out.println("The difference of " + doubleA + " - " + doubleB + " is "+ answer);
	}
	public void multiplication(double doubleA, double doubleB){
		double answer= doubleA * doubleB;
		System.out.println("The product of " + doubleA+ " * " + doubleB + " is "+ answer);
	}
	public void setname(String input){
		this.name = input;
	}
	public String getname(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your group number:");
		String name = sc.nextLine();
		System.out.println("Welcome to the Calculator designed by Group " + name);
		return name;
	}
	
	public static void main (String[] args){
		Calculator mycalc= new Calculator();
		String nameInput = mycalc.getname();
		mycalc.setname(nameInput);
		// stores two numbers
        double a, b;
        // takes input from the user
        Scanner sc = new Scanner(System.in);
        String op = "B";
        loop: while (op != "Q")
        {
        	System.out.println("Enter A to Add, S to Subtract, M to Multiply, and Q to quit");
            op = sc.nextLine();
            switch (op) {
            // addition
            case "A":
            	System.out.println("Enter argument 1: ");
                a = Double.parseDouble(sc.nextLine());
                System.out.println("Enter argument 2: ");
                b = Double.parseDouble(sc.nextLine());
                mycalc.addition(a, b);
                continue;
            // subtraction
            case "S":
            	System.out.println("Enter argument 1: ");
                a = Double.parseDouble(sc.nextLine());
                System.out.println("Enter argument 2: ");
                b = Double.parseDouble(sc.nextLine());
                mycalc.subtraction(a, b);
                continue;
            // multiplication
            case "M":
            	System.out.println("Enter argument 1: ");
               a = Double.parseDouble(sc.nextLine());
               System.out.println("Enter argument 2: ");
               b = Double.parseDouble(sc.nextLine());
               mycalc.multiplication(a, b);
               continue;
            // user wants to quit
            case "Q":
            	System.out.println("Thank you for using this calculator. Goodbye!");
                break loop;
            // erroneous input
            default:
                System.out.println("You entered an incorrect input.");
                continue;
        	}
        }
        sc.close();
    }
	sc.close();
}