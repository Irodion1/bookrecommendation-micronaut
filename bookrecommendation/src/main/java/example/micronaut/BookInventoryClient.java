package example.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Recoverable;
import reactor.core.publisher.Mono;

@Client(id = "bookinventory")
@Recoverable(api = BookInventoryOperations.class)
interface BookInventoryClient extends BookInventoryOperations {

    @Override
    @Consumes(MediaType.TEXT_PLAIN)
    @Get("/books/stock/{isbn}")
    Mono<Boolean> stock(String isbn);

}
