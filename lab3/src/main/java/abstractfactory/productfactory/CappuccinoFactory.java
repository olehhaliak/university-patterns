package abstractfactory.productfactory;

import abstractfactory.product.Cappuccino;
import abstractfactory.product.Customization;
import abstractfactory.product.Product;

public class CappuccinoFactory extends ProductFactory{
    @Override
    public Product getProduct(Customization customization) {
      Product product = new Cappuccino(customization);
      product.make();
      return product;
    }
}
