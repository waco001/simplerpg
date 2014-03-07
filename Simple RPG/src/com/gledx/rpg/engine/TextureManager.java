package com.gledx.rpg.engine;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TextureManager {
	public static Texture dirtTexture;
	public static Texture grassTexture;
	public static void load(){
		try {
			dirtTexture = TextureLoader.getTexture("GIF", ResourceLoader.getResourceAsStream("res/tiles/dirt.gif"));
			grassTexture = TextureLoader.getTexture("GIF", ResourceLoader.getResourceAsStream("res/tiles/grass.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
