package pl.goreit.sidzina.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.goreit.api.generated.offers.OfferView;
import pl.goreit.sidzina.domain.converter.OfferModelToViewConverter;
import pl.goreit.sidzina.domain.converter.OfferViewToModelConverter;
import pl.goreit.sidzina.domain.model.Offer;
import pl.goreit.sidzina.infrastructure.mongo.OfferRepo;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private static final Logger LOGGER = Logger.getLogger(OfferService.class.getName());

    @Autowired
    private OfferModelToViewConverter converter;

    @Autowired
    private OfferViewToModelConverter viewToModelConverter;

    @Autowired
    private OfferRepo offerRepo;

    public List<OfferView> findAll() {
        return offerRepo.findAll().stream().map(offer -> converter.convert(offer)).collect(Collectors.toList());
    }

    public OfferView add(OfferView offerView) {
        Offer offer = viewToModelConverter.convert(offerView);
        Offer saved = offerRepo.save(Objects.requireNonNull(offer));
        LOGGER.info("correctly added offer" + saved);
        return offerView;
    }
}
