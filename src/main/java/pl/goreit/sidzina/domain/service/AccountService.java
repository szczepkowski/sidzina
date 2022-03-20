package pl.goreit.sidzina.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import pl.goreit.sidzina.domain.model.Account;
import pl.goreit.sidzina.infrastructure.mongo.AccountRepo;
import pl.goreit.sidzina.infrastructure.mongo.AuctionRepo;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private AuctionRepo productRepo;

    @Autowired
    private ConversionService conversionService;



    public Account save(Account account) {
        return this.accountRepo.save(account);
    }
}
