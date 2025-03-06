package com.example.demo.controllers;


import com.example.demo.dto.PostDTO;
import com.example.demo.dto.PostUpdateDTO;
import com.example.demo.models.Post;
import com.example.demo.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    /**
     * Retrieve all posts.
     * @return List of all posts.
     */
    @GetMapping
    public List<Post> getAllPosts() { return postService.findAll(); }

    /**
     * Retrieve a post by ID.
     * @param id Post ID.
     * @return Post details if found.
     */
    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable Long id) { return postService.findById(id); }

    /**
     * Create a new post.
     * @param post Post object.
     * @return The created post.
     */
    @PostMapping
    public Post createPost(@RequestBody PostDTO post) { return postService.save(post); }

    /**
     * Update an existent post.
     * @param post Post object.
     * @return The updated post.
     */
    @PutMapping
    public Post createPost(@RequestBody PostUpdateDTO post) { return postService.save(post); }

    /**
     * Delete a post by ID.
     * @param id Post ID.
     */
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) { postService.deleteById(id); }
}
