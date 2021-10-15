package example.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Controller("/books")
public class BooksController {

    @Get("/stock/{isbn}")
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean getBooks(@NotBlank String isbn) {
        return bookInventoryByIsbn(isbn)
                .map(bookInventory -> bookInventory.getStock() > 0)
                .orElse(null);
    }

    private Optional<BookInventory> bookInventoryByIsbn(String isbn) {
        if ("1491950358".equals(isbn)) {
            return Optional.of(new BookInventory(isbn, 4));
        }
        if ("1680502395".equals(isbn)) {
            return Optional.of(new BookInventory(isbn, 0));
        }
        return Optional.empty();
    }
}
