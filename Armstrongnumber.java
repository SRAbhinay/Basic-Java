import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int k, t = 1, l = 0, m = 0;
        Scanner ob = new Scanner(System.in);
        k = ob.nextInt();
        l = k;
        m = k;
        if (k > 0) {
            while (k > 0) {
                k /= 10;
                t++;
            }

            int sum = 0, dig = 0;
            while (l > 0) {
                dig = l % 10;
                l = l / 10;
                sum += Math.pow(dig, t); // Calculate the sum of digits raised to the power of t
            }
            if (sum == m) {
                System.out.println("Armstrong Number");
            } else {
                System.out.println("Not an Armstrong Number");
            }
        } else {
            System.out.println("Invalid Input");
        }
    }
}
