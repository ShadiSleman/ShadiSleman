package com.NBA.repository;

import com.NBA.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDTO extends CrudRepository<Player,String> {
}
