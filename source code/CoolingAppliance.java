public class CoolingAppliance extends Appliance 
{
    private int temperatureSetting;

    public CoolingAppliance(String name, double powerRating, double usageHours, int temperatureSetting) 
    {
        super(name, powerRating, usageHours);
        this.temperatureSetting = temperatureSetting;
    }

    public int getTemperatureSetting() 
    {
        return temperatureSetting;
    }

    public void setTemperatureSetting(int temperatureSetting) 
    {
        this.temperatureSetting = temperatureSetting;
    }
    @Override
    public double calculateEnergyConsumption() 
    {
        double baseConsumption = super.calculateEnergyConsumption();
        if (temperatureSetting < 24) 
        {
            return baseConsumption * 1.15; // 15% energy penalty
        }
        return baseConsumption;
    }
}