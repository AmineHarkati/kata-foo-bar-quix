package kata.foo.bar.quix.service;

import org.springframework.stereotype.Service;

@Service
public class FooBarQuixService {

    public String transform(int number) {
        StringBuilder result = new StringBuilder();

        boolean divisibleHandled = false;

        if (number % 3 == 0) {
            result.append("FOO");
            divisibleHandled = true;
        }
        if (number % 5 == 0) {
            result.append("BAR");
            divisibleHandled = true;
        }

        // Si au moins un "divisible par" a été trouvé, on applique la règle de priorité
        if (divisibleHandled) {
            for (char digit : String.valueOf(number).toCharArray()) {
                if (digit == '3') result.append("FOO");
                if (digit == '5') result.append("BAR");
                if (digit == '7') result.append("QUIX");
            }
            return result.toString();
        }

        // Sinon, juste analyser les chiffres
        for (char digit : String.valueOf(number).toCharArray()) {
            if (digit == '3') result.append("FOO");
            if (digit == '5') result.append("BAR");
            if (digit == '7') result.append("QUIX");
        }

        return result.length() > 0 ? result.toString() : String.valueOf(number);
    }
}
