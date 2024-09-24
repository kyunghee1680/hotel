package product.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import product.ReservationApplication;
import product.domain.HotelReservationCanceled;
import product.domain.HotelReservationCanceledRequested;
import product.domain.HotelReservationCompleted;
import product.domain.HotelReservationFailed;
import product.domain.HotelReservationRefunded;
import product.domain.HotelReservationRequested;

@Entity
@Table(name = "HotelReservation_table")
@Data
//<<< DDD / Aggregate Root
public class HotelReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String reservationId;

    private String userId;

    private String status;

    private Integer roomCount;

    private Date startDate;

    private Date endDate;

    private Integer price;

    private String hotelName;

    private String address;

    private Integer roomNumber;

    @PostPersist
    public void onPostPersist() {
        HotelReservationRequested hotelReservationRequested = new HotelReservationRequested(
            this
        );
        hotelReservationRequested.publishAfterCommit();

        HotelReservationCanceledRequested hotelReservationCanceledRequested = new HotelReservationCanceledRequested(
            this
        );
        hotelReservationCanceledRequested.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        HotelReservationCompleted hotelReservationCompleted = new HotelReservationCompleted(
            this
        );
        hotelReservationCompleted.publishAfterCommit();

        HotelReservationCanceled hotelReservationCanceled = new HotelReservationCanceled(
            this
        );
        hotelReservationCanceled.publishAfterCommit();

        HotelReservationRefunded hotelReservationRefunded = new HotelReservationRefunded(
            this
        );
        hotelReservationRefunded.publishAfterCommit();

        HotelReservationFailed hotelReservationFailed = new HotelReservationFailed(
            this
        );
        hotelReservationFailed.publishAfterCommit();
    }

    public static HotelReservationRepository repository() {
        HotelReservationRepository hotelReservationRepository = ReservationApplication.applicationContext.getBean(
            HotelReservationRepository.class
        );
        return hotelReservationRepository;
    }

    public void requestHotelReservation() {
        //implement business logic here:

        HotelReservationRequested hotelReservationRequested = new HotelReservationRequested(
            this
        );
        hotelReservationRequested.publishAfterCommit();
    }

    public void requestCancelHotelReservation() {
        //implement business logic here:

        HotelReservationCanceledRequested hotelReservationCanceledRequested = new HotelReservationCanceledRequested(
            this
        );
        hotelReservationCanceledRequested.publishAfterCommit();
    }
}
//>>> DDD / Aggregate Root
