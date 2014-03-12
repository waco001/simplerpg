package com.gledx.rpg.engine.gameplayoverlay;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Display;
import org.newdawn.slick.Color;

import com.gledx.rpg.Game;

public class Overlay {
	public static void render() {
		{ //Cross hairs
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
			GL11.glTranslatef(Game.gameWindow[0] / 2, Game.gameWindow[1] / 2, 0.0f);

			// now draw stuff

			// no depth test
			// GL11.glDisable(GL11.GL_DEPTH_TEST);
			// no lighting needed
			// GL11.glDisable(GL11.GL_LIGHTING);
			// draw a cross in center
			GL11.glLineWidth(1.5f);
			Color.blue.bind();
			{
				GL11.glBegin(GL11.GL_LINES);
				GL11.glVertex2f(0.0f, 50f);
				GL11.glVertex2f(0.0f, -50f);
				GL11.glVertex2f(-50f, 0.0f);
				GL11.glVertex2f(50f, 0.0f);
			}
			GL11.glEnd();

			// back to your 3D stuff
			// GL11.glEnable(GL11.GL_LIGHTING);
			// GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glPopMatrix();
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glPopMatrix();
		}
		/*{ // Overlay
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
		}*/
	}
}
