package pl.goreit.sidzina.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import pl.goreit.api.generated.offers.OfferView;
import pl.goreit.sidzina.domain.DomainException;
import pl.goreit.sidzina.domain.ExceptionCode;
import pl.goreit.sidzina.domain.converter.OfferModelToViewConverter;
import pl.goreit.sidzina.domain.converter.OfferViewToModelConverter;
import pl.goreit.sidzina.domain.model.Auction;
import pl.goreit.sidzina.domain.model.Offer;
import pl.goreit.sidzina.infrastructure.mongo.OfferRepo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private static final Logger LOGGER = Logger.getLogger(OfferService.class.getName());

    @Autowired
    private OfferModelToViewConverter converter;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private OfferRepo offerRepo;

    public List<OfferView> findAll() {
        return offerRepo.findAll().stream().map(offer -> converter.convert(offer)).collect(Collectors.toList());
    }

    public OfferView findByTitle(String title) throws DomainException {
        Optional<Offer> offerOptional = offerRepo.findByTitle(title);
        Offer offer = offerOptional.orElseThrow(() -> new DomainException(ExceptionCode.OFFER_NOT_EXIST));
        return conversionService.convert(offer, OfferView.class);

    }

    public OfferView add(OfferView offerView) {
        Offer offer = conversionService.convert(offerView, Offer.class);
        int random = ThreadLocalRandom.current().nextInt(0, 1000);
        String title = offerView.getTitle() + "_" + random;
        Objects.requireNonNull(offer).setTitle(title);

        Offer saved = offerRepo.save(Objects.requireNonNull(offer));
        LOGGER.info("correctly added offer" + saved);
        return offerView;
    }
}
