package com.book.trybootrestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.trybootrestbook.model.Game;
import com.book.trybootrestbook.service.GameService;

@RestController
public class GameController {

	@Autowired
	private GameService gameService;
	
	
	@GetMapping("/games")
	public List<Game> getGames(){
		return this.gameService.getAllGames();
	}
	
	// get game by id
	@GetMapping("/games/{id}")
	public Game getGame( @PathVariable("id")int id) {
		return gameService.getGameById(id);
	}
	
	// creating - to add new game 
	
	@PostMapping("/games")
	public Game addGame(@RequestBody Game game) {
		Game g = this.gameService.addGame(game);
		return g;
	}
	
}
