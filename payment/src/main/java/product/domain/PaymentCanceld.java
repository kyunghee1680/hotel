package product.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import product.domain.*;
import product.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentCanceld extends AbstractEvent {

    private Long id;
    private String reservationId;
    private Integer price;
    private String hotelName;
    private Date payDt;
    private String status;

    public PaymentCanceld(Payment aggregate) {
        super(aggregate);
    }

    public PaymentCanceld() {
        super();
    }
}
//>>> DDD / Domain Event
