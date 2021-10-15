package example.micronaut;

import io.micronaut.context.env.Environment;
import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        Micronaut.build(args)
                .packages("example.micronaut")
                .defaultEnvironments(Environment.DEVELOPMENT)
                .start();
    }
}
