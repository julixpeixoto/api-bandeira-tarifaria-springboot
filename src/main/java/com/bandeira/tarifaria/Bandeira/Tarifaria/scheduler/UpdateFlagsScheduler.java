package com.bandeira.tarifaria.Bandeira.Tarifaria.scheduler;


import com.bandeira.tarifaria.Bandeira.Tarifaria.dto.FlagDto;
import com.bandeira.tarifaria.Bandeira.Tarifaria.service.FlagService;
import com.bandeira.tarifaria.Bandeira.Tarifaria.service.WebScrapingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class UpdateFlagsScheduler {
    @Autowired
    private WebScrapingService webScrapingService;

    @Autowired
    private FlagService flagService;

    @Scheduled(fixedRateString = "${scheduler.interval}", timeUnit = TimeUnit.MINUTES)
    public void updateFlags() throws IOException {
        log.info("Updating flags...");
        List<FlagDto> data = webScrapingService.getData();
        flagService.saveData(data);
    }
}
