package shoesdelivery.domain;

import shoesdelivery.domain.*;
import shoesdelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PaymentApproved extends AbstractEvent {

    private Long id;
    private String orderId;
    private Long price;
    private String kakaopayId;
    private Date createDate;

    public PaymentApproved(PaymentHistory aggregate){
        super(aggregate);
    }
    public PaymentApproved(){
        super();
    }
}
