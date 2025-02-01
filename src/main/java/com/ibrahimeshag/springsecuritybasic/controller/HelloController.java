package com.ibrahimeshag.springsecuritybasic.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @PreAuthorize("hasAuthority('read')")
    @GetMapping("/world")
    public String world() {
        return "world!";
    }

}
