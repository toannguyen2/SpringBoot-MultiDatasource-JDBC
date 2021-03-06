package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data1")
public class Data1 {
    @Autowired
    @Qualifier("jdbc-1")
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public ResponseEntity<List<User>> data()
    {
        List<User> listUser = jdbcTemplate.query("SELECT * FROM `users`", new UserRowMapper());

        return new ResponseEntity<>(listUser, HttpStatus.OK);
    }
}
