import java.util.Scanner;

class Account {
    private int id;
    private int bal;
    private double ir;
    private String na;
    private char a;
    private int amt;

    public Account() {
        id = 0;
        bal = 0;
        ir = 0;
    }

    public void getdata() {
        Scanner ob = new Scanner(System.in);
        id = ob.nextInt();
        na = ob.next();
        bal = ob.nextInt();
        ir = ob.nextDouble();
        a = ob.next().charAt(0);
        if (a != 'W' && a != 'D') {
            System.out.println("Invalid Operation");
        } else {
            amt = ob.nextInt();
        }
    }

    public void getInterest() {
        double i = (bal * ir) / 1200;
        System.out.printf("%.2f", i);
    }

    public void doWithdrawal() {
        if (bal >= amt) {
            bal = bal - amt;
            getInterest();
            displayBalance();
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void doDeposit() {
        bal = bal + amt;
        displayBalance();
    }

    public void displayBalance() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + na);
        System.out.println("Balance: " + bal);
    }

    public void processTransaction() {
        if (bal > 0) {
            if (a == 'W') {
                doWithdrawal();
            } else if (a == 'D') {
                displayBalance();
                doDeposit();
                getInterest();
            }
        } else {
            System.out.println("Invalid Balance");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.getdata();
        account.processTransaction();
    }
}
