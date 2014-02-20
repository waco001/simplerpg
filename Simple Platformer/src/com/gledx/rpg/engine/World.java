package com.gledx.rpg.engine;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


public class World {
	public static int MAP_X = 40; //In tiles
	public static int MAP_Y = 30;
	public static final int MAP_TILE_SIZE = 16;
	Rectangle viewport;
	public static final int[][] map = new int[MAP_X][MAP_Y];

	public World(){
		viewport = new Rectangle(0, 0, tileToPixel(MAP_X), tileToPixel(MAP_Y));
	}
	public static void render(){
		Sprite spr;
		for(int x = 0; x <= (MAP_X-1); x++){
			for(int y = 0; y <= (MAP_Y-1); y++){

				switch(map[x][y]){
				case 1:
					spr = new Sprite(x, y, 1);
					spr.render();
					break;
				case 0:
				default:
					spr = new Sprite(x, y, 2);
					spr.render();
					break;
				}

			}
		}
	}
	public static void loadMap(){ //Int array is put to 0 if not set...
		TextureManager.loadMap();
		try {
			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/res/tiles/tileData.dat"));
			String line = br.readLine();
			MAP_X = Integer.parseInt(line.split(" ")[0]);
			MAP_Y = Integer.parseInt(line.split(" ")[1]);
			int lines = 1;
			while(line != null){
				lines++;
				line = br.readLine();
				if(lines == 4 && line != null){
					String[] tileData = line.split(" ");
					int yvalue = 0;
					while(yvalue < MAP_Y){
						for(int k = 0; k > MAP_X; k++){
							map[k][yvalue] = Integer.parseInt(tileData[k]);
						}
						yvalue++;
					}
				}
			}
			System.out.println(MAP_X + " " + MAP_Y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int pixelToTile(int x){
		return (x / MAP_TILE_SIZE);
	}
	public static int tileToPixel(int x){
		return (x * MAP_TILE_SIZE);
	}
	public static boolean isBlockType(int x, int y, int blockType){
		if(map[x][y] == blockType)
			return true;
		return false;
	}
	public static boolean canMoveBounds(Point loc){
		if(loc.x == 0)
			return false;
		if(loc.x == MAP_X - 1)
			return false;
		if(loc.y == 0)
			return false;
		if(loc.y == MAP_Y - 1)
			return false;

		return true;
	}
}
