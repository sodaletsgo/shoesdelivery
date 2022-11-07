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
    private Long price;
    private String status;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getItem(){
        return item;
    }

    public void setItem(String item){
        this.item=item;
    }

    public String getColorCode(){
        return colorCode;
    }
    public void setColorCode(String colorCode){
        this.colorCode=colorCode;
    }

    public String getSize(){
        return size;
    }
    public void setSize(String size){
        this.size=size;
    }

    public Integer getQuantity(){
        return quantity;
    }
    public void setQuantity(Integer quantity){
        this.quantity=quantity;
    }

    public Long getPrice(){
        return price;
    }
    public void setPrice(Long price){
        this.price=price;
    }    

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }


    @PostPersist
    public void onPostPersist(){
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.
        shoesdelivery.external.PaymentHistory paymentHistory = new shoesdelivery.external.PaymentHistory();

        paymentHistory.setOrderId(Long.valueOf(getId()));
        if(getPrice() != null){
            paymentHistory.setAmount(Double.valueOf(getPrice()));
        }
        // mappings goes here
        AppApplication.applicationContext.getBean(shoesdelivery.external.PaymentHistoryService.class).pay(paymentHistory);

        /*
        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();

        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();
        */
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
