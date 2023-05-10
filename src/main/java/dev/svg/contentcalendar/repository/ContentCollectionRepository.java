package dev.svg.contentcalendar.repository;

import dev.svg.contentcalendar.model.Content;
import dev.svg.contentcalendar.model.Status;
import dev.svg.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(content -> content.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.add(content);
    }
    @PostConstruct
    private void init(){
        contentList.add(new Content(1,
                "First Content",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""));
        contentList.add(new Content(2,
                "Second Content",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""));
    }

}
