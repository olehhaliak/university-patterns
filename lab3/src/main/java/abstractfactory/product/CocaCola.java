package abstractfactory.product;

public class CocaCola extends AbstractProduct{
    public CocaCola(Customization customization) {
        super(customization);
    }

    @Override
    protected void applyCustomization() {
    }
    public void setCoke(double coke) {
        preparation.coke = coke;
    }
    public void setWater(double water) {
        preparation.water = water;
    }

}
