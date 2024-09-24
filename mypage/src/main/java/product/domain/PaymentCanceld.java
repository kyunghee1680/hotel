package product.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import product.infra.AbstractEvent;

@Data
public class PaymentCanceld extends AbstractEvent {

    private Long id;
    private String reservationId;
    private Integer price;
    private String hotelName;
    private Date payDt;
    private String status;
}
