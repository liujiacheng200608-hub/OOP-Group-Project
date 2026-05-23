public class Appliance 
{
    private String name;
    private double powerRating;
    private double usageHours;
    public Appliance(String name, double powerRating, double usageHours) 
    {
        this.setName(name);
        this.setPowerRating(powerRating);
        this.setUsageHours(usageHours);
    }
    public String getName() 
    { 
        return name; 
    }
    
    public void setName(String name) 
    {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Unknown Appliance";
        } else {
            this.name = name;
        }
    }

    public double getPowerRating() 
    { 
        return powerRating; 
    }
    
    public void setPowerRating(double powerRating) 
    {
        if (powerRating >= 0) 
        {
            this.powerRating = powerRating;
        } 
        else 
        {
            System.out.println("Error: Power rating cannot be negative. Set to 0.");
            this.powerRating = 0;
        }
    }

    public double getUsageHours()
    { 
        return usageHours; 
    }
    
    public void setUsageHours(double usageHours) 
    {
        if (usageHours >= 0 && usageHours <= 24) 
        {
            this.usageHours = usageHours;
        } 
        else 
        {
            System.out.println("Error: Invalid usage hours. Set to 0.");
            this.usageHours = 0;
        }
    }

    public double calculateEnergyConsumption() 
    {
        return (powerRating * usageHours) / 1000.0;
    }
}