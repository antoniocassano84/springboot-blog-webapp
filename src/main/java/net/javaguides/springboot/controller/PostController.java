package net.javaguides.springboot.controller;

import java.util.List;
import net.javaguides.springboot.dto.PostDto;
import net.javaguides.springboot.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

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
}
