package dev.svg.contentcalendar.services;

import dev.svg.contentcalendar.model.Content;
import dev.svg.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    private final ContentCollectionRepository repository;

    public ContentService(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    public List<Content> getAll() {
        return repository.findAll();
    }

    public Optional<Content> getById(Integer id) {
        return repository.findById(id);
    }

    public void create(Content content) {
        repository.save(content);
    }
}
