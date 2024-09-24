package product.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import product.PaymentApplication;
import product.domain.PaymentCanceld;
import product.domain.PaymentCompleted;
import product.domain.PaymentFailed;
import product.domain.PaymentRefunded;

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String reservationId;

    private String status;

    private Integer price;

    private String hotelName;

    private Date payDt;

    @PostPersist
    public void onPostPersist() {}

    @PostUpdate
    public void onPostUpdate() {
        PaymentCompleted paymentCompleted = new PaymentCompleted(this);
        paymentCompleted.publishAfterCommit();

        PaymentCanceld paymentCanceld = new PaymentCanceld(this);
        paymentCanceld.publishAfterCommit();

        PaymentRefunded paymentRefunded = new PaymentRefunded(this);
        paymentRefunded.publishAfterCommit();

        PaymentFailed paymentFailed = new PaymentFailed(this);
        paymentFailed.publishAfterCommit();
    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    public void requestPayment() {
        //implement business logic here:

    }

    public void cancelPayment() {
        //implement business logic here:

    }

    public void requestRefundPayment() {
        //implement business logic here:

    }

    public void failPayment() {
        //implement business logic here:

    }

    //<<< Clean Arch / Port Method
    public static void startPayment(
        HotelReservationRequested hotelReservationRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(hotelReservationRequested.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelPayment(
        HotelReservationCanceledRequested hotelReservationCanceledRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(hotelReservationCanceledRequested.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
