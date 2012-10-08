package core;

import core.Customer;
import core.OrderItem;
import core.PurchaseOrder.State;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-10-08T15:16:38")
@StaticMetamodel(PurchaseOrder.class)
public class PurchaseOrder_ { 

    public static volatile SingularAttribute<PurchaseOrder, Long> id;
    public static volatile ListAttribute<PurchaseOrder, OrderItem> items;
    public static volatile SingularAttribute<PurchaseOrder, State> state;
    public static volatile SingularAttribute<PurchaseOrder, Customer> customer;

}