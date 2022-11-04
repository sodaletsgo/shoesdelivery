package shoesdelivery.domain;

import shoesdelivery.domain.PaymentApproved;
import shoesdelivery.domain.PaymentCancelled;
import shoesdelivery.PayApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="PaymentHistory_table")
@Data

public class PaymentHistory  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String amount;

    @PostPersist
    public void onPostPersist(){


        PaymentApproved paymentApproved = new PaymentApproved(this);
        paymentApproved.publishAfterCommit();



        PaymentCancelled paymentCancelled = new PaymentCancelled(this);
        paymentCancelled.publishAfterCommit();

    }

    public static PaymentHistoryRepository repository(){
        PaymentHistoryRepository paymentHistoryRepository = PayApplication.applicationContext.getBean(PaymentHistoryRepository.class);
        return paymentHistoryRepository;
    }




    public static void cancelApproval(OrderCancelled orderCancelled){

        /** Example 1:  new item 
        PaymentHistory paymentHistory = new PaymentHistory();
        repository().save(paymentHistory);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(paymentHistory->{
            
            paymentHistory // do something
            repository().save(paymentHistory);


         });
        */

        
    }


}
