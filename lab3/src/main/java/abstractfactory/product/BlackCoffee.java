package abstractfactory.product;

public class BlackCoffee extends AbstractProduct{
    public BlackCoffee(Customization customization) {
        super(customization);
    }

    @Override
    protected void applyCustomization() {
        preparation.milk+=customization.getExtraMilk();
        preparation.sugar+= customization.getSugar();
    }
    public void setWater(double water) {
        preparation.water = water;
    }
    public void setLiquidCoffee(double liquidCoffee) {
        preparation.liquidCoffee = liquidCoffee;
    }

}
