import java.util.Scanner;

public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        speed = SLOW;
        on = false;
        radius = 5.0;
        color = "blue";
    }

    // Accessor and mutator methods for speed
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed == SLOW || speed == MEDIUM || speed == FAST) {
            this.speed = speed;
        } else {
            System.out.println("Invalid Speed");
        }
    }

    // Accessor and mutator methods for on
    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    // Accessor and mutator methods for radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Accessor and mutator methods for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // toString method
    public String toString() {
        if (on) {
            return "Fan speed: " + speed + ", color: " + color + ", radius: " + radius;
        } else {
            return "Fan color: " + color + ", radius: " + radius + ", fan is off";
        }
    }
}

public class FanApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        Fan fan = new Fan();

        // Input from user
        System.out.print("Enter speed (1 for SLOW, 2 for MEDIUM, 3 for FAST): ");
        int speed = scanner.nextInt();
        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();
        System.out.print("Enter color: ");
        String color = scanner.next();
        System.out.print("Turn the fan on (t/f): ");
        String turnOn = scanner.next();

        // Set fan properties
        fan.setSpeed(speed);
        fan.setRadius(radius);
        fan.setColor(color);

        if (turnOn.equalsIgnoreCase("t")) {
            fan.setOn(true);
        } else if (turnOn.equalsIgnoreCase("f")) {
            fan.setOn(false);
        } else {
            System.out.println("Invalid Option");
            return;
        }

        // Print the fan description
        System.out.println(fan.toString());
        
        scanner.close(); // Close the Scanner
    }
}
