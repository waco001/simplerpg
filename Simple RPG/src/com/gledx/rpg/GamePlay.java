package com.gledx.rpg;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import com.gledx.rpg.engine.Camera;
import com.gledx.rpg.engine.ScreenState;
import com.gledx.rpg.engine.TextureManager;
import com.gledx.rpg.engine.Tile;
import com.gledx.rpg.engine.TileMap;
import com.gledx.rpg.engine.gameobject.GameObject;
import com.gledx.rpg.engine.gameobject.Player;
import com.gledx.rpg.engine.gameplayoverlay.Overlay;

public class GamePlay extends ScreenState{
	public static Player player;
	public static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	static Tile tile;
	static Tile tile1;
	static Tile tile2;
	static Tile tile3;
	public static void init(){
		//gameObjects.add(player);
		// load a default java font.
		TextureManager.load();
		TileMap.initMap();
		player = new Player();
		Camera.init();
		}
	public static void render(){
		if(Display.isVisible() || Display.isDirty()){

			//for(GameObject g : gameObjects)
				//g.render();
			TileMap.render();
			player.render();
			Overlay.render();
		}
	}
	public static void update(){	
		Camera.update();
		player.update();
		Display.update();
		Display.sync(Game.frameRate);

	}
	public static void getInput(){
		while(Keyboard.next()){
			player.getInput();
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				Game.gameState = Game.gamestate.GAME_EXIT;
			}
		}
	}
}
