package com.gledx.rpg.engine.gameobject;

import org.lwjgl.input.Keyboard;

import com.gledx.rpg.engine.Camera;
import com.gledx.rpg.engine.Tile;
import com.gledx.rpg.engine.TileMap;

public class Player extends GameObject{
	public static final int startingX = TileMap.fromTile(5);
	public static final int startingY = TileMap.fromTile(5);
	public Player() {
		super(startingX, startingY, "player");
		debug = true;
	}
	public void update(){
		//System.out.println(TileMap.toTile(loc.x) + " " + TileMap.toTile(loc. y));
	}
	public  void getInput(){
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			this.loc.x += Tile.width;
			Camera.transx -= Tile.width;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			this.loc.y -= Tile.height;
			Camera.transy += Tile.width;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			this.loc.x -= Tile.width;
			Camera.transx += Tile.width;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			this.loc.y += Tile.height;
			Camera.transy -= Tile.width;
		}
		
	}

}

