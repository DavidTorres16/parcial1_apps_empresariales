package com.example.demo.services;

import com.example.demo.dto.PostDTO;
import com.example.demo.dto.PostUpdateDTO;
import com.example.demo.models.*;
import com.example.demo.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final CategoryRepository categoryRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository,
                       TagRepository tagRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Transactional
    public Post save(PostDTO postDTO) {
        User author = userRepository.findById(postDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Set<Tag> tags = postDTO.getTagIds() != null
                ? tagRepository.findAllById(postDTO.getTagIds()).stream().collect(Collectors.toSet())
                : Set.of();

        Set<Category> categories = postDTO.getCategoryIds() != null
                ? categoryRepository.findAllById(postDTO.getCategoryIds()).stream().collect(Collectors.toSet())
                : Set.of();

        Post post = Post.builder()
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .createdAt(LocalDateTime.now())
                .author(author)
                .tags(tags)
                .categories(categories)
                .build();

        return postRepository.save(post);
    }

    /**
     * Save function override to update Post
     * @Params PostUpdateDTO post data to update
     * @Return updated user
     */
    @Transactional
    public Post save(PostUpdateDTO postDTO) {

        if(!postRepository.existsById(postDTO.getId())){
            throw new RuntimeException("Post not found");
        }

        Post oldPostInfo = postRepository.findById(postDTO.getId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Set<Tag> tags = postDTO.getTagIds() != null
                ? tagRepository.findAllById(postDTO.getTagIds()).stream().collect(Collectors.toSet())
                : Set.of();

        Set<Category> categories = postDTO.getCategoryIds() != null
                ? categoryRepository.findAllById(postDTO.getCategoryIds()).stream().collect(Collectors.toSet())
                : Set.of();

        Post post = Post.builder()
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .createdAt(LocalDateTime.now())
                .author(oldPostInfo.getAuthor())
                .tags(tags)
                .categories(categories)
                .build();

        return postRepository.save(post);
    }

    public void deleteById(Long id) {
        if (!postRepository.existsById(id)) {
            throw new RuntimeException("Post not found");
        }
        postRepository.deleteById(id);
    }
}
