package abstractfactory.product;

/**
 * class that provides some default implementation for Product
 */
public abstract class AbstractProduct implements Product{
    protected Preparation preparation;
    protected Customization customization;
    @Override
    public void make() {
        applyCustomization();
    }

    protected abstract void applyCustomization();

    public AbstractProduct(Customization customization) {
        this.customization = customization;
        preparation = new Preparation();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName() + ":\n");
        if(preparation.milk!=0){
            sb.append("With milk: " + preparation.milk).append("\n");
        }
        if(preparation.sugar!=0){
            sb.append("With sugar: " + preparation.sugar).append("\n");
        }
        if(preparation.water!=0){
            sb.append("With water: " + preparation.water).append("\n");
        }
        if(preparation.coke!=0){
            sb.append("With coke: " + preparation.coke).append("\n");
        }
        if(preparation.liquidCoffee!=0){
            sb.append("With liquid coffee: " + preparation.liquidCoffee).append("\n");
        }
        if(preparation.addedFlavour!=0){
            sb.append("With added flavour: " + preparation.addedFlavour).append("\n");
        }
        if(preparation.tea!=0){
            sb.append("With tea: " + preparation.tea).append("\n");
        }
        if(customization.getMugSize()!=0){
            sb.append("WithMugSize:" +customization.getMugSize()).append("\n");
        }
        return sb.toString();
    }
}
