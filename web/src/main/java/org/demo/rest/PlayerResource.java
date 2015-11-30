package org.demo.rest;

import org.demo.domain.Player;
import org.demo.domain.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/player")
@Transactional
public class PlayerResource {

    @Autowired
    PlayerRepository playerRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Player> findAll() {
        return playerRepository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Player save(@RequestBody Player player) {
        return playerRepository.save(player);
    }

}
