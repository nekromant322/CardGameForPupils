package com.company;

import com.company.bots.*;

public class Main {

    public static void main(String[] args) {
//        Game game = new Game(new AnatoliyBot(),new RomioBot());
//        Game game = new Game(new AnatoliyBot(),new KirillBot());
        Game game = new Game(new NastyaBot(),new RomioBot());
//        Game game = new Game(new AnatoliyBot(), new NastyaBot());
        game.play();
    }
}