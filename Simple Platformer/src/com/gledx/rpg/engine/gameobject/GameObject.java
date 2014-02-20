package com.gledx.rpg.engine.gameobject;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;

import java.awt.Point;

import com.gledx.rpg.engine.Sprite;


public abstract class GameObject {
	protected Point loc;
	protected Sprite spr;
	protected boolean debug = false;
	public GameObject(int x, int y, float r, float g, float b){
		this.loc = new Point();
		this.loc.x = x;
		this.loc.y = y;
		//this.spr = new Sprite(x, y, r, g, b);
	}
	public void render(){
		glPushMatrix();
		{
			//glTranslatef(this.loc.x, this.loc.y, 0);
			spr.render();
		}
		glPopMatrix();
	}
	public void update(){
		
	}
	public void getInput() {
		// TODO Auto-generated method stub
		
	}
}
