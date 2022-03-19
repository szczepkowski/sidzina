package pl.goreit.sidzina.domain.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.goreit.api.generated.account.CompanyView;
import pl.goreit.sidzina.domain.model.Company;

@Component
public class CompanyViewToModelConverter implements Converter<CompanyView, Company> {

    @Override
    public Company convert(CompanyView view) {
        return new Company(view.getNip(), view.getName());
    }
}
