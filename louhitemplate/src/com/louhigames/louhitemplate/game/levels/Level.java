package com.louhigames.louhitemplate.game.levels;

import java.util.ArrayList;

import com.louhigames.louhitemplate.game.objects.AbstractGameObject;

public class Level {

	private ArrayList<AbstractGameObject> gameObjects;
	
	
	public void addGameObject(AbstractGameObject gameObject) {
		
		if (gameObjects == null)
			gameObjects = new ArrayList<AbstractGameObject>();
		
		gameObjects.add(gameObject);
		
	}
}
