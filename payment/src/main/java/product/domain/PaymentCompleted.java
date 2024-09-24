package product.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import product.domain.*;
import product.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentCompleted extends AbstractEvent {

    private Long id;
    private String reservationId;
    private String status;
    private Integer price;
    private String hotelName;
    private Date payDt;

    public PaymentCompleted(Payment aggregate) {
        super(aggregate);
    }

    public PaymentCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
