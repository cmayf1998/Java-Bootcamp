package com.techelevator.view;

import com.techelevator.biz.VendingManager;

import java.util.Scanner;

public class UserInput {

    private Menu menu;

    private Scanner scanner;

    private VendingManager manager;

    public UserInput(VendingManager manager){
        this.manager = manager;
        menu = new Menu(System.in, System.out);
        scanner = new Scanner(System.in);
    }

    /*
     * Main Menu
     */
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {
            MAIN_MENU_OPTION_DISPLAY_ITEMS,
            MAIN_MENU_OPTION_PURCHASE,
            MAIN_MENU_OPTION_EXIT};

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // go to submenu
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                // Exit program
                System.exit(0);
            }
        }
    }

    /*
     * Purchase Menu
     */
    private static final String PURCHASE_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String PURCHASE_MENU_OPTION_PURCHASE = "Purchase";
    private static final String PURCHASE_MENU_OPTION_EXIT = "Exit";
    private static final String[] PURCHASE_MENU_OPTIONS = {
            PURCHASE_MENU_OPTION_DISPLAY_ITEMS,
            PURCHASE_MENU_OPTION_PURCHASE,
            PURCHASE_MENU_OPTION_EXIT};
}
