package product.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import product.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "myReservationInfos",
    path = "myReservationInfos"
)
public interface MyReservationInfoRepository
    extends PagingAndSortingRepository<MyReservationInfo, Long> {
    List<MyReservationInfo> findByReservationId(String reservationId);
}
