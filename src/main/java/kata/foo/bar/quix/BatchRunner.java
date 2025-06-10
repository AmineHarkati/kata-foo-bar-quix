package kata.foo.bar.quix;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import kata.foo.bar.quix.batch.FooBarQuixBatch;

@Component
public class BatchRunner implements CommandLineRunner {

    private final FooBarQuixBatch batch;

    public BatchRunner(FooBarQuixBatch batch) {
        this.batch = batch;
    }

    @Override
    public void run(String... args) {
        batch.runBatch();
    }
}

