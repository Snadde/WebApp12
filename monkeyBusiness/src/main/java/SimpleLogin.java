
import core.Customer;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class SimpleLogin implements Serializable{
        @Inject
        CustomerRegistryBean customerRegistryBean; 
        
        private String loginname;
	private String password;
        private Customer customer;

	public SimpleLogin(){}

	public String getLoginname(){
		return loginname;
	}

	public void setLoginname(String loginname){
		this.loginname = loginname;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String CheckValidUser(){

	List<Customer> results = customerRegistryBean.validateLogin(loginname, password);
       if (!results.isEmpty()) {
            customer = results.get(0);
        }
      else {
         return "login?faces-redirect=true";
      }
       return "showCustomers?faces-redirect=true";
   }

    

   public void setLogout() {
      
       System.out.println("LOGGED OUT MOTHERFUCKER!!!!");
      customer = null;

   }

    

   public boolean getIsLoggedIn() {

      return customer != null;

   }


   //@Produces
   //@LoggedIn 
   public Customer getCurrentUser() {

      return customer;

   }
   
   public Customer getCustomer(){
       return customer;
   }
}