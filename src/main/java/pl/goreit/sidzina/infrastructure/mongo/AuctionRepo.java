package pl.goreit.sidzina.infrastructure.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import pl.goreit.sidzina.domain.model.Auction;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuctionRepo extends MongoRepository<Auction, String> {

    Optional<Auction> findByTitle(String title);

    @Query("{'title':{'$regex':'?0','$options':'i'}}")
    Page<Auction> findByTitle(String title, Pageable page);

    List<Auction> findByTitleIn(List<String> strings);
}
