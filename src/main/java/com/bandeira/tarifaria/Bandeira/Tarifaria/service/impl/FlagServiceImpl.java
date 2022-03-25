package com.bandeira.tarifaria.Bandeira.Tarifaria.service.impl;

import com.bandeira.tarifaria.Bandeira.Tarifaria.dto.FlagDto;
import com.bandeira.tarifaria.Bandeira.Tarifaria.model.FlagModel;
import com.bandeira.tarifaria.Bandeira.Tarifaria.repository.FlagRepository;
import com.bandeira.tarifaria.Bandeira.Tarifaria.service.FlagService;
import com.bandeira.tarifaria.Bandeira.Tarifaria.utils.DateConverter;
import com.bandeira.tarifaria.Bandeira.Tarifaria.utils.WebScrapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlagServiceImpl implements FlagService {
    @Autowired
    WebScrapping webScrapping;

    @Autowired
    FlagRepository flagRepository;

    @Override
    public ResponseEntity<?> getData() throws IOException {
        List<FlagDto> data = webScrapping.getData();
        saveData(data);
        List<FlagDto> flags = getDataFromDatabase();

        return ResponseEntity.ok().body(flags);
    }

    private void saveData(List<FlagDto> data) {
        for(FlagDto flag: data) {
            flagRepository
                    .findByMonthTextAndYear(flag.getMonth(), flag.getYear())
                    .orElseGet(() ->
                            flagRepository.save(FlagModel.builder()
                                    .flag(flag.getColor())
                                    .factor(flag.getValue())
                                    .monthText(flag.getMonth())
                                    .month(DateConverter.monthToText(flag.getMonth()))
                                    .year(flag.getYear())
                                    .build()
                            )
                    );
        }
    }


    private List<FlagDto> getDataFromDatabase() {
        List<FlagModel> dataBaseData = flagRepository.findAllByOrderByYearDescMonthDesc();
        List<FlagDto> dataToReturn = new ArrayList<>();

        dataBaseData.forEach(d-> {
            dataToReturn.add(FlagDto.builder()
                    .value(d.getFactor())
                    .color(d.getFlag())
                    .year(d.getYear())
                    .month(d.getMonthText())
                    .build());
        });

        return dataToReturn;
    }
}
