package abstractfactory.productfactory;

import abstractfactory.product.Customization;
import abstractfactory.product.HotMilk;
import abstractfactory.product.Product;

public class HotMilkFactory extends ProductFactory{
    @Override
    public Product getProduct(Customization customization) {
        Product product = new HotMilk(customization);
        product.make();
        return product;
    }
}
