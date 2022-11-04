package shoesdelivery.domain;

import shoesdelivery.domain.*;
import shoesdelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class PaymentCancelled extends AbstractEvent {

    private Long id;
    private String orderId;
    private Long price;
    private Long kakaopayId;
    private Date createDate;
}


