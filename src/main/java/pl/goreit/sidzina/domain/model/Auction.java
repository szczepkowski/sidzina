package pl.goreit.sidzina.domain.model;

import com.google.common.collect.Lists;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.goreit.sidzina.domain.DomainException;
import pl.goreit.sidzina.domain.ExceptionCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document
public class Auction {

    @Id
    private String id;
    private String sellerId;

    private String title;
    private String description;
    private BigDecimal price;

    private List<Comment> comments;
    private Status status;

    private LocalDateTime creationDate;

    public Auction(String id, String title, String description, BigDecimal price, String sellerId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.sellerId = sellerId;

        this.status = Status.ACTIVE;
        this.creationDate = LocalDateTime.now();
        this.comments = Lists.newArrayList();
    }

    public boolean addComment(Comment comment) throws DomainException {
        if (Status.ACTIVE != getStatus()) {
            throw new DomainException(ExceptionCode.NON_AVAILABLE_AUCION);
        }
        return comments.add(comment);
    }

    public String getId() {
        return id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public List<Comment> getComments() {
        return Lists.newArrayList(comments);
    }


    public enum Status {
        ACTIVE, DISABLED
    }
}
