package com.gledx.rpg.engine;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;


public class Tile {
	public static final int width = 32;
	public static final int height = 32;
	public int x;
	public int y;
	public Texture texture;
	public Tile(int x, int y, int type){
		this.x = x;
		this.y = y;
		switch(type){
		default:
		case 0:
			this.texture = TextureManager.dirtTexture;
			break;
		case 1:
			this.texture = TextureManager.grassTexture;
			break;
		case 4:
			this.texture = TextureManager.topGrassTexture;
			break;
		case 3:
			this.texture = TextureManager.rightGrassTexture;
			break;
		case 2:
			this.texture = TextureManager.bottomGrassTexture;
			break;
		case 5:
			this.texture = TextureManager.leftGrassTexture;
			break;
		}
	}
	public Tile(int x, int y, String type){
		this.x = x;
		this.y = y;
		switch(type){
		case "player":
			this.texture = TextureManager.playerTexture;
			break;
		case "enemy":
			this.texture = TextureManager.enemyTexture;
			break;
		}
	}
	public void render(){
		GL11.glEnable(GL11.GL_BLEND);

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
		GL11.glDisable(GL11.GL_BLEND);

	}
	public void render(int x2, int y2) {
		Color.white.bind();

		this.x = x2;
		this.y = y2;
		GL11.glEnable(GL11.GL_BLEND);

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
		GL11.glDisable(GL11.GL_BLEND);

		
	}
}
