import java.util.Scanner;

class TollPlaza {
    private String vehicleType;
    private double vehiclePrice;
    private boolean isGovernmentVehicle;

    public void getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Vehicle Type (C/V/B/L): ");
        this.vehicleType = scanner.next().toUpperCase();
        
        System.out.print("Enter Vehicle Price: ");
        this.vehiclePrice = scanner.nextDouble();

        System.out.print("Is it a Government Vehicle (Y/N): ");
        this.isGovernmentVehicle = scanner.next().equalsIgnoreCase("Y");
    }

    public void putData() {
        System.out.println("Government Vehicle: " + (isGovernmentVehicle ? "Yes" : "No"));
        System.out.println("Vehicle Type: " + vehicleType);

        if (vehiclePrice < 0) {
            System.out.println("Invalid Price");
        } else {
            System.out.println("Vehicle Price: " + vehiclePrice);
            System.out.println("Toll Rate: " + tollRate());
        }
    }

    public double tollRate() {
        if (isGovernmentVehicle) {
            return 0.0; // Government servants get a full waiver
        } else {
            switch (vehicleType) {
                case "C":
                    return 50.0;
                case "V":
                    return 75.0;
                case "B":
                case "L":
                    return 100.0;
                default:
                    System.out.println("Invalid Vehicle Type");
                    return -1.0;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TollPlaza tollPlaza = new TollPlaza();
        tollPlaza.getData();
        tollPlaza.putData();
    }
}
