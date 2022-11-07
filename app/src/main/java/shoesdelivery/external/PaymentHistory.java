package shoesdelivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class PaymentHistory {

    private Long id;
    //private String orderId;
    private Long orderId;
    //private String amount;
    private Double amount;

    //private Long id;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    //private String orderId;
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

    //private String amount;
    public Double getAmount(){
        return amount;
    }
    public void setAmount(Double amount){
        this.amount=amount;
    }    
}


