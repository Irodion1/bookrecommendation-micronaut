package example.micronaut;

import reactor.core.publisher.Mono;

import javax.validation.constraints.NotBlank;

public interface BookInventoryOperations {

    Mono<Boolean> stock(@NotBlank String isbn);

}
