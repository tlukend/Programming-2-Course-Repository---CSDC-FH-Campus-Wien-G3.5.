package at.ac.fhcampuswien;

import at.ac.fhcampuswien.ui.Menu;

public class App {
    public static void main(String[] args) {
        Menu menu = Menu.getInstance();
        menu.start();
    }
}