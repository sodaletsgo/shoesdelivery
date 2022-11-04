package shoesdelivery.domain;

import shoesdelivery.domain.*;
import shoesdelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PaymentCancelled extends AbstractEvent {

    private Long id;
    private String orderId;
    private Long price;
    private Long kakaopayId;
    private Date createDate;

    public PaymentCancelled(PaymentHistory aggregate){
        super(aggregate);
    }
    public PaymentCancelled(){
        super();
    }
}
