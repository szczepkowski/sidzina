package pl.goreit.sidzina.domain.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.goreit.api.generated.account.PersonView;
import pl.goreit.sidzina.domain.model.Person;

import java.util.UUID;

@Component
public class PersonViewToModelConverter implements Converter<PersonView, Person> {

    @Override
    public Person convert(PersonView personView) {
        return new Person(personView.getFirstName(),
                personView.getLastName(),
                personView.getPesel());
    }
}
