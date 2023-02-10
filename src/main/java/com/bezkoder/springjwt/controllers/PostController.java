package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.exception.PostNotFoundException;
import com.bezkoder.springjwt.models.Post;
import com.bezkoder.springjwt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public Post createPost(@Valid @RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable(value = "id") Long postId) {
        Post post = null;
        Optional<Post> optionalPost = postService.getPostById(postId);
        if (optionalPost.isPresent()) {
             post = optionalPost.get();
        } else {
            // handle case where post is not found
        }

        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable(value = "id") Long postId,
                                           @Valid @RequestBody Post postDetails) {
        Post post = postService.updatePost(postId, postDetails);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable(value = "id") Long postId) throws PostNotFoundException {
        Post post = postService.deletePost(postId);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(post);
    }
}