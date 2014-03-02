package com.gledx.rpg.engine;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

public class Sprite {


	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	

	public void setX(int x) {
		this.x = World.tileToPixel(x);
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = World.tileToPixel(y);
	}

	public Sprite(int x, int y) {
		this.x = World.tileToPixel(x);
		this.y = World.tileToPixel(y);
	}

	
	public void render(){

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0,0);
		GL11.glVertex2f(x,y);
		GL11.glTexCoord2f(1,0);
		GL11.glVertex2f(x+16,y);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2f(x+16,y+16);
		GL11.glTexCoord2f(0,1);
		GL11.glVertex2f(x,y+16);
		GL11.glEnd();
		GL11.glDisable(GL11.GL_TEXTURE_2D);

		
	}
}
