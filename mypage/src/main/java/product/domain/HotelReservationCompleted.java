package product.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import product.infra.AbstractEvent;

@Data
public class HotelReservationCompleted extends AbstractEvent {

    private Long id;
    private String reservationId;
    private String userId;
    private Date startDate;
    private Date endDate;
    private Integer price;
    private String status;
    private Integer roomCount;
    private String hotelName;
    private String address;
    private Integer roomNumber;
}
