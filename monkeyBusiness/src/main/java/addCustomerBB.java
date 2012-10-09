/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thituson
 */
import core.Address;
import core.Customer;
import core.Product;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.*;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named("addCustomer")
@RequestScoped
public class addCustomerBB implements Serializable{
    @Inject
    private CustomerRegistryBean customerRegistryBean;
    @NotNull
    private Long id;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]*")
    @Size(min = 1, message = "Must enter a name")
    private  String fname;
    @Pattern(regexp = "^[a-zA-Z]*")
    @Size(min = 1, message = "Must enter a name")
    private  String lname;
    
    private  String email;
    private  Address address;
    
    public addCustomerBB(){}
    
    public addCustomerBB(CustomerRegistryBean customerRegistryBean){
        this.customerRegistryBean = customerRegistryBean;
    
    }
    
    // Any name possible
    public String action() {
        Customer customer = new Customer(id, address, fname, lname, email);
        customerRegistryBean.add(customer);
        return "products?faces-redirect=true";  // Where to go, navigate 
    }

    public CustomerRegistryBean getCustomerRegistryBean() {
        return customerRegistryBean;
    }

    public void setCustomerRegistryBean(CustomerRegistryBean customerRegistryBean) {
        this.customerRegistryBean = customerRegistryBean;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    


    
    

   
        
    
    
    
}
