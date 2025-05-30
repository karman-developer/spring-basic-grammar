package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@RestController
public class UserController {
	private final UserService service;
}
