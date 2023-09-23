import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        boolean flag = true;
        int n, num, r, c = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        n = sc.nextInt();
        num = n;
        while (num > 0) {
            r = num % 10;
            c++;
            num = num / 10;
        }
        num = n;
        for (int i = 1; i <= c; i++) {
            r = num % 10;
            num = num / 10;
            num = (r * (int) Math.pow(10, c - 1)) + num;
            if (!prime(num)) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("Circular Prime");
        } else {
            System.out.println("Not Circular Prime");
        }
    }

    static boolean prime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
