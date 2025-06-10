package kata.foo.bar.quix.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kata.foo.bar.quix.service.FooBarQuixService;

@RestController
@RequestMapping("/api")
public class FooBarQuixController {

    private final FooBarQuixService fooBarQuixService;

    public FooBarQuixController(FooBarQuixService fooBarQuixService) {
        this.fooBarQuixService = fooBarQuixService;
    }

    @GetMapping("/transform/{number}")
    public ResponseEntity<String> transform(@PathVariable int number) {
        if (number < 0 || number > 100) {
            return ResponseEntity.badRequest().body("Le nombre doit être compris entre 0 et 100.");
        }

        String result = fooBarQuixService.transform(number);
        return ResponseEntity.ok(result);
    }
}

