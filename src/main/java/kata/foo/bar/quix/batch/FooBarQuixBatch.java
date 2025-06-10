package kata.foo.bar.quix.batch;


import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import kata.foo.bar.quix.service.FooBarQuixService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class FooBarQuixBatch {

    private final FooBarQuixService service;

    public FooBarQuixBatch(FooBarQuixService service) {
        this.service = service;
    }

    public void runBatch() {
        try {
            // Lecture du fichier input.txt depuis resources
            File inputFile = new ClassPathResource("input.txt").getFile();
            List<String> lines = Files.readAllLines(inputFile.toPath());

            // Chemin du fichier output.txt dans resources
            Path outputPath = Path.of("src/main/resources/output.txt");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath.toFile()))) {
                for (String line : lines) {
                    try {
                        int number = Integer.parseInt(line.trim());
                        if (number < 0 || number > 100) {
                            writer.write(line + "    ERREUR: nombre hors limite");
                        } else {
                            String result = service.transform(number);
                            writer.write(line + "    " + result);
                        }
                    } catch (NumberFormatException e) {
                        writer.write(line + "    ERREUR: entrée invalide");
                    }
                    writer.newLine();
                }
            }

            System.out.println("Batch terminé. Fichier généré : resources/output.txt");

        } catch (IOException e) {
            System.err.println("Erreur batch : " + e.getMessage());
        }
    }
}
