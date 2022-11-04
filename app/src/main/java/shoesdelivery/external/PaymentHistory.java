package shoesdelivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class PaymentHistory {

    private Long id;
    private String orderId;
    private String amount;
}


