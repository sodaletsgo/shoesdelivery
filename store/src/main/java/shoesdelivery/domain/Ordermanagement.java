package shoesdelivery.domain;

import shoesdelivery.domain.ShippingStarted;
import shoesdelivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Ordermanagement_table")
@Data

public class Ordermanagement  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String productName;
    
    
    
    
    
    private String deliveryAddress;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private Long phoneNumber;
    
    
    
    
    
    private Date deliveryDate;

    @PostPersist
    public void onPostPersist(){


        ShippingStarted shippingStarted = new ShippingStarted(this);
        shippingStarted.publishAfterCommit();

    }

    public static OrdermanagementRepository repository(){
        OrdermanagementRepository ordermanagementRepository = StoreApplication.applicationContext.getBean(OrdermanagementRepository.class);
        return ordermanagementRepository;
    }




    public static void receiveOrderinformation(PaymentApproved paymentApproved){

        /** Example 1:  new item 
        Ordermanagement ordermanagement = new Ordermanagement();
        repository().save(ordermanagement);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentApproved.get???()).ifPresent(ordermanagement->{
            
            ordermanagement // do something
            repository().save(ordermanagement);


         });
        */

        
    }
    public static void cancelOrder(PaymentCancelled paymentCancelled){

        /** Example 1:  new item 
        Ordermanagement ordermanagement = new Ordermanagement();
        repository().save(ordermanagement);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentCancelled.get???()).ifPresent(ordermanagement->{
            
            ordermanagement // do something
            repository().save(ordermanagement);


         });
        */

        
    }


}
