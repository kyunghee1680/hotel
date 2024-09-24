package product.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import product.domain.*;
import product.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentFailed extends AbstractEvent {

    private Long id;
    private String reservationId;
    private Integer price;
    private String hotelName;
    private Date payDt;
    private String status;

    public PaymentFailed(Payment aggregate) {
        super(aggregate);
    }

    public PaymentFailed() {
        super();
    }
}
//>>> DDD / Domain Event
