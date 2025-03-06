package com.example.demo.services;

import com.example.demo.dto.TagDTO;
import com.example.demo.dto.TagUpdateDTO;
import com.example.demo.models.Tag;
import com.example.demo.repositories.TagRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }

    public List<Tag> findAll() { return tagRepository.findAll(); }

    public Optional<Tag> findById(Long id) { return tagRepository.findById(id); }

    @Transactional
    public Tag save(TagDTO tagDTO) {
        Tag tag = new Tag();
        tag.setName(tagDTO.getName());
        return tagRepository.save(tag);
    }

    /**
     * Save function override to update Tags
     * @Params TagUpdateDTO tag data to update
     * @Return updated tag
     */
    @Transactional
    public Tag save(TagUpdateDTO tagDTO) {
        if(!tagRepository.existsById(tagDTO.getId())){
            throw new RuntimeException("Tag not found");
        }

        Tag tag = Tag.builder()
                .id(tagDTO.getId())
                .name(tagDTO.getName())
                .build();

        return tagRepository.save(tag);
    }

    public void deleteById(Long id) {
        if (!tagRepository.existsById(id)) {
            throw new RuntimeException("Comment not found");
        }
        tagRepository.deleteById(id);
    }
}