package me.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.springbootdeveloper.dto.AddUserRequest;
import me.springbootdeveloper.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {

  private final UserService userService;

  @PutMapping("/user")
  public String signup(AddUserRequest request) {
    userService.save(request);
    return "redirect:/login";
  }
}
