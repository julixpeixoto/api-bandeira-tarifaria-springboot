package com.bandeira.tarifaria.Bandeira.Tarifaria.service;

import com.bandeira.tarifaria.Bandeira.Tarifaria.dto.FlagDto;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface FlagService {
    ResponseEntity<?> getData() throws IOException;
    void saveData(List<FlagDto> data);
}
