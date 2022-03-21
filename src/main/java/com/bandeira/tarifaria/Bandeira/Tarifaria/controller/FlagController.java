package com.bandeira.tarifaria.Bandeira.Tarifaria.controller;

import com.bandeira.tarifaria.Bandeira.Tarifaria.service.FlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class FlagController {
    @Autowired
    FlagService flagService;

    @GetMapping
    public ResponseEntity<?> getFlags() throws IOException {
        return flagService.getData();
    }
}
