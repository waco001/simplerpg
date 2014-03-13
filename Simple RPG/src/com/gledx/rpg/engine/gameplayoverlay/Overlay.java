package com.gledx.rpg.engine.gameplayoverlay;

import java.awt.Font;
import java.io.InputStream;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import com.gledx.rpg.Game;
import com.gledx.rpg.engine.gameobject.Player;

public class Overlay {
	static TrueTypeFont statsFont;
	public static void init(){
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("res/fonts/C_BOX.ttf");
			
			Font inputFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			inputFont = inputFont.deriveFont(15f); // set font size
			statsFont = new TrueTypeFont(inputFont, false);
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void render() {
		{
			// save your actual projection mode
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glPushMatrix();

			// go to front in ortho mode
			GL11.glLoadIdentity();
			GL11.glOrtho(0, Game.gameWindow[0], Game.gameWindow[1], 0, -1, 1); //Strange reason orth has to be flipped
			

			// if needed save your current transformations
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glPushMatrix();

			GL11.glLoadIdentity();
			Color.white.bind();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			//Stats Overlay
			statsFont.drawString(10, 10, "Health: " + Player.health + "/" + Player.maxHealth, Color.blue);
			statsFont.drawString(10, 35, "Stamina: " + Player.stamina + "/" + Player.maxStamina, Color.magenta);
			// back to your 3D stuff
			// GL11.glEnable(GL11.GL_LIGHTING);
			// GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glPopMatrix();
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glPopMatrix();
		}
		{ // Overlay
			// save your actual projection mode
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glPushMatrix();

			// go to front in ortho mode
			GL11.glLoadIdentity();
			GL11.glOrtho(0, Game.gameWindow[0], 0, Game.gameWindow[1], -1, 1);

			// if needed save your current transformations
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glPushMatrix();

			GL11.glLoadIdentity();

			// position in the bottom left corner if needed :)
			//GL11.glTranslatef(50f, 50f, 0.0f);

			// now draw stuff

			// no depth test
			// GL11.glDisable(GL11.GL_DEPTH_TEST);
			// no lighting needed
			// GL11.glDisable(GL11.GL_LIGHTING);
			// draw a cross in center
			GL11.glLineWidth(5.0f);
			Color.white.bind();
			{
				GL11.glBegin(GL11.GL_LINES);
				GL11.glVertex2f(50.0f, 55f);
				GL11.glVertex2f(Game.gameWindow[0] - 50, 55f);
				GL11.glVertex2f(50.0f, 5f);
				GL11.glVertex2f(Game.gameWindow[0] - 50, 5f);
				GL11.glVertex2f(50.0f, 8f);
				GL11.glVertex2f(50.0f, 52f);
				GL11.glVertex2f(Game.gameWindow[0] - 50, 8f);
				GL11.glVertex2f(Game.gameWindow[0] - 50, 52f);
				GL11.glEnd();
			}
			Color.gray.bind();
			{
				GL11.glBegin(GL11.GL_QUADS);
				GL11.glVertex2f(50.0f, 8f);
				GL11.glVertex2f(50.0f, 55f);
				GL11.glVertex2f(Game.gameWindow[0] - 50, 55f);
				GL11.glVertex2f(Game.gameWindow[0] - 50, 8f);

				GL11.glEnd();
			}

			// back to your 3D stuff
			// GL11.glEnable(GL11.GL_LIGHTING);
			// GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glPopMatrix();
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glPopMatrix();
		}
	}
}
