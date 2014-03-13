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
	public static float stamina;
	public static float maxStamina;
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
		maxStamina = 250;

		health = maxHealth;
		stamina = maxStamina;
		canMove = true;
	}
	public void update(){
		//System.out.println(TileMap.toTile(loc.x) + " " + TileMap.toTile(loc. y));
		//stamina += 0.5f;
		if(stamina > maxStamina / 25)
			canMove = true;
		if(stamina >= maxStamina)
			stamina = maxStamina;
		if(stamina <= 5)
			canMove = false;
		if( !Keyboard.isKeyDown(Keyboard.KEY_W))
		{
			if( !Keyboard.isKeyDown(Keyboard.KEY_A))
			{
				if( !Keyboard.isKeyDown(Keyboard.KEY_S))
				{
					if ( !Keyboard.isKeyDown(Keyboard.KEY_D) )
					{
		{
			if(stamina<maxStamina)
			{
         stamina+=0.1f;
			}
		}
		}
		}
	    }
		}
	}
	public  void getInput(){
		if(canMove == true){
			if(Keyboard.isKeyDown(Keyboard.KEY_D)){
				this.loc.x += Tile.width;
				Camera.transx += Tile.width;
				stamina -= 0.5f;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_S)){
				this.loc.y -= Tile.height;
				Camera.transy -= Tile.width;
				stamina -= 0.5f;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_A)){
				this.loc.x -= Tile.width;
				Camera.transx -= Tile.width;
				stamina -= 0.5f;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_W)){
				this.loc.y += Tile.height;
				Camera.transy += Tile.width;
				stamina -= 0.5f;
			}
			//stamina -= 5.0f;
			
		}

	}
	public Point getLoc() {
		return loc;
	}
}

