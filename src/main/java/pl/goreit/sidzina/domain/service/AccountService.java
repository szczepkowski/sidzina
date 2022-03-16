package pl.goreit.sidzina.domain.service;

import pl.goreit.api.generated.account.CreateCompanyAccountRequest;
import pl.goreit.sidzina.domain.model.Account;

public interface AccountService {

    Account add(CreateCompanyAccountRequest request);

    Account save(Account account);
}
