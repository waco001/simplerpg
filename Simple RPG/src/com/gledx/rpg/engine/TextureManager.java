package com.gledx.rpg.engine;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TextureManager {
	public static Texture dirtTexture;
	public static Texture grassTexture;
	public static Texture playerTexture;
	public static Texture enemyTexture;
	public static Texture rightGrassTexture;
	public static Texture bottomGrassTexture;
	public static Texture leftGrassTexture;
	public static Texture topGrassTexture;

	public static void load(){
		try {
			{//Map Tiles
				dirtTexture = TextureLoader.getTexture("GIF", ResourceLoader.getResourceAsStream("res/tiles/dirt.gif"));
				grassTexture = TextureLoader.getTexture("GIF", ResourceLoader.getResourceAsStream("res/tiles/grass.gif"));
				
				rightGrassTexture = TextureLoader.getTexture("GIF", ResourceLoader.getResourceAsStream("res/tiles/gd2.gif"));
				leftGrassTexture = TextureLoader.getTexture("GIF", ResourceLoader.getResourceAsStream("res/tiles/gd6.gif"));
				bottomGrassTexture = TextureLoader.getTexture("GIF", ResourceLoader.getResourceAsStream("res/tiles/gd4.gif"));
				topGrassTexture = TextureLoader.getTexture("GIF", ResourceLoader.getResourceAsStream("res/tiles/gd8.gif"));
			}
			playerTexture = TextureLoader.getTexture("GIF", ResourceLoader.getResourceAsStream("res/go/player.gif"));
			enemyTexture = TextureLoader.getTexture("GIF", ResourceLoader.getResourceAsStream("res/go/enemy.gif"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
