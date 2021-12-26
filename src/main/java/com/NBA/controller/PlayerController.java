package com.NBA.controller;

import com.NBA.model.Player;
import com.NBA.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService ps;

    @RequestMapping(path="/player", method = RequestMethod.GET)
    public ArrayList<Player> getCSVData(){

        return ps.retrieveData();
    }




}
