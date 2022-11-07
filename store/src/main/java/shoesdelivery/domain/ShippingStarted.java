package shoesdelivery.domain;

import shoesdelivery.domain.*;
import shoesdelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ShippingStarted extends AbstractEvent {

    private Long id;
    private String productName;
    private String deliveryAddress;
    //private String orderId;
    private Long orderId;
    private Long phoneNumber;
    private String deliveryDate;

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

    public String getDeliveryDate(){
        return deliveryDate;
    }
    public void setDeliveryDate(String deliveryDate){
        this.deliveryDate=deliveryDate;
    }    

    public ShippingStarted(Ordermanagement aggregate){
        super(aggregate);
    }
    public ShippingStarted(){
        super();
    }
}
