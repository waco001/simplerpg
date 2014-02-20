package com.gledx.rpg.engine.gameobject;

import java.awt.Point;

import org.lwjgl.input.Keyboard;

import com.gledx.rpg.engine.Camera;
import com.gledx.rpg.engine.World;




public class Player extends GameObject{
	private static final int startingX = 20;
	private static final int startingY = 15;

	private boolean left, right, up, down = false;
	private int move = 0;


	public Player() {
		super(startingX, startingY, 0.8f, 0.1f, 0.1f);
		debug = true;
	}
	public void update(){
		{ 
			{//NEEDED
				spr.setX(loc.x);
				spr.setY(loc.y);
			}
			{
				if(move == 6){ //Makes player move at 60/6 fps... 
					if(left && World.canMoveBounds(new Point(loc.x - 1, loc.y))){
						loc.x -= 1;
						Camera.transx += 1;
					}
					if(right && World.canMoveBounds(new Point(loc.x + 1, loc.y))){
						loc.x += 1;
						Camera.transx -= 1;
					}
					if(up && World.canMoveBounds(new Point(loc.x, loc.y + 1))){
						loc.y += 1;
						Camera.transy -= 1;
					}
					if(down && World.canMoveBounds(new Point(loc.x, loc.y - 1))){
						loc.y -= 1;
						Camera.transy += 1;
					}
					move = 0;

				}
				else
				{
					move++;
				}
			}
			if(debug) System.out.println(loc.x + " " + loc.y);
		}

	}
	public  void getInput(){
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			left = true;
		}
		else{
			left = false;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			right = true;
		}
		else{
			right = false;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			up = true;
		}
		else{
			up = false;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			down = true;
		}
		else{
			down = false;
		}

	}

}

