package abstractfactory.product;

public class HotMilk extends AbstractProduct{
    public HotMilk(Customization customization) {
        super(customization);
    }
    @Override
    protected void applyCustomization() {
       preparation.milk += customization.getExtraMilk();
    }
    public void setMilk(double milk) {
        preparation.milk = milk;
    }

}
