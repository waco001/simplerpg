package com.gledx.rpg;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.gledx.rpg.engine.World;

public class Game {
	public enum gamestate {GAME_EXIT, GAME_LOAD, GAME_MENU, GAME_PLAY, GAME_MENU_INFO};
	public static gamestate gameState = gamestate.GAME_LOAD;
	public static int[] gameWindow = {640, 480};
	public static final int frameRate = 60;
	private static boolean fullscreen = false;
	private static String gameTitle = "Game Title";
	private static boolean vsync = true;
	private static boolean resizable = false;
	private static boolean mouseGrab = false;
	public static void main(String args[]){
		Game game = new Game();
		game.run();
		game = null;
	}
	public Game(){

	}
	private void run(){
		load();
		gameLoop();
		unload();
	}
	private void unload() {
		// TODO Auto-generated method stub
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
	}
	private void load() {
		try {
			System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/lib/");
			Display.setDisplayMode(new DisplayMode(gameWindow[0], gameWindow[1]));
			Display.setFullscreen(fullscreen);
			Display.setTitle(gameTitle);
			Display.setInitialBackground(0.0f, 0.0f, 0.7f);
			Display.setVSyncEnabled(vsync);
			Display.setResizable(resizable);
			Mouse.setGrabbed(mouseGrab);
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		{
			//Setup screen with 0,0 at bottom left
			//Clear Screen
			glClear(GL_COLOR_BUFFER_BIT);
			//set up matrix
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(0, gameWindow[0], 0, gameWindow[1], -1, 1);

			//Modify modelview matrix
			glMatrixMode(GL_MODELVIEW);

			glLoadIdentity();

		}
		{// Load Everything Else
			World.loadMap();
			GamePlay.init();
		}

		gameState = gamestate.GAME_PLAY;

	}
	private void gameLoop() {
		// TODO Auto-generated method stub
		while(gameState != gamestate.GAME_EXIT){
			switch(gameState){
			case GAME_PLAY:
			{ //Call Updates
				GamePlay.update();
			}
			{ // Call Renders
				GamePlay.render();
			}
			{ //Call Inputs
				//GamePlay.getInput();
			}
			break;
			default:
				Display.update();
				Display.sync(Game.frameRate);
				break;
			}
			{ //Check if need to end game
				if(Display.isCloseRequested())
					gameState = gamestate.GAME_EXIT;
				if(!(Display.isActive())){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				while(Keyboard.next()){
					System.out.println("POO");
					if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
						gameState = gamestate.GAME_EXIT;
					}
				}

			}
		}
	}
}