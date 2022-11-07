package shoesdelivery.domain;

import shoesdelivery.domain.*;
import shoesdelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
import javax.persistence.PrePersist;

@Data
@ToString
public class PaymentApproved extends AbstractEvent {

    private Long id;
    private String orderId;
    private Long price;
    private String kakaopayId;
    private Date createDate;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getOrderId(){
        return orderId;
    }
    public void setOrderId(String orderId){
        this.orderId=orderId;
    }

    public Long getPrice(){
        return price;
    }
    public void setPrice(Long price){
        this.price=price;
    }

    public String getKakaopayId(){
        return kakaopayId;
    }
    public void setKakaopayId(String kakaopayId){
        this.kakaopayId=kakaopayId;
    }

    public Date getCreateDate(){
        return createDate;
    }
    public void setCreateDate(Date createDate){
        this.createDate=createDate;
    }   

    @PrePersist
    public void delay(){
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }     
}


