package com.bandeira.tarifaria.Bandeira.Tarifaria.service.impl;

import com.bandeira.tarifaria.Bandeira.Tarifaria.dto.FlagDto;
import com.bandeira.tarifaria.Bandeira.Tarifaria.service.WebScrapingService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class WebScrapingServiceImpl implements WebScrapingService {
    @Value("${source.url}")
    private String url;

    public List<FlagDto> getData() throws IOException {
        Document document = Jsoup.connect(url).get();

        List<FlagDto> flagData = new ArrayList<>();

        for (int i = 1; i <= 12; i++){
            FlagDto flagDto = FlagDto.builder()
                    .color(String.valueOf(document.select("#id_sc_field_bandeira_" + i).first().childNode(0)))
                    .month(String.valueOf(document.select("#id_sc_field_mes_" + i).first().childNode(0)))
                    .year(String.valueOf(document.select("#id_sc_field_ano_" + i).first().childNode(0)))
                    .value(String.valueOf(document.select("#id_sc_field_valor_" + i).first().childNode(0)))
                    .build();

            flagData.add(flagDto);
        }

        return flagData;
    }
}
