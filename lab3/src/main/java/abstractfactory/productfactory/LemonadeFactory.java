package abstractfactory.productfactory;

import abstractfactory.product.Customization;
import abstractfactory.product.Lemonade;
import abstractfactory.product.Product;

public class LemonadeFactory extends ProductFactory{
    @Override
    public Product getProduct(Customization customization) {
        Product product = new Lemonade(customization);
        product.make();
        return product;
    }

}
