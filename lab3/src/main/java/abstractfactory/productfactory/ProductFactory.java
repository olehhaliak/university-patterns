package abstractfactory.productfactory;

import abstractfactory.product.Customization;
import abstractfactory.product.Product;

import java.util.HashMap;

public abstract class ProductFactory {
    static HashMap<Class<? extends ProductFactory>,ProductFactory> factories;
    static {
        factories = new HashMap<>();
        factories.put(CappuccinoFactory.class,new CappuccinoFactory());
        factories.put(BlackCoffeeFactory.class,new BlackCoffeeFactory());
        factories.put(LemonadeFactory.class,new LemonadeFactory());
        factories.put(HotMilkFactory.class,new HotMilkFactory());
        factories.put(CocaColaFactory.class,new CocaColaFactory());
    }
    public static ProductFactory getProductFactory(Class<? extends ProductFactory> clazz){
        return factories.get(clazz);
    }

    public abstract Product getProduct(Customization customization);
}
