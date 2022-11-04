package shoesdelivery.domain;

import shoesdelivery.domain.*;
import shoesdelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class PaymentApproved extends AbstractEvent {

    private Long id;
    private String orderId;
    private Long price;
    private String kakaopayId;
    private Date createDate;
}


