package com.uvocab.api.controller;

import com.uvocab.api.mapper.UserMapper;
import com.uvocab.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uvocab.protobuf.v1.User;

@RestController
@RequestMapping("/v1/user")
@AllArgsConstructor
public class UserController {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @PostMapping
  public ResponseEntity<User> postUser(@RequestBody User user) {
    var x = userRepository.save(userMapper.toDomain(user));
    return ResponseEntity.ok(userMapper.toProto(x));
  }
}
