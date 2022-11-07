package shoesdelivery.domain;

import shoesdelivery.domain.*;
import shoesdelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PaymentCancelled extends AbstractEvent {

    private Long id;
    //private String orderId;
    private Long orderId;
    private Long price;
    private Long kakaopayId;
    private Date createDate;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
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

    public Long getPrice(){
        return price;
    }
    public void setPrice(Long price){
        this.price=price;
    }

    public Long getKakaopayId(){
        return kakaopayId;
    }
    public void setKakaopayId(Long kakaopayId){
        this.kakaopayId=kakaopayId;
    }

    public Date getCreateDate(){
        return createDate;
    }
    public void setCreateDate(Date createDate){
        this.createDate=createDate;
    }

    public PaymentCancelled(PaymentHistory aggregate){
        super(aggregate);
    }
    public PaymentCancelled(){
        super();
    }
}
