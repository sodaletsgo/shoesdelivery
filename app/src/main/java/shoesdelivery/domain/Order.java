package shoesdelivery.domain;

import shoesdelivery.domain.Ordered;
import shoesdelivery.domain.OrderCancelled;
import shoesdelivery.AppApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String item;
    
    
    
    
    
    private String colorCode;
    
    
    
    
    
    private String size;
    
    
    
    
    
    private Integer quantity;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        shoesdelivery.external.PaymentHistory paymentHistory = new shoesdelivery.external.PaymentHistory();
        // mappings goes here
        AppApplication.applicationContext.getBean(shoesdelivery.external.PaymentHistoryService.class)
            .pay(paymentHistory);


        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();



        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = AppApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void changeOrderstatus(ShippingStarted shippingStarted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(shippingStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
