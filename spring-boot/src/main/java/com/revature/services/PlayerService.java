package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Player;
import com.revature.repositories.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;

	public List<Player> findAll() {
		return playerRepository.findAll();
	}

}
