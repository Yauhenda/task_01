package com.epum.primisen.task_01.menu;

import java.util.HashMap;

public class Menu {

    private String descriptionOfMenu;
    private HashMap<Integer, String> gameList;
    private int numberOfGame;

    public Menu(){
        gameList = new HashMap<Integer, String>();
    }

    public String getDescriptionOfMenu() {
        return descriptionOfMenu;
    }

    public void setDescriptionOfMenu(String descriptionOfMenu) {
        this.descriptionOfMenu = descriptionOfMenu;
    }

    public HashMap<Integer, String> getGameList() {
        return gameList;
    }

    public void setGameList(HashMap<Integer, String> gameList) {
        this.gameList = gameList;
    }

    public void setGameList(String game) {
        Integer key = (Integer)gameList.size() + 1;
        this.gameList.put(key, game);
    }

    public int getNumberOfGame() {
        return gameList.size();
    }

}
