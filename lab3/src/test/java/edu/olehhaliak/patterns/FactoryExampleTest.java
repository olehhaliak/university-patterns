package edu.olehhaliak.patterns;

import abstractfactory.product.Customization;
import abstractfactory.product.Product;
import abstractfactory.productfactory.CappuccinoFactory;
import abstractfactory.productfactory.ProductFactory;
import org.junit.jupiter.api.Test;

public class FactoryExampleTest {
    @Test
    void example() {
        ProductFactory factory = ProductFactory.getProductFactory(CappuccinoFactory.class);
        Product product =factory.getProduct(new Customization(15,3,250));
        System.out.println(product);
    }
}
