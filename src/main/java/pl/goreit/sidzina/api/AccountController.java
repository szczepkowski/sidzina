package pl.goreit.sidzina.api;

import io.swagger.annotations.ApiOperation;
import net.bytebuddy.asm.Advice;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.goreit.api.generated.account.CreateCompanyAccountRequest;
import pl.goreit.sidzina.domain.DomainException;
import pl.goreit.sidzina.domain.ExceptionCode;
import pl.goreit.sidzina.domain.model.Account;
import pl.goreit.sidzina.domain.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PostMapping
    @ApiOperation(value = "dodaje 1 konto", notes = "dodaje konto")
    public Account addAccount(@RequestBody CreateCompanyAccountRequest request) {
        return null;
    }

    @GetMapping
    @ApiOperation(value = "pobiera 1 konto", notes = "pobiera konto")
    public Account getAccount(@PathVariable String login) throws DomainException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof KeycloakPrincipal) {
            KeycloakPrincipal principal = (KeycloakPrincipal) authentication.getPrincipal();
            String loginSecured = principal.getName();
            return accountService.get(loginSecured);
        }

        throw new DomainException(ExceptionCode.ONLY_KEYCLOAK);
    }
}
