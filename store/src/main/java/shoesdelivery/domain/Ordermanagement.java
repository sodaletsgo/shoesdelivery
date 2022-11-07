package shoesdelivery.domain;

import shoesdelivery.domain.ShippingStarted;
import shoesdelivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name="Ordermanagement_table")
@Data

public class Ordermanagement  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private Long id;
    private String productName;
    private String deliveryAddress;
    //private String orderId;
    private Long orderId;
    private Long phoneNumber;
    private Date deliveryDate;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getProductName(){
        return productName;
    }
    public void setProductName(String productName){
        this.productName=productName;
    }

    public String getDeliveryAddress(){
        return deliveryAddress;
    }
    public void setDeliveryAddress(String deliveryAddress){
        this.deliveryAddress=deliveryAddress;
    }
    /*
    public String getOrderId(){
        return orderId;
    }
    public void setOrderId(String orderId){
        this.orderId=orderId;
    }
    */

    public Long getOrderId(){
        return orderId;
    }
    public void setOrderId(Long orderId){
        this.orderId=orderId;
    }

    public Long getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(Long phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public Date getDeliveryDate(){
        return deliveryDate;
    }
    public void setDeliveryDate(Date deliveryDate){
        this.deliveryDate=deliveryDate;
    }

    @PostPersist
    public void onPostPersist(){
        ShippingStarted shippingStarted = new ShippingStarted(this);
        //shippingStarted.publishAfterCommit();
        shippingStarted.setOrderId(Long.valueOf(getOrderId()));
        BeanUtils.copyProperties(this, shippingStarted);
        shippingStarted.publish();
    }

    @PrePersist
    public void onPrePersist(){
        //쿠폰 발행 쪽
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
