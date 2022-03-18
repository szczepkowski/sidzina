package pl.goreit.sidzina.domain.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.goreit.api.generated.account.AddressView;
import pl.goreit.sidzina.domain.model.Address;

@Component
public class AddressViewToModelConverter implements Converter<AddressView, Address> {

    @Override
    public Address convert(AddressView view) {
        return new Address(view.getStreet(),
                view.getStreetNumber(),
                view.getApartmentNumber(),
                view.getPostCode(),
                view.getCity(),
                view.getCountry());
    }
}
