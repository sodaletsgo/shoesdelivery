package shoesdelivery.domain;

import shoesdelivery.domain.*;
import shoesdelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String status;
}


