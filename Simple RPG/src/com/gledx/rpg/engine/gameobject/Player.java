package com.gledx.rpg.engine.gameobject;

import java.awt.Point;

import org.lwjgl.input.Keyboard;

import com.gledx.rpg.engine.Camera;
import com.gledx.rpg.engine.Tile;
import com.gledx.rpg.engine.TileMap;
import com.gledx.rpg.engine.gameobject.items.Item;
import com.gledx.rpg.engine.gameobject.items.ItemManager;

public class Player extends GameObject{
	public static final int startingX = TileMap.fromTile(25);
	public static final int startingY = TileMap.fromTile(25);
	public static float health;
	public static float maxHealth;
	public static float speed;
	public static float maxSpeed;
	public static boolean canMove;
	/*public static Item[] Inventory = new Item[] {
												ItemManager.NOTHING,
												ItemManager.NOTHING,
												ItemManager.NOTHING,
												ItemManager.NOTHING,
												ItemManager.NOTHING,
												ItemManager.NOTHING,
												ItemManager.NOTHING,
												ItemManager.NOTHING,
												ItemManager.NOTHING
												};*/
	public Player() {
		super(startingX, startingY, "player");
		debug = true;
		maxHealth = 5;
		maxSpeed = 250;

		health = maxHealth;
		speed = maxSpeed;
		canMove = true;
	}
	public void update(){
		//System.out.println(TileMap.toTile(loc.x) + " " + TileMap.toTile(loc. y));
		speed += 0.5f;
		if(speed > maxSpeed / 25)
			canMove = true;
		if(speed >= maxSpeed)
			speed = maxSpeed;
		if(speed <= 5)
			canMove = false;
	}
	public  void getInput(){
		if(canMove == true){
			if(Keyboard.isKeyDown(Keyboard.KEY_D)){
				this.loc.x += Tile.width;
				Camera.transx += Tile.width;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_S)){
				this.loc.y -= Tile.height;
				Camera.transy -= Tile.width;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_A)){
				this.loc.x -= Tile.width;
				Camera.transx -= Tile.width;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_W)){
				this.loc.y += Tile.height;
				Camera.transy += Tile.width;
			}
			speed -= 5.0f;
			
		}

	}
	public Point getLoc() {
		return loc;
	}
}

