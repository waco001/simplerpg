package com.gledx.rpg.engine;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TexturedGameTile {
	public int tileNumber;
	public Texture tileTexture;
	public TexturedGameTile(String id, String filename){
		this.tileNumber = Integer.parseInt(id);
		
		try {
			tileTexture = TextureLoader.getTexture("gif",  ResourceLoader.getResourceAsStream(System.getProperty("user.dir") + "/res/tiles/" + filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
