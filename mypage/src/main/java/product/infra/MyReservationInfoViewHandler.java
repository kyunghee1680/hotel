package product.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import product.config.kafka.KafkaProcessor;
import product.domain.*;

@Service
public class MyReservationInfoViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MyReservationInfoRepository myReservationInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenHotelReservationCompleted_then_CREATE_1(
        @Payload HotelReservationCompleted hotelReservationCompleted
    ) {
        try {
            if (!hotelReservationCompleted.validate()) return;

            // view 객체 생성
            MyReservationInfo myReservationInfo = new MyReservationInfo();
            // view 객체에 이벤트의 Value 를 set 함
            myReservationInfo.setReservationId(
                hotelReservationCompleted.getReservationId()
            );
            myReservationInfo.setRoomNumber(
                hotelReservationCompleted.getRoomNumber()
            );
            myReservationInfo.setReservationStatus(
                String.valueOf(hotelReservationCompleted.getStatus())
            );
            myReservationInfo.setStartDate(
                hotelReservationCompleted.getStartDate()
            );
            myReservationInfo.setEndDate(
                hotelReservationCompleted.getEndDate()
            );
            myReservationInfo.setPrice(hotelReservationCompleted.getPrice());
            myReservationInfo.setHotelName(
                hotelReservationCompleted.getHotelName()
            );
            myReservationInfo.setAddress(
                hotelReservationCompleted.getAddress()
            );
            // view 레파지 토리에 save
            myReservationInfoRepository.save(myReservationInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenHotelReservationCompleted_then_UPDATE_1(
        @Payload HotelReservationCompleted hotelReservationCompleted
    ) {
        try {
            if (!hotelReservationCompleted.validate()) return;
            // view 객체 조회

            List<MyReservationInfo> myReservationInfoList = myReservationInfoRepository.findByReservationId(
                hotelReservationCompleted.getReservationId()
            );
            for (MyReservationInfo myReservationInfo : myReservationInfoList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myReservationInfo.setReservationStatus(
                    String.valueOf(hotelReservationCompleted.getStatus())
                );
                // view 레파지 토리에 save
                myReservationInfoRepository.save(myReservationInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCompleted_then_UPDATE_2(
        @Payload PaymentCompleted paymentCompleted
    ) {
        try {
            if (!paymentCompleted.validate()) return;
            // view 객체 조회

            List<MyReservationInfo> myReservationInfoList = myReservationInfoRepository.findByReservationId(
                paymentCompleted.getReservationId()
            );
            for (MyReservationInfo myReservationInfo : myReservationInfoList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myReservationInfo.setPaymentStatus(
                    paymentCompleted.getStatus()
                );
                // view 레파지 토리에 save
                myReservationInfoRepository.save(myReservationInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenHotelReservationCanceled_then_UPDATE_3(
        @Payload HotelReservationCanceled hotelReservationCanceled
    ) {
        try {
            if (!hotelReservationCanceled.validate()) return;
            // view 객체 조회

            List<MyReservationInfo> myReservationInfoList = myReservationInfoRepository.findByReservationId(
                hotelReservationCanceled.getReservationId()
            );
            for (MyReservationInfo myReservationInfo : myReservationInfoList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myReservationInfo.setReservationStatus(
                    String.valueOf(hotelReservationCanceled.getStatus())
                );
                // view 레파지 토리에 save
                myReservationInfoRepository.save(myReservationInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCanceld_then_UPDATE_4(
        @Payload PaymentCanceld paymentCanceld
    ) {
        try {
            if (!paymentCanceld.validate()) return;
            // view 객체 조회

            List<MyReservationInfo> myReservationInfoList = myReservationInfoRepository.findByReservationId(
                paymentCanceld.getReservationId()
            );
            for (MyReservationInfo myReservationInfo : myReservationInfoList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myReservationInfo.setPaymentStatus(
                    String.valueOf(paymentCanceld.getStatus())
                );
                // view 레파지 토리에 save
                myReservationInfoRepository.save(myReservationInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
