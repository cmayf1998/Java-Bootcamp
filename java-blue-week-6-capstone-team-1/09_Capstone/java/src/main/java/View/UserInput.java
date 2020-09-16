package View;

import Model.*;
import org.springframework.cglib.core.Local;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserInput {

    private Menu menu;

    private ParkDAO parkDAO;

    private Park currentPark;

    public UserInput(ParkDAO parkDAO) {
        this.parkDAO = parkDAO;
        this.menu = new Menu(System.in, System.out);
    }

    //1) Browse Parks
    //2) Search by date
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";

    private static final String MENU_OPTION_RETURN_TO_MAIN = "Return to main menu";
//once park is selected, display info about that Park. Then new menu specific to that park
    //1) Park 1
    //2) Park 2

    private static final String CAMPGROUND_MENU_OPTION_ALL_CAMPGROUNDS = "View campgrounds";
    private static final String CAMPGROUND_MENU_OPTION_SEARCH_FOR_RESERVATION = "Search for Reservation";
    private static final String CAMPGROUND_MENU_OPTION_RETURN_TO_MAIN = "Return to Main Menu";

    private static final String[] CAMPGROUND_MENU_OPTIONS = new String[]{CAMPGROUND_MENU_OPTION_ALL_CAMPGROUNDS,
            CAMPGROUND_MENU_OPTION_SEARCH_FOR_RESERVATION,
            CAMPGROUND_MENU_OPTION_RETURN_TO_MAIN};

    private static final String RESERVATION_MENU_OPTION_INPUT_DATES = "Input Reservation Dates";
    private static final String RESERVATION_MENU_OPTION_RETURN_TO_MAIN = "Return to Main Menu";

    private static final String[] RESERVATION_MENU_OPTIONS = new String[]{RESERVATION_MENU_OPTION_INPUT_DATES,
            RESERVATION_MENU_OPTION_RETURN_TO_MAIN};

    private String[] getParkNameMenuOptions(){
        List<Park> parkList = parkDAO.getAllParks();
        String[] parkNameOptions = new String[parkList.size()+1];
        for (int i=0; i<parkList.size(); i++){
            parkNameOptions[i] = parkList.get(i).getName();
        }
        parkNameOptions[parkList.size()] = MAIN_MENU_OPTION_EXIT;
        return parkNameOptions;
    }

    private void setCurrentPark(String choice){
        List<Park> parkList = parkDAO.getAllParks();
        for (Park value : parkList){
            if (value.getName().equals(choice)){
                currentPark = value;
                return;
            }
        }
    }

    public void run() {
        while (true) {
            printHeading("Main Menu");
            String choice = (String) menu.getChoiceFromOptions(getParkNameMenuOptions());
            if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                System.exit(0);
                ;
            }
            // Set the currentPark by matching the choice with a Park name in your parkList
            setCurrentPark(choice);
            // Display the Park info to the screen
            System.out.println(currentPark);
            // Display next menu
            campgroundMenu();
        }
    }

    public void campgroundMenu() {
        while (true) {
            printHeading("Campgrounds");
            String choice = (String) menu.getChoiceFromOptions(CAMPGROUND_MENU_OPTIONS);
            List<Campground> campgroundsInPark = parkDAO.getAllCampgrounds(currentPark.getParkId());
            if (choice.equals(CAMPGROUND_MENU_OPTION_ALL_CAMPGROUNDS)) {
                for (Campground campground : campgroundsInPark) {
                    System.out.println(campground);
                }

            } else if (choice.equals(CAMPGROUND_MENU_OPTION_SEARCH_FOR_RESERVATION)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the number of the campground you'd like to search (Enter 0 to cancel):");
                int campgroundChoice = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter your date of arrival (yyyy-mm-dd): ");
                LocalDate arrivalDate = LocalDate.parse(scanner.nextLine());
//                String date = new Scanner(System.in).nextLine();
//                SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
//                Date arrivalDate = format.parse(date);

                System.out.println("Enter your date of departure (yyyy-mm-dd):");
                LocalDate departureDate = LocalDate.parse(scanner.nextLine());

                if (campgroundChoice > 0 ) { // && the number the user put in is actually an option
                    parkDAO.reservationSearch(campgroundChoice, arrivalDate, departureDate);
                    List<Site> availableSites = parkDAO.reservationSearch(campgroundChoice, arrivalDate, departureDate);
                    for (Site site : availableSites) {
                        System.out.println(site);
                    }
                } else if (campgroundChoice == 0)    {
                    System.exit(0);
                }

            } else if (choice.equals(CAMPGROUND_MENU_OPTION_RETURN_TO_MAIN)) {
                return;
            }
        }
    }

    public void reservationMenu() {
        while (true) {
            printHeading("Campgrounds");
            String choice = (String) menu.getChoiceFromOptions(RESERVATION_MENU_OPTIONS);
//            if (choice.equals(RESERVATION_MENU_OPTION_INPUT_DATES)) {
//                parkDAO.reservationSearch();
//            }
        }
    }

    private void printHeading(String headingText) {
        System.out.println("\n"+headingText);
        for(int i = 0; i < headingText.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }



}
