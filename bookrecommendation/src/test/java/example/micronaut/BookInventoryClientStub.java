package example.micronaut;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.retry.annotation.Fallback;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotBlank;

@Requires(env = Environment.TEST)
@Fallback
@Singleton
public class BookInventoryClientStub implements BookInventoryOperations {

    @Override
    public Mono<Boolean> stock(@NotBlank String isbn) {
        if ("1491950358".equals(isbn)) {
            return Mono.just(true);
        }
        if ("1680502395".equals(isbn)) {
            return Mono.just(false);
        }
        return Mono.empty();
    }

}
