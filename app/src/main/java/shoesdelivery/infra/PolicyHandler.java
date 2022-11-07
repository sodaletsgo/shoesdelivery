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
        System.out.println("생성됨?");
        if(shippingStarted.isMe() && shippingStarted.getOrderId() != null){
            System.out.println("응!");

            if(shippingStarted.getOrderId() != null){

                ShippingStarted event = shippingStarted;
                System.out.println("\n\n##### listener ChangeOrderstatus : " + shippingStarted + "\n\n");

                orderRepository.findById(Long.valueOf(shippingStarted.getOrderId())).ifPresent((order)->{
                    order.setStatus("배달시작됨");
                    orderRepository.save(order);
                });

                // Sample Logic //
                //Order.changeOrderstatus(event);
                
            }

        }else{
            System.out.println("아니!");
        }

    }

}


