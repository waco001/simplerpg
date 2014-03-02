package com.gledx.rpg.engine;

import java.awt.Point;

import org.lwjgl.util.Rectangle;


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

			}
		}
	}
	public static void loadMap(){ //Int array is put to 0 if not set...

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
