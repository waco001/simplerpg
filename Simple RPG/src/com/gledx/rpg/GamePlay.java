package com.gledx.rpg;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import com.gledx.rpg.engine.Camera;
import com.gledx.rpg.engine.ScreenState;
import com.gledx.rpg.engine.TextureManager;
import com.gledx.rpg.engine.Tile;
import com.gledx.rpg.engine.gameobject.GameObject;
import com.gledx.rpg.engine.gameobject.Player;

public class GamePlay extends ScreenState{
	public static Player player = new Player();
	public static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	static Tile tile;
	public static void init(){
		//gameObjects.add(player);
		// load a default java font.
		TextureManager.load();
		tile = new Tile(50, 40, "dirt");
		}
	public static void render(){
		if(Display.isVisible() || Display.isDirty()){

			//for(GameObject g : gameObjects)
				//g.render();
			tile.render();
			
		}
	}
	public static void update(){	
		Camera.update();
		for(GameObject g : gameObjects)
			g.update();
		Display.update();
		Display.sync(Game.frameRate);

	}
	public static void getInput(){
		while(Keyboard.next()){
			for(GameObject g : gameObjects)
				g.getInput();
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				Game.gameState = Game.gamestate.GAME_EXIT;
			}
		}
	}
}
