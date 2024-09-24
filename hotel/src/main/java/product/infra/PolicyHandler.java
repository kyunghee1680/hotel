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
    HotelRepository hotelRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='HotelReservationCanceled'"
    )
    public void wheneverHotelReservationCanceled_IncreaseRoom(
        @Payload HotelReservationCanceled hotelReservationCanceled
    ) {
        HotelReservationCanceled event = hotelReservationCanceled;
        System.out.println(
            "\n\n##### listener IncreaseRoom : " +
            hotelReservationCanceled +
            "\n\n"
        );

        // Sample Logic //
        Hotel.increaseRoom(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='HotelReservationCompleted'"
    )
    public void wheneverHotelReservationCompleted_DecreaseRoom(
        @Payload HotelReservationCompleted hotelReservationCompleted
    ) {
        HotelReservationCompleted event = hotelReservationCompleted;
        System.out.println(
            "\n\n##### listener DecreaseRoom : " +
            hotelReservationCompleted +
            "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
