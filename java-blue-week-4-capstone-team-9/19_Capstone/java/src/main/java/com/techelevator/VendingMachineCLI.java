package com.techelevator;

import com.techelevator.data.Logger;
import com.techelevator.data.ProductDaoFile;
import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.techelevator.data.Logger.*;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase"; //one of the options
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    //initializing each one of the options

    private Menu menu;

    private  Customer customer;

    private VendingManager vendingManager;

    //(1) Feed Money
    //(2) Select Product
    //(3) Finish Transaction
    //
    // Current Money Provided: $2.00

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                System.out.println(vendingManager.getVendingMachineItems());
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                purchaseMenu();
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
               Logger.close();
                System.exit(0);
            }
        }
    }

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product"; //one of the options
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

    private void purchaseMenu() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
            Scanner userSelectionScanner = new Scanner(System.in);
            if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                System.out.println("Please feed money in whole dollar amounts (1.00, 2.00, 5.00, or 10.00): ");
                String userSelection = userSelectionScanner.next();
              ;  vendingManager.feedMoney(new BigDecimal(userSelection))
                writeMessage(customer, new BigDecimal(userSelection));
            }
            if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                System.out.println("Select your snack option!");
                String userSelection = userSelectionScanner.next();
/*                    if (vendingManager.getPrice(userSelection).compareTo(vendingManager.getWallet()) == 1) {
                        System.out.println("You do not have enough money in your wallet...");
                    } else */
                if (vendingManager.isSoldOut(userSelection)) {
                    System.out.println("That item is out of stock!");
                } else if (!vendingManager.productExists(userSelection)) {
                    System.out.println("That item does not exist!");
                } else if (!vendingManager.isSoldOut(userSelection) && vendingManager.productExists(userSelection)) {
                    System.out.println(vendingManager.purchaseItem(userSelection));
                    writeMessage(vendingManager.getProduct(userSelection), customer);
                }

            }
            if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                vendingManager.finishTransaction();
                writeMessage(customer);
                return;
            }

        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        Logger.open();

        cli.customer = new Customer();
        cli.vendingManager = new VendingManager(ProductDaoFile.loadProductData("vendingmachine.csv", "\\|"), cli.customer);
        cli.run();
    }


}
// System.out.println("Current Money Provided: " + vendingManager.getWallet());
//notes for Cailey: Working on getting the log running, also running into an issue with the wallet not accurately updating money fed into the wallet