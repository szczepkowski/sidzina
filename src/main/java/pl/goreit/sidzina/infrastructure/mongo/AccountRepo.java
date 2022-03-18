package pl.goreit.sidzina.infrastructure.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.goreit.sidzina.domain.model.Account;

@Repository
public interface AccountRepo extends MongoRepository<Account, String > {

}
