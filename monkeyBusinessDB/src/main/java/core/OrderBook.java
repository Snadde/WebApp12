
package core;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * All orders
 * @author hajo
 */
public final class OrderBook extends AbstractDAO<PurchaseOrder, Long> implements IOrderBook{

    public static IOrderBook newInstance(String puName) {
       return new OrderBook(puName);
    }
    
    private OrderBook(String puName){
        super(PurchaseOrder.class, puName);
    }

   
    @Override
    public List<PurchaseOrder> getByCustomer(Customer c) {
        List<PurchaseOrder> found = new ArrayList<>();
        for (PurchaseOrder po : getAll()) {
            if (po.getCustomer().equals(c)) {
                found.add(po);
            }
        }
        return found;
    }
    
//    @Override
//    public List<PurchaseOrder> getByCustomer(Customer c) {
//        EntityManager em = emf.createEntityManager();
//        String purchaseOrdersByCustomer = "select po from PurchaseOrder po where po.customer = :customer";
//        TypedQuery<PurchaseOrder> tq = em.createQuery(purchaseOrdersByCustomer, PurchaseOrder.class);
//        tq.setParameter("customer", c);
//        List<PurchaseOrder> found = tq.getResultList();
//        return found;
//    }
}
