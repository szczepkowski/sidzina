package pl.goreit.sidzina.domain.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.goreit.api.generated.offers.OfferView;
import pl.goreit.sidzina.domain.model.Offer;

@Component
public class OfferModelToViewConverter implements Converter<Offer, OfferView> {

    @Override
    public OfferView convert(Offer offer) {
        return new OfferView(offer.getTitle(), offer.getSellerId(), offer.getDescription(), offer.getPrice());
    }
}
