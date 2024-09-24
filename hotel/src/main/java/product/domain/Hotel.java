package product.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import product.HotelApplication;

@Entity
@Table(name = "Hotel_table")
@Data
//<<< DDD / Aggregate Root
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer roomCount;

    private String hotelName;

    private String status;

    public static HotelRepository repository() {
        HotelRepository hotelRepository = HotelApplication.applicationContext.getBean(
            HotelRepository.class
        );
        return hotelRepository;
    }

    //<<< Clean Arch / Port Method
    public static void increaseRoom(
        HotelReservationCanceled hotelReservationCanceled
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Hotel hotel = new Hotel();
        repository().save(hotel);

        */

        /** Example 2:  finding and process
        
        repository().findById(hotelReservationCanceled.get???()).ifPresent(hotel->{
            
            hotel // do something
            repository().save(hotel);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
