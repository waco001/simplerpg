package com.gledx.rpg.engine;

import static org.lwjgl.opengl.GL11.glTranslatef;

import java.awt.Point;
import java.awt.Rectangle;

import com.gledx.rpg.Game;
import com.gledx.rpg.GamePlay;
import com.gledx.rpg.engine.gameobject.Player;

public class Camera {
	public static int transx;
	public static int transy;
	public static int x = 0;
	public static int y = 0;
	public static Rectangle viewport = new Rectangle();
	public static void init(){
		//transx = (TileMap.toTile(Player.startingX) - 5);
		//transy = (TileMap.toTile(Player.startingY) - 5);
		//System.out.println());
	}
	public static void update(){
		glTranslatef(transx, transy, 0);
		viewport.setBounds(x, y, x + Game.gameWindow[0], y + Game.gameWindow[1]);
		x -= transx;
		y -= transy;
		transx = 0;
		transy = 0;
		System.out.println(TileMap.toTile(x) + " " + TileMap.toTile(y) + " / " + TileMap.toTile(GamePlay.player.getLoc().x) + " " + TileMap.toTile(GamePlay.player.getLoc().y));
	}
	public static boolean inView(Point point1){
		if(viewport.contains(point1))
			return true;
		return false;
	}

}
