package com.gledx.rpg.engine;

import static org.lwjgl.opengl.GL11.glTranslatef;

import java.awt.Point;
import java.awt.Rectangle;

import com.gledx.rpg.Game;

public class Camera {
	public static int transx;
	public static int transy;
	public static int x;
	public static int y;
	public static Rectangle viewport = new Rectangle();

	public static void update(){
		glTranslatef(World.tileToPixel(transx), World.tileToPixel(transy), 0);
		viewport.setBounds(x, y, Game.gameWindow[0], Game.gameWindow[1]);
		x += transx;
		y += transy;
		transx = 0;
		transy = 0;
	}
	public static boolean inView(Point point1, Point point2){
		Rectangle bounds = new Rectangle(x, y, x + Game.gameWindow[0], y + Game.gameWindow[1]);
		if(bounds.contains(point1))
			return true;
		if(bounds.contains(point2))
			return true;
		return false;
	}

}
