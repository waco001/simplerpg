package com.gledx.rpg;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import com.gledx.rpg.engine.Camera;
import com.gledx.rpg.engine.Font;
import com.gledx.rpg.engine.ScreenState;
import com.gledx.rpg.engine.World;
import com.gledx.rpg.engine.gameobject.GameObject;
import com.gledx.rpg.engine.gameobject.Player;

public class GamePlay extends ScreenState{
	public static Player player = new Player();
	public static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	public static void init(){
		gameObjects.add(player);
		// load a default java font
		}
	public static void render(){
		if(Display.isVisible() || Display.isDirty()){

			//for(GameObject g : gameObjects)
				//g.render();
			
			Font.drawString("Hello", World.tileToPixel(20), World.tileToPixel(28));
			World.render();
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
