package core;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The complete shop as a singleton
 * 
 * NOTE: Uses Java 1.7
 *
 * @author hajo
 */
public enum JPAShop {

    INSTANCE;
    private final IProductCatalogue productCatalogue = ProductCatalogue.newInstance("shop_pu");
    private final ICustomerRegistry customerRegistry = CustomerRegistry.newInstance("shop_pu");
    private final IOrderBook orderBook = OrderBook.newInstance("shop_pu");

    private JPAShop() {
        Logger.getAnonymousLogger().log(Level.INFO, "Shop alive {0}", this.hashCode());

    }

    public ICustomerRegistry getCustomerRegistry() {
        return customerRegistry;
    }

    public IOrderBook getOrderBook() {
        return orderBook;
    }

    public IProductCatalogue getProductCatalogue() {
        return productCatalogue;
    }
}
