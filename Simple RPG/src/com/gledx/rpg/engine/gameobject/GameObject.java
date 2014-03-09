package com.gledx.rpg.engine.gameobject;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;

import java.awt.Point;

import com.gledx.rpg.engine.Tile;


public abstract class GameObject {
	protected Point loc;
	public Point getLoc() {
		return loc;
	}
	protected Tile tile;
	protected boolean debug = false;
	public GameObject(int x, int y, String objectTexture){
		this.loc = new Point();
		this.loc.x = x;
		this.loc.y = y;
		tile = new Tile(x, y, objectTexture);
	}
	public void render(){
		glPushMatrix();
		{
			//glTranslatef(this.loc.x, this.loc.y, 0);
			tile.render(loc.x, loc.y);
		}
		glPopMatrix();
		//System.out.println("TEST ");
	}
	public void update(){
		
	}
	public void getInput() {
		// TODO Auto-generated method stub
		
	}
}
