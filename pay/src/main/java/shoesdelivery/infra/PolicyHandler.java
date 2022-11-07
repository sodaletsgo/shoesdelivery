package shoesdelivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import shoesdelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import shoesdelivery.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired PaymentHistoryRepository paymentHistoryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCancelled'")
    public void wheneverOrderCancelled_CancelApproval(@Payload OrderCancelled orderCancelled){

        if (orderCancelled.isMe()){
            OrderCancelled event = orderCancelled;
            System.out.println("\n\n##### listener CancelApproval : " + orderCancelled + "\n\n");

            PaymentHistory paymentHistory = new PaymentHistory();
            paymentHistory.setStatus("취소");
            paymentHistoryRepository.save(paymentHistory);

            // Sample Logic //
            //PaymentHistory.cancelApproval(event);
        }

        

    }

}


