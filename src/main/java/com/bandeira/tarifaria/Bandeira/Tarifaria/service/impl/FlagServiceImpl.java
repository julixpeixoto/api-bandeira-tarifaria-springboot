package com.bandeira.tarifaria.Bandeira.Tarifaria.service.impl;

import com.bandeira.tarifaria.Bandeira.Tarifaria.dto.FlagDto;
import com.bandeira.tarifaria.Bandeira.Tarifaria.service.FlagService;
import com.bandeira.tarifaria.Bandeira.Tarifaria.utils.WebScrapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FlagServiceImpl implements FlagService {
    @Autowired
    WebScrapping webScrapping;

    @Override
    public ResponseEntity<?> getData() throws IOException {
        List<FlagDto> data = webScrapping.getData();

        return ResponseEntity.ok().body(data);
    }
}
