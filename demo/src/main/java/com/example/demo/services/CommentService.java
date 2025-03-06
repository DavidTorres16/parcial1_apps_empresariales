package com.example.demo.services;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.CommentUpdateDTO;
import com.example.demo.models.Comment;
import com.example.demo.models.Post;
import com.example.demo.repositories.CommentRepository;
import com.example.demo.repositories.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    private PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> findAll() { return commentRepository.findAll(); }

    public Optional<Comment> findById(Long id) { return commentRepository.findById(id); }

    @Transactional
    public Comment save(CommentDTO commentDTO) {
        Post post = postRepository.findById(commentDTO.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Comment comment = Comment.builder()
                .content(commentDTO.getContent())
                .createdAt(LocalDateTime.now())
                .post(post)
                .build();
        return commentRepository.save(comment);
    }

    /**
     * Save function override to update Comment
     * @Params CommentUpdateDTO comment data to update
     * @Return updated comment
     */
    @Transactional
    public Comment save(CommentUpdateDTO commentDTO) {
        if(!commentRepository.existsById(commentDTO.getId())){
            throw new RuntimeException("Comment not found");
        }

        Comment oldComment = commentRepository.findById(commentDTO.getId())
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        Comment comment = Comment.builder()
                .id(commentDTO.getId())
                .content(commentDTO.getContent())
                .createdAt(LocalDateTime.now())
                .post(oldComment.getPost())
                .build();
        return commentRepository.save(comment);
    }

    public void deleteById(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new RuntimeException("Comment not found");
        }
        commentRepository.deleteById(id);
    }
}