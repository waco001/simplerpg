package com.gledx.rpg.engine.gameobject;

import java.awt.Point;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import com.gledx.rpg.engine.Camera;
import com.gledx.rpg.engine.Tile;
import com.gledx.rpg.engine.TileMap;

public class Enemy extends GameObject{
	public static final int startingX = TileMap.fromTile(23);
	public static final int startingY = TileMap.fromTile(23);
	public static float health;
	public static float maxHealth;
	private Random random;
	private int moved = 0;
	Player player;



	public Enemy() {
		super(startingX, startingY, "enemy");
		debug = true;
		maxHealth = 5;
        random = new Random();

		health = maxHealth;

	}
	public void update(){
		//System.out.println(TileMap.toTile(loc.x) + " " + TileMap.toTile(loc. y));
		//stamina += 0.5f;
		getAI();
		
		
	}
	public  void getInput(){
		
		   }

	
	public void getAI()
	{
		
		if (moved == 50)
				{
		int mx= random.nextInt(11);
		int my= random.nextInt(11);
		int vx= random.nextInt(2);
		int vy= random.nextInt(2);
		if (vx==0)
		{
			if(mx>0)
			{
			this.loc.x += Tile.width;
			}
		}
			else
		{
				if(mx>0)
				{
				this.loc.x -= Tile.width;
				}
		}
		if (vy==0)
		{
			if(my>0)
			{
			this.loc.y += Tile.height;
			}
		}
			else
		{
				if(my>0)
				{
				this.loc.y -= Tile.height;
				}
		}
		moved=0;
				}
		else
		{
			if(moved<50)
			{
			moved+=1;
			}

		}
	}
	
	public Point getLoc() {
		return loc;
	}
}

