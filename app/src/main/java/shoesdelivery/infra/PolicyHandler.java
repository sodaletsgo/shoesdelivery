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
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ShippingStarted'")
    public void wheneverShippingStarted_ChangeOrderstatus(@Payload ShippingStarted shippingStarted){

        ShippingStarted event = shippingStarted;
        System.out.println("\n\n##### listener ChangeOrderstatus : " + shippingStarted + "\n\n");


        

        // Sample Logic //
        Order.changeOrderstatus(event);
        

        

    }

}


