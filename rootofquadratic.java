import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, c;

        //taking user input
        System.out.print("Enter the coefficients a, b, and c: ");
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (a == 0) {
            System.out.println("Invalid input: By property of quadratic equation,'a' cannot be zero.");
        } 
        else if (discriminant > 0) {
            
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            
            System.out.printf("Root 1: %.3f%n", root1);
            System.out.printf("Root 2: %.3f%n", root2);
        } 
        else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.printf("Root: %.3f%n", root);
        } 
        else {
            System.out.println("No real roots");
        }
    }
}
