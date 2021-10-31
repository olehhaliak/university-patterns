package abstractfactory.productfactory;

import abstractfactory.product.BlackCoffee;
import abstractfactory.product.Customization;
import abstractfactory.product.Product;

public class BlackCoffeeFactory extends ProductFactory{
    @Override
    public Product getProduct(Customization customization) {
        Product product = new BlackCoffee(customization);
        product.make();
        return product;
    }
}
