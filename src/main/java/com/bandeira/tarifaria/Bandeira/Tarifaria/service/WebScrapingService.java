package com.bandeira.tarifaria.Bandeira.Tarifaria.service;

import com.bandeira.tarifaria.Bandeira.Tarifaria.dto.FlagDto;

import java.io.IOException;
import java.util.List;

public interface WebScrapingService {
    List<FlagDto> getData() throws IOException;
}
