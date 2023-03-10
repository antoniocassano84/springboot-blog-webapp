package net.javaguides.springboot.controller;

import jakarta.validation.Valid;
import java.util.List;
import net.javaguides.springboot.dto.PostDto;
import net.javaguides.springboot.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

  public static final String REDIRECT_ADMIN_POSTS = "redirect:/admin/posts";
  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/admin/posts")
  public String posts(Model model) {
    List<PostDto> posts = postService.findAllPosts();
    model.addAttribute("posts", posts);
    return "/admin/posts";
  }

  @GetMapping("/admin/posts/new-post")
  public String newPostForm(Model model) {
    model.addAttribute("post", new PostDto());
    return "/admin/create_post";
  }

  @PostMapping("/admin/posts")
  public String createPost(@ModelAttribute("post") @Valid PostDto postDto,
                            BindingResult bindingResult, Model model) {
    if(bindingResult.hasErrors()) {
      model.addAttribute("post", postDto);
      return "/admin/create_post";
    }
    postDto.setUrl(getUrl(postDto.getTitle()));
    postService.create_post(postDto);
    return REDIRECT_ADMIN_POSTS;
  }

  @GetMapping("/admin/posts/{postId}/edit")
  public String editPostForm(@PathVariable("postId") Long postId, Model model) {
    model.addAttribute("post", postService.findPostById(postId));
    return "/admin/edit_post";
  }

  @PostMapping("/admin/posts/{postId}")
  public String updatePost(@PathVariable("postId") Long postId,
                           @Valid @ModelAttribute("post") PostDto postDto,
                            BindingResult bindingResult,
                            Model model) {
    if(bindingResult.hasErrors()) {
      model.addAttribute("post", postDto);
      return "/admin/edit_post";
    }
    postDto.setId(postId);
    postService.update_post(postDto);
    return REDIRECT_ADMIN_POSTS;
  }

  @GetMapping("/admin/posts/{postId}/delete")
  public String deletePost(@PathVariable("postId") Long postId) {
    postService.deletePost(postId);
    return REDIRECT_ADMIN_POSTS;
  }

  private static String getUrl(String postTitle) {
    return postTitle.trim().toLowerCase().replaceAll("\\s+", "-")
        .replaceAll("[^A-Za-z0-9]", "-");
  }
}
