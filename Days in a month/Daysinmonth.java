import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        
        scanner.close();
        
        if (isValidMonth(month) && isValidYear(year)) {
             String monthName = getMonthName(month);
            int daysInMonth = getDaysInMonth(month, year);
            
            System.out.printf("%s %d has %d days%n", monthName, year, daysInMonth);
        } else {
            System.out.println("Invalid input");
        }
    }
    
    private static boolean isValidMonth(int month) {
        return month >= 1 && month <= 12;
    }
    
    private static boolean isValidYear(int year) {
        return year >= 0;
    }
    
    private static String getMonthName(int month) {
        String[] monthNames = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
        };
        return monthNames[month - 1];
    }
    
    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return (isLeapYear(year)) ? 29 : 28;
            default:
                return 31;
        }
    }
    
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
