package com.gledx.rpg.engine;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;


public class Tile {
	public static final int width = 32;
	public static final int height = 32;
	public int x;
	public int y;
	public Texture texture;
	public Tile(int x, int y, String type){
		this.x = x;
		this.y = y;
		switch(type){
		case "dirt":
			this.texture = TextureManager.dirtTexture;
			break;
		case "grass":
			this.texture = TextureManager.grassTexture;
			break;
		}
	}
	public void render(){
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		texture.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0,0);
		GL11.glVertex2f(x, y);
		GL11.glTexCoord2f(1,0);
		GL11.glVertex2f(x+width, y);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2f(x+width, y+height);
		GL11.glTexCoord2f(0,1);
		GL11.glVertex2f(x, y+height);
		GL11.glEnd();
	}
}
