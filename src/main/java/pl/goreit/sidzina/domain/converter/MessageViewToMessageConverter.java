package pl.goreit.sidzina.domain.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.goreit.api.generated.message.MessageView;
import pl.goreit.sidzina.domain.model.Message;

@Component
public class MessageViewToMessageConverter implements Converter<MessageView, Message> {

    @Override
    public Message convert(MessageView view) {
        return new Message(view.getEmail(), view.getTitle(), view.getBody());
    }
}
