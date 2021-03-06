package pl.goreit.sidzina.domain.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.goreit.api.generated.auction_api.CommentView;
import pl.goreit.sidzina.domain.model.Comment;

@Component
public class CommentConverter implements Converter<Comment, CommentView> {

    @Override
    public CommentView convert(Comment comment) {
        return new CommentView(comment.getUserId(), comment.getText());

    }
}
