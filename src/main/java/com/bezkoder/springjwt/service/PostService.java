package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.controllers.PostRepository;
import com.bezkoder.springjwt.exception.PostNotFoundException;
import com.bezkoder.springjwt.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public Post createPost(Post post) {
        postRepository.save(post);
        return post;
    }
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public Post deletePost(Long postId) throws PostNotFoundException {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            postRepository.delete(post);
            return post;
        } else {
            throw new PostNotFoundException("Post with id " + postId + " not found");
        }
    }
    public Post updatePost(Long id, Post postDetails) {
        Post post = postRepository.getOne(id);
        post.setTitle(postDetails.getTitle());
        post.setDescription(postDetails.getDescription());
        post.setCategory(postDetails.getCategory());
        postRepository.save(post);
        return post;
    }

    public List<Post> getPostsByCategory(Long categoryId) {
        return postRepository.findByCategoryId(categoryId);
    }
}