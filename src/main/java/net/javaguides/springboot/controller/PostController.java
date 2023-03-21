package net.javaguides.springboot.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class PostController {

  public static final String ADMIN = "/admin";
  public static final String ADMIN_POSTS = ADMIN + "/posts";
  public static final String REDIRECT_ADMIN_POSTS = "redirect:" + ADMIN_POSTS;
  public static final String ADMIN_POSTS_NEW = ADMIN_POSTS + "/new-post";
  public static final String ADMIN_CREATE_POST = ADMIN + "/create_post";
  public static final String ADMIN_POST_EDIT = ADMIN_POSTS + "/{postId}/edit";
  public static final String ADMIN_EDIT_POST = ADMIN + "/edit_post";
  public static final String ADMIN_POST_ID = ADMIN_POSTS + "/{postId}";
  public static final String ADMIN_POST_DELETE = ADMIN_POSTS + "/{postId}/delete";

  private final PostService postService;

  @GetMapping(ADMIN_POSTS)
  public String posts(Model model) {
    model.addAttribute("posts", postService.findAllPosts());
    return ADMIN_POSTS;
  }

  @GetMapping(ADMIN_POSTS_NEW)
  public String newPostForm(Model model) {
    model.addAttribute("post", new PostDto());
    return ADMIN_CREATE_POST;
  }

  @PostMapping(ADMIN_POSTS)
  public String createPost(@ModelAttribute("post") @Valid PostDto postDto,
                            BindingResult bindingResult, Model model) {
    if(bindingResult.hasErrors()) {
      model.addAttribute("post", postDto);
      return ADMIN_CREATE_POST;
    }
    postDto.setUrl(getUrl(postDto.getTitle()));
    postService.create_post(postDto);
    return REDIRECT_ADMIN_POSTS;
  }

  @GetMapping(ADMIN_POST_EDIT)
  public String editPostForm(@PathVariable("postId") Long postId, Model model) {
    model.addAttribute("post", postService.findPostById(postId));
    return ADMIN_EDIT_POST;
  }

  @PostMapping(ADMIN_POST_ID)
  public String updatePost(@PathVariable("postId") Long postId,
                           @Valid @ModelAttribute("post") PostDto postDto,
                            BindingResult bindingResult,
                            Model model) {
    if(bindingResult.hasErrors()) {
      model.addAttribute("post", postDto);
      return ADMIN_EDIT_POST;
    }
    postDto.setId(postId);
    postService.update_post(postDto);
    return REDIRECT_ADMIN_POSTS;
  }

  @GetMapping(ADMIN_POST_DELETE)
  public String deletePost(@PathVariable("postId") Long postId) {
    postService.deletePost(postId);
    return REDIRECT_ADMIN_POSTS;
  }

  private static String getUrl(String postTitle) {
    return postTitle.trim().toLowerCase().replaceAll("\\s+", "-")
        .replaceAll("[^A-Za-z0-9]", "-");
  }
}
