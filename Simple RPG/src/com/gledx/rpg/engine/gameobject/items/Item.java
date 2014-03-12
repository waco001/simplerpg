package com.gledx.rpg.engine.gameobject.items;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Item {
	public int ID;
	public Texture IMAGE;
	public String NAME;
	public Item(int ID, String itemName, String pathToImage){
		this.ID = ID;
		this.NAME = itemName;
		try {
			this.IMAGE = TextureLoader.getTexture("GIF", ResourceLoader.getResourceAsStream(pathToImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
