package product.domain;

import java.util.*;
import lombok.*;
import product.domain.*;
import product.infra.AbstractEvent;

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
}
