package product.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "MyReservationInfo_table")
@Data
public class MyReservationInfo {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Integer roomNumber;
    private String reservationId;
    private String reservationStatus;
    private Date startDate;
    private Date endDate;
    private Integer price;
    private String paymentStatus;
    private String hotelName;
    private String address;
}
