package com.gledx.rpg.engine;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;


public class Tile {
	public static final int width = 64;
	public static final int height = 64;
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
		case "player":
			this.texture = TextureManager.playerTexture;
			break;
		}
	}
	public void render(){
		Color.white.bind();
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
		GL11.glDisable(GL11.GL_TEXTURE_2D);

	}
	public void render(int x2, int y2) {
		Color.white.bind();

		this.x = x2;
		this.y = y2;
		
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
		GL11.glDisable(GL11.GL_TEXTURE_2D);

		
	}
}
