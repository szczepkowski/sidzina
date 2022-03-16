package pl.goreit.sidzina.domain.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.goreit.api.generated.offers.OfferView;
import pl.goreit.sidzina.domain.model.Offer;

import java.util.UUID;

@Component
public class OfferViewToModelConverter implements Converter<OfferView, Offer> {

    @Override
    public Offer convert(OfferView offerView) {
        return new Offer(UUID.randomUUID().toString(), offerView.getTitle(), offerView.getDescription(), offerView.getPrice());
    }
}
