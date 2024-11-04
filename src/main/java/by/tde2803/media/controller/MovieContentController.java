package by.tde2803.media.controller;

import by.tde2803.media.domain.MovieContent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MovieContentController {
    private static final String template = "Movie \"%s\"";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/movie")
    public MovieContent movieContent(@RequestParam(value = "title", defaultValue = "Unknown") String title) {
        return new MovieContent(counter.incrementAndGet(), String.format(template, title));
    }
}
