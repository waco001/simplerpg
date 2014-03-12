package com.gledx.rpg.engine.gameobject.items;

public class ItemManager {
	public static Item nothing;
	public static String getItemByID(int ID){
		switch(ID){
		case 1:
			return "grass";
		case 0:
		default:
			return "nothing";
		}

	}
	public static int getItemByString(String itemname){
		String itemName = itemname.toLowerCase();
		switch(itemName){
		case "grass":
			return 1;
		case "nothing":
		default:
			return 0;
		}

	}
}
