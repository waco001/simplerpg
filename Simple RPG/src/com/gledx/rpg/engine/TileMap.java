package com.gledx.rpg.engine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TileMap {
	public static int currentMap[][];
	public static int MAP_SIZE_X;
	public static int MAP_SIZE_Y;

	public static int toTile(int x){
		return x/Tile.height;
	}
	public static int fromTile(int x){
		return x*Tile.width;
	}	
	public static void initMap(){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("res/maps/map01/tilemap.map"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		StringBuilder bigMap = new StringBuilder();
		int lineNumber = 0;
		try {
			while ((line = reader.readLine()) != null) {
				lineNumber++;
				if(lineNumber == 1)
				{
					//System.out.println(line);
					String tempLine[] = line.split(" ");
					MAP_SIZE_X = Integer.parseInt(tempLine[0]); //Width
					MAP_SIZE_Y = Integer.parseInt(tempLine[1]); //Height
					currentMap = new int[MAP_SIZE_X][MAP_SIZE_Y];
					System.out.println(MAP_SIZE_X+ " " + MAP_SIZE_Y);
				}
				if(lineNumber == 4){
					bigMap.append(line);
				}
			}
			String[] map = bigMap.toString().split(" ");
			//System.out.println("FOO");
			int x = 0;
			int y = 0;
			for(String i : map){
				if(x == MAP_SIZE_X){
					x = 0;
					y++;
				}
				//System.out.println(x + " " + y);
				currentMap[x][y] = Integer.parseInt(i);
				x++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Util.flip(currentMap); //Flip the map
	}
	public static void render(){
		for(int x = 0; x != MAP_SIZE_X ; x++){
			for(int y = 0; y != MAP_SIZE_Y ; y++){
				getTile(x, y, currentMap[x][y]).render();
			}
		}
	}
	public static Tile getTile(int x, int y, int i){
		String type;
		switch(i){
		default:
		case 0:
			type = "dirt";
			break;
		case 1:
			type = "grass";
			break;
		}
		Tile temptile = new Tile(TileMap.fromTile(x), TileMap.fromTile(y), type);
		return temptile;
	}
}
