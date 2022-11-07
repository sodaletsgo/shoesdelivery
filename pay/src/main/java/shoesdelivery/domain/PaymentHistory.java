package shoesdelivery.domain;

import shoesdelivery.domain.PaymentApproved;
import shoesdelivery.domain.PaymentCancelled;
import shoesdelivery.PayApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Entity
@Table(name="PaymentHistory_table")
@Data

public class PaymentHistory  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    //private String orderId;
    private Long orderId;
    private String amount;
    private String status;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

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

    public String getAmount(){
        return amount;
    }
    public void setAmount(String amount){
        this.amount=amount;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }

    /*
    @PrePersist
    public void onPrePersist(){
        PaymentApproved paymentApproved = new PaymentApproved();
        BeanUtils.copyProperties(this, paymentApproved);
        paymentApproved.publish();
    }
    */

    @PrePersist
    public void onPrePersist(){

        if("취소".equals(this.status)){
            PaymentCancelled paymentCancelled = new PaymentCancelled();
            BeanUtils.copyProperties(this, paymentCancelled);
            paymentCancelled.publish();

        }else{
            PaymentApproved paymentApproved = new PaymentApproved();
            BeanUtils.copyProperties(this, paymentApproved);

            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void beforeCommit(boolean readOnly) {
                    paymentApproved.publish();
                }
            });

            try {
                Thread.currentThread().sleep((long) (400 + Math.random() * 220));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    @PostPersist
    public void onPostPersist(){
        PaymentApproved paymentApproved = new PaymentApproved(this);
        paymentApproved.publishAfterCommit();
        PaymentCancelled paymentCancelled = new PaymentCancelled(this);
        paymentCancelled.publishAfterCommit();
    }
    */

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