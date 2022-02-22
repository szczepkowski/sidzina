package pl.goreit.sidzina.domain.service;

import pl.goreit.api.generated.account.CreateAccountRequest;
import pl.goreit.sidzina.domain.model.Account;

public interface AccountService {

    Account findByUserId(String userId);

    Account add(CreateAccountRequest request);

    Account save(Account account);
}
