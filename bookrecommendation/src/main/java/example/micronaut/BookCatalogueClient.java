package example.micronaut;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Recoverable;
import org.reactivestreams.Publisher;

@Client("http://localhost:8081")
@Recoverable(api = BookCatalogueOperations.class)
interface BookCatalogueClient extends BookCatalogueOperations {

    @Override
    @Get("/books")
    Publisher<Book> findAll();

}
