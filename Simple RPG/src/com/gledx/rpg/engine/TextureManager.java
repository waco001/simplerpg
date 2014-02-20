package com.gledx.rpg.engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class TextureManager {
	public static ArrayList<TexturedGameTile> tileImages = new ArrayList<TexturedGameTile>();
	public static void loadMap(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/res/tiles/tileData.dat"));
			String line = br.readLine();
			int lines = 0;
			while(line != null){
				lines++;
				line = br.readLine();
				//System.out.println(line);
				if(lines >= 3 && line != null){
					String[] lineData;
					lineData = line.split(", ");
					//System.out.println(lineData.toString());
					tileImages.add(new TexturedGameTile(lineData[0], lineData[1]));
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static int getTextureByID(int ID){
		int i = 0;
		for(TexturedGameTile t: tileImages){
			if(t.tileNumber == ID){
				i = t.tileTexture.getTextureID();
				//System.out.println(i);
			}
		}
		return i;
	}
}
