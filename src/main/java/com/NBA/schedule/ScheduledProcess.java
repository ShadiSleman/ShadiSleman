package com.NBA.schedule;

import com.NBA.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component


public class ScheduledProcess {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledProcess.class);

    @Autowired
    PlayerService playerService ;

    @Scheduled(cron = "* */15 * * * * ")
    public void updateDB() {

        LOGGER.info("Data refresh every 15 minutes");

        playerService.retrieveData();

    }


}

