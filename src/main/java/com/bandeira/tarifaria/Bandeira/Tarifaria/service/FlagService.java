package com.bandeira.tarifaria.Bandeira.Tarifaria.service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface FlagService {
    public ResponseEntity<?> getData() throws IOException;
}
