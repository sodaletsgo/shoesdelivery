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
    private String orderId;
    private Long phoneNumber;
    private String deliveryDate;

    public ShippingStarted(Ordermanagement aggregate){
        super(aggregate);
    }
    public ShippingStarted(){
        super();
    }
}
