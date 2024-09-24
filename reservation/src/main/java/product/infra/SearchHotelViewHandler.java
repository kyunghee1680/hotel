package product.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import product.config.kafka.KafkaProcessor;
import product.domain.*;

@Service
public class SearchHotelViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private SearchHotelRepository searchHotelRepository;
    //>>> DDD / CQRS
}
