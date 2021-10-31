package abstractfactory.product;

public class Cappuccino extends AbstractProduct{
    public Cappuccino(Customization customization) {
        super(customization);
    }

    @Override
    protected void applyCustomization() {
        preparation.milk+=customization.getExtraMilk();
        preparation.sugar+= customization.getSugar();
    }

    public void setSugar(double sugar) {
        preparation.sugar = sugar;
    }
    public void setMilk(double milk) {
        preparation.milk = milk;
    }
    public void setLiquidCoffee(double liquidCoffee) {
        preparation.liquidCoffee = liquidCoffee;
    }

}
