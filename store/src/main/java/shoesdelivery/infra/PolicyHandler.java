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
    @Autowired OrdermanagementRepository ordermanagementRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PaymentApproved'")
    public void wheneverPaymentApproved_ReceiveOrderinformation(@Payload PaymentApproved paymentApproved){

        PaymentApproved event = paymentApproved;
        System.out.println("\n\n##### listener ReceiveOrderinformation : " + paymentApproved + "\n\n");


        

        // Sample Logic //
        Ordermanagement.receiveOrderinformation(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PaymentCancelled'")
    public void wheneverPaymentCancelled_CancelOrder(@Payload PaymentCancelled paymentCancelled){

        PaymentCancelled event = paymentCancelled;
        System.out.println("\n\n##### listener CancelOrder : " + paymentCancelled + "\n\n");


        

        // Sample Logic //
        Ordermanagement.cancelOrder(event);
        

        

    }

}


