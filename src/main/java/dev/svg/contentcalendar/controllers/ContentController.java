package dev.svg.contentcalendar.controllers;

import dev.svg.contentcalendar.model.Content;
import dev.svg.contentcalendar.services.ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/content")
public class ContentController {

    private final ContentService service;

    public ContentController(ContentService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Content> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Content getById(@PathVariable Integer id) {
        return service.getById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @PostMapping("")
    public void create(@RequestBody Content content) {
        service.create(content);
    }

}
