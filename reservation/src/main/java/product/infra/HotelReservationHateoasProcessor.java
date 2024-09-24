package product.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import product.domain.*;

@Component
public class HotelReservationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<HotelReservation>> {

    @Override
    public EntityModel<HotelReservation> process(
        EntityModel<HotelReservation> model
    ) {
        return model;
    }
}
