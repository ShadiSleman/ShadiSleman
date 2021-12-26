package com.NBA.service;

import com.NBA.model.Player;
import com.NBA.repository.PlayerDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class PlayerService {

    @Autowired
    private PlayerDTO cdto;

    String line = "";

    public ArrayList<Player> retrieveData() {

        try {
            ArrayList<Player> players = new ArrayList<Player>();
            BufferedReader br = new BufferedReader(new FileReader("C:\\Projects\\NBA\\src\\main\\resources\\players.csv"));
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                Player p = new Player();
                p.setId(data[0]);
                p.setNickName(data[1]);

                RestTemplate restTemplate = new RestTemplate();
                String specificPlayer = "https://www.balldontlie.io/api/v1/players/";
                String id= p.getId();
                ResponseEntity<String> response
                        = restTemplate.getForEntity(specificPlayer + id, String.class);
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(response.getBody());
                JsonNode lastName = root.path("last_name");
                JsonNode position = root.path("position");

                p.setLastName(lastName.textValue());
                p.setPosition(position.textValue());
                cdto.save(p);
                players.add(p);

            }
            return players;

        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
