package com.techelevator.view;

import com.techelevator.biz.ParkManager;
import com.techelevator.entity.Campground;
import com.techelevator.entity.Park;
import com.techelevator.log.Logger;

import java.util.List;

public class UserInput {

    private ParkManager parkManager;

    private List<Park> parks;

    private Menu menu;

    public UserInput(ParkManager parkManager){
        this.parkManager = parkManager;
        this.menu = new Menu(System.in, System.out);
    }

    public void run() {
        while(true) {
            printHeading("Main Menu");

            String choice = (String)menu.getChoiceFromOptions(
                    getMenuOptionsParkNames());

            if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
                Logger.closeLogger();
                System.exit(0);
            }
            if (setSelectedPark(choice) ) {
                displayParkInfo();
                displayParkMenu();
            }
        }
    }

    /*
     * Main Menu Options
     */

    private static final String MAIN_MENU_OPTION_EXIT = "Exit";

    private String[] getMenuOptionsParkNames() {
        parks = parkManager.getParks(false);
        if (parks == null){
            System.out.println("Error... no parks returned!");
            System.exit(1);
        }
        String[] menuOptions = new String[parks.size()+1];
        for (int i=0; i<parks.size(); i++){
            menuOptions[i] = parks.get(i).getName();
        }
        menuOptions[parks.size()] = MAIN_MENU_OPTION_EXIT;
        return menuOptions;
    }

    private boolean setSelectedPark(String choice){
        // choice represents the selected Park
        for (Park park : parks){
            if (park.getName().equals(choice)){
                parkManager.setSelectedPark(park);
                return true;
            }
        }
        return false;
    }

    private void displayParkInfo() {
        printHeading("Park Information");
        System.out.println(parkManager.getSelectedPark());
    }

    /*
     * Selected Park Menu Options
     */
    private static final String PARK_MENU_OPTION_VIEW_CAMPGROUNDS = "View Campgrounds";
    private static final String PARK_MENU_OPTION_RESERVATIONS = "Search for Reservation";
    private static final String PARK_MENU_OPTION_RETURN = "Return to Previous Screen";
    private static final String[] PARK_MENU_OPTIONS = new String[] {
            PARK_MENU_OPTION_VIEW_CAMPGROUNDS,
            PARK_MENU_OPTION_RESERVATIONS,
            PARK_MENU_OPTION_RETURN };

    private void displayParkMenu(){
        while (true) {
            printHeading(parkManager.getSelectedPark().getName() + " Menu");
            String choice = (String) menu.getChoiceFromOptions(PARK_MENU_OPTIONS);
            if (choice.equals(PARK_MENU_OPTION_VIEW_CAMPGROUNDS)) {
                displayCampgrounds();
            } else if (choice.equals(PARK_MENU_OPTION_RESERVATIONS)) {
                handleReservations();
            } else if (choice.equals(PARK_MENU_OPTION_RETURN)) {
                return;
            }
        }

    }

    private void displayCampgrounds(){
        printHeading(parkManager.getSelectedPark().getName() + " Campgrounds");
        List<Campground> campgroundList = parkManager.getCampgrounds(false);
        for (Campground value : campgroundList){
            System.out.println(value + "\n");
        }
    }

    private void handleReservations() {

    }

    private void printHeading(String headingText) {
        System.out.println("\n"+headingText);
        for(int i = 0; i < headingText.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
