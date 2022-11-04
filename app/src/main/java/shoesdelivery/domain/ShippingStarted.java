package shoesdelivery.domain;

import shoesdelivery.domain.*;
import shoesdelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class ShippingStarted extends AbstractEvent {

    private Long id;
    private String productName;
    private String deliveryAddress;
    private String orderId;
    private Long phoneNumber;
    private String deliveryDate;
}


