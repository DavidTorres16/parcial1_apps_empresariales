package com.example.demo.controllers;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.CommentUpdateDTO;
import com.example.demo.models.Comment;
import com.example.demo.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    /**
     * Retrieve all comments.
     * @return List of all comments.
     */
    @GetMapping
    public List<Comment> getAllComments() { return commentService.findAll(); }

    /**
     * Retrieve a comment by ID.
     * @param id Comment ID.
     * @return Comment details if found.
     */
    @GetMapping("/{id}")
    public Optional<Comment> getCommentById(@PathVariable Long id) { return commentService.findById(id); }

    /**
     * Create a new comment.
     * @param comment Comment object.
     * @return The created comment.
     */
    @PostMapping
    public Comment createComment(@RequestBody CommentDTO comment) { return commentService.save(comment); }

    /**
     * Update an existent comment.
     * @param comment Comment object.
     * @return The updated comment.
     */
    @PutMapping
    public Comment createComment(@RequestBody CommentUpdateDTO comment) { return commentService.save(comment); }


    /**
     * Delete a comment by ID.
     * @param id Comment ID.
     */
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) { commentService.deleteById(id); }
}
