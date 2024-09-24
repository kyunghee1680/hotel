package product.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import product.config.kafka.KafkaProcessor;
import product.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='HotelReservationRequested'"
    )
    public void wheneverHotelReservationRequested_StartPayment(
        @Payload HotelReservationRequested hotelReservationRequested
    ) {
        HotelReservationRequested event = hotelReservationRequested;
        System.out.println(
            "\n\n##### listener StartPayment : " +
            hotelReservationRequested +
            "\n\n"
        );

        // Sample Logic //
        Payment.startPayment(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='HotelReservationCanceledRequested'"
    )
    public void wheneverHotelReservationCanceledRequested_CancelPayment(
        @Payload HotelReservationCanceledRequested hotelReservationCanceledRequested
    ) {
        HotelReservationCanceledRequested event =
            hotelReservationCanceledRequested;
        System.out.println(
            "\n\n##### listener CancelPayment : " +
            hotelReservationCanceledRequested +
            "\n\n"
        );

        // Sample Logic //
        Payment.cancelPayment(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
