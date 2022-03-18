package pl.goreit.sidzina.api;

import io.swagger.annotations.ApiOperation;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.goreit.api.generated.account.CreateCompanyAccountRequest;
import pl.goreit.sidzina.domain.model.Account;
import pl.goreit.sidzina.domain.service.AccountService  ;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PostMapping
    @ApiOperation(value = "dodaje 1 konto", notes = "dodaje konto")
    public Account addAccount(@RequestBody CreateCompanyAccountRequest request) {
        return accountService.add(request);
    }


}
