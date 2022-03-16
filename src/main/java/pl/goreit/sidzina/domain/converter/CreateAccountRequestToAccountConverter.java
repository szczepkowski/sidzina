package pl.goreit.sidzina.domain.converter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.goreit.api.generated.account.CreateCompanyAccountRequest;
import pl.goreit.sidzina.domain.model.Account;
import pl.goreit.sidzina.domain.model.Address;
import pl.goreit.sidzina.domain.model.Company;
import pl.goreit.sidzina.domain.model.Person;

import java.util.UUID;

@Component
public class CreateAccountRequestToAccountConverter implements Converter<CreateCompanyAccountRequest, Account> {

    private final ConversionService conversionService;
    @Value("${pricing.default.balance}")
    private String defaultBalance;

    @Value("${pricing.default.coins}")
    private String defaultCoins;

    @Lazy
    public CreateAccountRequestToAccountConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Account convert(CreateCompanyAccountRequest request) {

        Person person = conversionService.convert(request.getPerson(), Person.class);
        Address address = conversionService.convert(request.getAddress(), Address.class);
        Company company = conversionService.convert(request.getCompany(), Company.class);

        return new Account(UUID.randomUUID().toString(), person, address, company);
    }
}
