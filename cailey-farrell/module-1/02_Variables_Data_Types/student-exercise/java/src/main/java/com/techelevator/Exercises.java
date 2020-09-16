package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfBirdsMoreThanNests = numberOfBirds - numberOfNests;

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */

		int numberOfRacoonsPlayingInWoods = 3;
		int numberOfRacoonsGoToDinner = 2;
		int numberOfRacoonsLeft = numberOfRacoonsPlayingInWoods - numberOfRacoonsGoToDinner;
		System.out.println(numberOfRacoonsLeft);

        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */

		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int beesLessThanFlowers = numberOfFlowers - numberOfBees;

        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */

		int lonelyPigeon = 1;
		int anotherPigeon = 1;
		int totalPigeon = lonelyPigeon + anotherPigeon;

        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */

		int owlsOnFence = 3;
		int moreOwls = 2;
		int totalOwlsOnFence = owlsOnFence + moreOwls;

        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */

		int beaversWorkingOnHome = 2;
		int beaverSwim = 1;
		int totalBeaversStillWorkingOnHome = beaversWorkingOnHome - beaverSwim;

        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */

		int toucansOnTree = 2;
		int toucansThatJoin = 1;
		int totalToucan = toucansOnTree + toucansThatJoin;

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */

		int squirrelsInATree = 4;
		int nutsInTree = 2;
		int squirrlesMoreThanNuts = squirrelsInATree - nutsInTree;

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */

		double quarterValue = .25;
		double dimeValue = .10;
		double nickelValue = .05;
		int amountOfNickels = 2;
		double moneyTotal = (quarterValue + dimeValue + nickelValue * amountOfNickels);
		System.out.println(moneyTotal);

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */

		int briersMuffins = 18;
		int macadamsMuffins = 20;
		int flannerysMuffins = 17;
		int totalMuffins = briersMuffins + macadamsMuffins + flannerysMuffins;

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */

		double priceOfYoyo = 0.24;
		double priceOfWhistle = 0.14;
		double totalPriceOfToys = priceOfYoyo + priceOfWhistle;
		System.out.println(totalPriceOfToys);

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */

		int largeMarshmallows = 8;
		int miniMarshmallows = 10;
		int totalMarshmallows = largeMarshmallows + miniMarshmallows;

        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */

		int snowHiltsHouse = 29;
		int snowBrecknock = 17;
		int moreSnowHiltsHouse = snowHiltsHouse - snowBrecknock;
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */

		int moneyToStart = 10;
		int priceToyTruck = 3;
		int pricePencilCase = 2;
		int moneyLeft = moneyToStart - priceToyTruck - pricePencilCase;

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */

		int totalMarbles = 16;
		int lostMarbles = 7;
		int marblesLeft = totalMarbles - lostMarbles;

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */

		int meganSeashells = 19;
		int targetAmountSeashells = 25;
		int seashellsToAdd = targetAmountSeashells - meganSeashells;

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */

		int totalBalloons = 17;
		int redBalloons = 8;
		int greenBalloons = totalBalloons - redBalloons;

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */

		int booksInitialAmount = 38;
		int booksAdded = 10;
		int totalBooks = booksInitialAmount + booksAdded;
		System.out.println(totalBooks);


        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */

		int legsPerBee = 6;
		int numberOfBeesWithLegs = 8;
		int totalLegs = legsPerBee * numberOfBeesWithLegs;

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */

		double pricePerCone = .99;
		int numberOfCones = 2;
		double priceOfTwoCones = pricePerCone * numberOfCones;
		System.out.println(priceOfTwoCones);

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */

		int totalRocksForBorder = 125;
		int rocksHiltHas = 64;
		int moreRocksNeeded = totalRocksForBorder - rocksHiltHas;

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */

		int hiltMarbles = 38;
		int hiltLostMarbles = 15;
		int hiltMarblesLeft = hiltMarbles - hiltLostMarbles;
		System.out.println(hiltMarblesLeft);
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */

		int milesToConcert = 78;
		int milesToGas = 32;
		int milesLeftToDrive = milesToConcert - milesToGas;
		System.out.println(milesLeftToDrive);

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */

		int minsShovelingSnowSatMorning = 90;
		int minsShovelingSnowSatAfternoon = 45;
		int totalMinsShovelingSnow = minsShovelingSnowSatMorning + minsShovelingSnowSatAfternoon;

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */

		int numberOfHotdogsHiltBought = 6;
		double priceOfHotdog = .50;
		double moneyHiltSpentOnHotdogs = numberOfHotdogsHiltBought * priceOfHotdog;
		System.out.println(moneyHiltSpentOnHotdogs);

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */

		int hiltMoneyTotal = 50;
		int pricePerPencil = 7;
		int numberOfPencilsHiltCanBuy = hiltMoneyTotal / pricePerPencil;
		System.out.println(numberOfPencilsHiltCanBuy);


        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */

		int numberOfButterfliesHiltSaw = 33;
		int orangeButterflies = 20;
		int redButterflies = numberOfButterfliesHiltSaw - orangeButterflies;
		System.out.println(redButterflies);

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */

		double moneyKateGave = 1.00;
		double priceOfCandy = .54;
		double kateChange = moneyKateGave - priceOfCandy;
		System.out.println(kateChange);

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */

		int treesBackyard = 13;
		int plantMoreTrees = 12;
		int markTotalTrees = treesBackyard + plantMoreTrees;
		System.out.println(markTotalTrees);

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */

		int daysUntilJoySeesGrandma = 2;
		int hoursPerDay = 24;
		int hoursUntilJoySeesGrandma = hoursPerDay * daysUntilJoySeesGrandma;
		System.out.println(hoursUntilJoySeesGrandma);
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */

		int kimNumberOfCousins = 4;
		int gumPerCousin = 5;
		int gumNeeded = kimNumberOfCousins * gumPerCousin;
		System.out.println(gumNeeded);
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */

		double danMoney = 3.00;
		double priceCandybar = 1.00;
		double danMoneyLeft = danMoney - priceCandybar;
		System.out.println(danMoneyLeft);

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */

		int boatsInLake = 5;
		int peoplePerBoat = 3;
		int peopleonBoatsInLake = boatsInLake * peoplePerBoat;
		System.out.println(peopleonBoatsInLake);

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */

		int legosToStart = 380;
		int legosLost = 57;
		int legosLeft = legosToStart - legosLost;
		System.out.println(legosLeft);

        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */

		int muffinsBakedFirst = 35;
		int muffinsDesired = 83;
		int muffinsNeededToBake = muffinsDesired - muffinsBakedFirst;
		System.out.println(muffinsNeededToBake);

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */

		int willyCrayons = 1400;
		int lucyCrayons = 290;
		int moreCrayonsWillyHasThanLucy = willyCrayons - lucyCrayons;
		System.out.println(moreCrayonsWillyHasThanLucy);

        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */

		int stickersPerPage = 10;
		int stickerPages = 22;
		int totalStickers = stickersPerPage * stickerPages;
		System.out.println(totalStickers);

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */

		int totalCupcakes = 96;
		int childrenWhoWantCupcakes = 8;
		int cupcakesPerChild = totalCupcakes / childrenWhoWantCupcakes;
		System.out.println(cupcakesPerChild);

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */

		int totalGingerbreakCookies = 47;
		int cookiesPerJar = 6;
		int cookiesNotPlacedInJar = totalGingerbreakCookies % cookiesPerJar;
		System.out.println(cookiesNotPlacedInJar);

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */

		int totalCroissants = 59;
		int neighbors = 8;
		int leftoverCroissants = totalCroissants % neighbors;
		System.out.println(leftoverCroissants);
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */

		int cookiesPerTray = 12;
		int cookiesDesired = 276;
		int traysNeeded = cookiesDesired / cookiesPerTray;
		System.out.println(traysNeeded);
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */

		int totalBiteSizedPretzels = 480;
		int pretzelsPerServing = 12;
		int numberOfServings = totalBiteSizedPretzels / pretzelsPerServing;
		System.out.println(numberOfServings);
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */

		int totalLemonCupcakes = 53;
		int lemonCupcakesForgotten = 2;
		int boxesGivenAway = (totalLemonCupcakes - lemonCupcakesForgotten) / 3;
		System.out.println(boxesGivenAway);
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */

		int totalCarrotSticks = 74;
		int peopleServedCarrots = 12;
		int carrotSticksLeftOver = 74 % 12;
		System.out.println(carrotSticksLeftOver);
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */

		int totalTeddyBears = 98;
		int teddyBearPerShelf = 7;
		int shelvesFilled = totalTeddyBears / teddyBearPerShelf;
		System.out.println(shelvesFilled);
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */

		int picturesPerAlbum = 20;
		int totalPictures = 480;
		int totalAlbums = totalPictures / picturesPerAlbum;
		System.out.println(totalAlbums);
        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */

		int totalTradingCards = 94;
		int cardsPerBox = 8;
		int boxesFilled = totalTradingCards / cardsPerBox;
		int cardsInUnfilledBox = totalTradingCards % cardsPerBox;
		System.out.println(boxesFilled);
		System.out.println(cardsInUnfilledBox);

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */

		int totalBooksReadingRoom = 210;
		int shelves = 10;
		int booksPerShelf = totalBooksReadingRoom / shelves;
		System.out.println(booksPerShelf);
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */

		int cristinaTotalCroissants = 17;
		int totalGuests = 7;
		int croissantsPerGuest = cristinaTotalCroissants / totalGuests;
		System.out.println(croissantsPerGuest);

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */

		int dimension1 = 12;
		int dimension2 = 14;
		int roomSize = dimension1 * dimension2;
		double billTime = 2.15;
		double jillTime = 1.90;
		double billRatePerHour = roomSize / billTime;
		double jillRatePerHour = roomSize / jillTime;
		double totalRatePerHour = billRatePerHour + jillRatePerHour;
		int totalWallsInFeet = 5 * roomSize;
		double lengthOfTime = totalWallsInFeet / totalRatePerHour;
		System.out.println(lengthOfTime);




        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
		{

			{
				String firstName = "Cailey";
				String lastName = "Farrell, ";
				String middleInitial = " M.";
				String fullName = lastName + firstName + middleInitial;
				System.out.println(fullName);

			}
		}

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */

		float distance = 800;
		float distanceTrain = 537;
		float percentageTraveled = (distanceTrain / distance)*100;
		System.out.println(percentageTraveled);

	}
}


