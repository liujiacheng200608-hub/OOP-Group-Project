import java.util.Scanner;
import java.util.ArrayList;

public class EnergyTrackerApp 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Appliance> applianceList = new ArrayList<>();
        boolean isRunning = true;
        System.out.println("=================================================");
        System.out.println("       Household Energy Consumption Tracker      ");
        System.out.println("=================================================");
        while (isRunning) 
        {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add a standard appliance");
            System.out.println("2. Add a cooling appliance");
            System.out.println("3. View total energy consumption");
            System.out.println("4. Exit program");
            System.out.print("Please enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) 
            {
                case 1:
                    System.out.print("Enter appliance name (e.g., TV, Washing Machine): ");
                    String name = scanner.nextLine();
                    System.out.print("Enter power rating in Watts: ");
                    double power = scanner.nextDouble();
                    System.out.print("Enter daily usage in hours: ");
                    double hours = scanner.nextDouble();

                    Appliance newAppliance = new Appliance(name, power, hours);
                    applianceList.add(newAppliance);
                    System.out.println("Standard appliance added successfully.");
                    break;

                case 2:
                    System.out.print("Enter cooling appliance name (e.g., Air Conditioner): ");
                    String coolName = scanner.nextLine();
                    System.out.print("Enter power rating in Watts: ");
                    double coolPower = scanner.nextDouble();
                    System.out.print("Enter daily usage in hours: ");
                    double coolHours = scanner.nextDouble();
                    System.out.print("Enter temperature setting (°C): ");
                    int temp = scanner.nextInt();

                    CoolingAppliance newCooling = new CoolingAppliance(coolName, coolPower, coolHours, temp);
                    applianceList.add(newCooling);
                    System.out.println("Cooling appliance added successfully.");
                    break;

                case 3:
                    if (applianceList.isEmpty()) 
                    {
                        System.out.println("⚠️ No appliances recorded yet. Please add one first.");
                    } 
                    else 
                    {
                        double totalEnergy = 0.0;
                        System.out.println("\n--- Energy Consumption Report ---");
                        for (Appliance app : applianceList) 
                        {
                            double dailyConsumption = app.calculateEnergyConsumption();
                            totalEnergy += dailyConsumption;
                            System.out.printf("- %s: %.2f kWh/day\n", app.getName(), dailyConsumption);
                        }
                        
                        System.out.println("---------------------------------");
                        System.out.printf("Total Daily Household Consumption: %.2f kWh\n", totalEnergy);
                    }
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Thank you for using the Energy Tracker. Stay Green!");
                    break;
                default:
                    System.out.println("Invalid selection. Please enter a number between 1 and 4.");
            }
        }
        scanner.close();
    }
}