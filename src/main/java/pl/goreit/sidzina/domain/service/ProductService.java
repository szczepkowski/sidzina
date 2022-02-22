package pl.goreit.sidzina.domain.service;


import pl.goreit.api.generated.ProductViewDetails;
import pl.goreit.api.generated.product_api.CreateProductRequest;
import pl.goreit.sidzina.domain.DomainException;

import java.util.List;

public interface ProductService {


    List<ProductViewDetails> findAll() throws DomainException;

    ProductViewDetails add(CreateProductRequest createProductRequest);

    ProductViewDetails addComment(String userId, String productTitle, String text) throws DomainException;

}
