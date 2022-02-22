package pl.goreit.sidzina.domain.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.goreit.api.generated.message.MessageView;
import pl.goreit.sidzina.domain.model.Message;

@Component
public class MessagetoMessageViewConverter implements Converter<Message, MessageView> {

    @Override
    public MessageView convert(Message message) {
        return new MessageView()
                .withTitle(message.getTitle())
                .withBody(message.getBody())
                .withEmail(message.getEmail());
    }
}
