package com.muniao.springsession.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.session.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class HelloController
{
    @RequestMapping("hello")
    public String hello()
    {
        return "hello";
    }

    @Value("${server.port}")
    Integer port;

    @GetMapping("set")
    public String set(HttpSession session)
    {
        session.setAttribute("username","李小鹏");
        return port+" session set ok";
    }

    @GetMapping("get")
    public String get(HttpSession session)
    {
        String username = (String)session.getAttribute("username");
        return port+" session get ok:"+username;
    }
}
