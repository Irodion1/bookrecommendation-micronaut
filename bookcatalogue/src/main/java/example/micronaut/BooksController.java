package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/books")
public class BooksController {

    @Get
    public List<Book> getBooks() {
        return List.of(
                new Book("1491950358", "Building Microservices"),
                new Book("1680502395", "Release It!"),
                new Book("1491950359", "Test It!"),
                new Book("0321601912", "Continuous Delivery:")
        );
    }
}
