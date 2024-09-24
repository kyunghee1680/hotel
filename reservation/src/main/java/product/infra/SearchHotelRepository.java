package product.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import product.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "searchHotels",
    path = "searchHotels"
)
public interface SearchHotelRepository
    extends PagingAndSortingRepository<SearchHotel, Long> {}
