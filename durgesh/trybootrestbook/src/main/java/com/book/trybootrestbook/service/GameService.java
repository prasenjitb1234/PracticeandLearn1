package com.book.trybootrestbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.book.trybootrestbook.model.Game;

@Service
public class GameService {

	private static List<Game> list = new ArrayList<>();
	
	static {
		list.add(new Game(1,"GTA5","Rockstar"));
		list.add(new Game(2,"Call of Duty","Activision"));
		list.add(new Game(3,"Pubg","Tencent"));
	}
	
	// get all games 
	
	public List<Game> getAllGames(){
		return list;
	}
	
	// get games by id
	
	public Game getGameById(int id) {
		Game game = null;
		
		for(Game currentGame : list) {
			if(currentGame.getId()==id) {
				game = currentGame;
				break;
			}
		}
		return game;
	}
	
	
	// creating a service to add a new game 
	
	public Game addGame(Game g) {
		list.add(g);
		return g;
	}
	
	
}
