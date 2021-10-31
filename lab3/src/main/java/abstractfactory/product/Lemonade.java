package abstractfactory.product;

public class Lemonade extends AbstractProduct{
    public Lemonade(Customization customization) {
        super(customization);
    }

    @Override
    protected void applyCustomization() {
        preparation.sugar+= customization.getSugar();
    }
    public void setWater(double water) {
        preparation.water = water;
    }
    public void setSugar(double sugar) {
        preparation.sugar = sugar;
    }
    public void setAddedFlavour(double addedFlavour) {
        preparation.addedFlavour = addedFlavour;
    }

}
