package product.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import product.domain.*;
import product.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class HotelReservationCanceled extends AbstractEvent {

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

    public HotelReservationCanceled(HotelReservation aggregate) {
        super(aggregate);
    }

    public HotelReservationCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
