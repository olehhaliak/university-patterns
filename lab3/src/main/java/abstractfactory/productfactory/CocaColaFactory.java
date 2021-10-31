package abstractfactory.productfactory;

import abstractfactory.product.CocaCola;
import abstractfactory.product.Customization;
import abstractfactory.product.Product;

public class CocaColaFactory extends ProductFactory{
    @Override
    public Product getProduct(Customization customization) {
        Product product = new CocaCola(customization);
        product.make();
        return product;
    }
}
