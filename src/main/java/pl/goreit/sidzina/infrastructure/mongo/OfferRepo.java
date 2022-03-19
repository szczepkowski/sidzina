package pl.goreit.sidzina.infrastructure.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import pl.goreit.sidzina.domain.model.Auction;
import pl.goreit.sidzina.domain.model.Offer;

import java.util.Optional;

@Repository
public interface OfferRepo extends MongoRepository<Offer, String> {

    Optional<Offer> findByTitle(String title);

    @Query("{'title':{'$regex':'?0','$options':'i'}}")
    Page<Auction> findByTitle(String title, Pageable page);
}
