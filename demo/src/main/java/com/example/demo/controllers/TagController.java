package com.example.demo.controllers;

import com.example.demo.dto.TagDTO;
import com.example.demo.dto.TagUpdateDTO;
import com.example.demo.models.Tag;
import com.example.demo.services.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for managing Tags.
 */
@RestController
@RequestMapping("/tags")
public class TagController {

    private TagService tagService;

    public TagController(TagService tagService){
        this.tagService = tagService;
    }

    /**
     * Retrieve all tags.
     * @return List of all tags.
     */
    @GetMapping
    public List<Tag> getAllTags() { return tagService.findAll(); }

    /**
     * Retrieve a tag by ID.
     * @param id Tag ID.
     * @return Tag details if found.
     */
    @GetMapping("/{id}")
    public Optional<Tag> getTagById(@PathVariable Long id) { return tagService.findById(id); }

    /**
     * Create a new tag.
     * @param tag Tag object.
     * @return The created tag.
     */
    @PostMapping
    public Tag createTag(@RequestBody TagDTO tag) { return tagService.save(tag); }

    /**
     * Update an existent tag.
     * @param tag Tag object.
     * @return The Updated tag.
     */
    @PutMapping
    public Tag createTag(@RequestBody TagUpdateDTO tag) { return tagService.save(tag); }


    /**
     * Delete a tag by ID.
     * @param id Tag ID.
     */
    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable Long id) { tagService.deleteById(id); }
}

