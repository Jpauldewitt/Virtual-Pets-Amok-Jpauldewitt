import java.util.Scanner;

public class VirtualPetShelterApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        VirtualPetShelter myShelter = new VirtualPetShelter(15);
        Dog Argo = new Dog("Argo", "Super Cool", true, 15, 15, 15, 15, 15, 15, 15);
        Dog Spot = new Dog("Spot", "Super Lame", true, 15, 15, 15, 15, 15, 15, 15);
        Cat Kitty = new Cat("Kitty", "So Cute", true, 15, 15, 15, 15, 15, 15);
        Cat Chuckles = new Cat("Chuckles", "So hilarious", true, 15, 15, 15, 15, 15, 15);
        RoboticDog RoboDog9000 = new RoboticDog("RoboDog9000", "The first robot dog of it's kind", false, 15);
        RoboticDog RoboDog9002 = new RoboticDog("RoboDog9002", "The second robot dog of it's kind", false, 15);
        RoboticCat RoboCat9000 = new RoboticCat("RoboCat9000", "The first robot cat of it's kind", false, 15);
        RoboticCat RoboCat9002 = new RoboticCat("RoboCat9002", "The second robot cat of it's kind", false, 15);
        myShelter.addPet(Argo);
        myShelter.addPet(Spot);
        myShelter.addPet(Kitty);
        myShelter.addPet(Chuckles);
        myShelter.addPet(RoboDog9000);
        myShelter.addPet(RoboDog9002);
        myShelter.addPet(RoboCat9000);
        myShelter.addPet(RoboCat9002);
        System.out.println("     Virtual Pet Shelter:     ");
        System.out.println("            _ _         _     ");
        System.out.println("         ( `   )_    ( `  )_  ");
        System.out.println("      _(       ) `)  (  ) `)  ");
        System.out.println("    (   )                (k)  ");
        System.out.println("  (                 (O)       ");
        System.out.println("   (         (M)              ");
        System.out.println("   (   (A)        )           ");
        System.out.println("    (        )                ");
        System.out.println("   	  (   _)                  ");
        System.out.println("       )(/                    ");
        System.out.println("	   ( /)                   ");
        System.out.println("       []___                  ");
        System.out.println("      /    /\\                ");
        System.out.println("     /____/__\\               ");
        System.out.println("     |[][]||||                ");
        System.out.println();
        System.out.println("Thank you for volunteering at Sad Seggie's Virtual Pet Shelter!");
        System.out.println("Things have been getting pretty crazy around here.");
        System.out.println();
        while (VirtualPetShelter.gameOn()) {
            System.out.println("This is the status of your current pets and shelter: ");
            System.out.println();
            System.out.println("Real Dogs: ");
            myShelter.displayAttributesOfAllRealDogs();
            System.out.println();
            System.out.println("Robotic Dogs: ");
            myShelter.displayAttributesOfAllRoboticDogs();
            System.out.println();
            System.out.println("Real Cats: ");
            myShelter.displayShelterLitterBoxStatus();
            myShelter.displayAttributesOfAllRealCats();
            System.out.println();
            System.out.println("Robotic Cats: ");
            myShelter.displayAttributesOfAllRoboticCats();
            System.out.println();
            System.out.println("What would you like to do next?");
            System.out.println("1. Feed the pets");
            System.out.println("2. Give water to pets");
            System.out.println("3. Take the dogs for a walk");
            System.out.println("4. Play with a pet");
            System.out.println("5. Clean the dog cages");
            System.out.println("6. Clean the shelter litter box");
            System.out.println("7. Adopt a pet");
            System.out.println("8. Admit a pet");
            System.out.println("9. Oil the robotic pets");
            System.out.println("10. Quit");
            int userChoice = input.nextInt();
            if ((userChoice <= 0 || userChoice > 10)) {
                System.out.println("You entered: " + userChoice + ", which is not a valid option");
                myShelter.tickAllPets();
                myShelter.updateShelterLitterBox();
            }
            if (userChoice == 1) {
                System.out.println("You entered: " + userChoice + ". Feed the pets.");
                System.out.println("They are not themselves when they are hungry, but it seems like they are always hungry!");
                System.out.println();
                myShelter.tickAllPets();
                myShelter.feedAllRealPets();
                myShelter.updateShelterLitterBox();
            }
            if (userChoice == 2) {
                System.out.println("You chose: " + userChoice + ". Give water to all of the pets.");
                System.out.println("They love the virtual water, and they all seem to drinks in 3's.");
                System.out.println();
                myShelter.tickAllPets();
                myShelter.giveWaterToAllRealPets();
                myShelter.updateShelterLitterBox();
            }
            if (userChoice == 3) {
                System.out.println("You chose: " + userChoice + " Take the dogs for a walk.");
                System.out.println("They loved the walk");
                System.out.println();
                myShelter.tickAllPets();
                myShelter.walkAllDogs();
                myShelter.updateShelterLitterBox();
            }
            if (userChoice == 4) {
                System.out.println("You chose: " + userChoice + " Play with a pet");
                System.out.println();
                System.out.println("Ok, which pet would you like to play with?");
                myShelter.displayAllPetsList();
                String petUserEntered = input.next();
                while (!myShelter.pets.containsKey(petUserEntered)) {
                    System.out.println("You have entered an invalid name");
                    System.out.println("Please enter a valid name:");
                    petUserEntered = input.next();
                    myShelter.findPetByKey(petUserEntered);
                    myShelter.updateShelterLitterBox();
                }
                myShelter.playWithPet(petUserEntered);
            }
            if (userChoice == 5) {
                System.out.println("You chose: " + userChoice + " Clean the dog cages");
                System.out.println("Wow, look at those cages sparkle and shine!");
                myShelter.tickAllPets();
                myShelter.cleanAllDogsCages();
                myShelter.updateShelterLitterBox();
            }
            if (userChoice == 6) {
                System.out.println("You chose: " + userChoice + " Clean the shelter litter box");
                System.out.println("It's a tough job, but someone had to do it.");
                myShelter.tickAllPets();
                myShelter.cleanShelterLitterBox();
                myShelter.updateShelterLitterBox();
            }
            if (userChoice == 7) {
                System.out.println("You chose: " + userChoice + " Adopt a pet");
                System.out.println();
                System.out.println("Which pet would you like to adopt?");
                myShelter.displayAllPetsList();
                String petEnteredToAdopt = input.next();
                while (!myShelter.pets.containsKey(petEnteredToAdopt)) {
                    System.out.println("You have entered an invalid name");
                    System.out.println("Please enter a valid name:");
                    petEnteredToAdopt = input.next();
                    myShelter.findPetByKey(petEnteredToAdopt);
                    System.out.println("Oh no! It looks like we do not have that pet here! Please enter a valid pet name:");
                }
                if (myShelter.pets.containsKey(petEnteredToAdopt)) {
                    myShelter.pets.remove(petEnteredToAdopt);
                    myShelter.tickAllPets();
                    myShelter.updateShelterLitterBox();
                }
            }
            if (userChoice == 8) {
                System.out.println("You chose " + userChoice + ": What is your pets name that you are admitting?");
                String inputNewPet = input.next(); //skips to description if using nextLine()
                while (myShelter.pets.containsKey(inputNewPet)) {
                    System.out.println("Oh no! We already have that pet with that name. Does he have another name it goes by?");
                    inputNewPet = input.nextLine();
                }
                System.out.println("Please describe the pet that you are admitting");
                String inputNewDescription = input.next(); //skips to next section if using nextLine()
                System.out.println("Is this a Real pet, or a Robotic pet? Please enter 1 for real, or 2 for robotic: ");
                int inputRealOrRobotic = input.nextInt();
                while (inputRealOrRobotic < 1 || inputRealOrRobotic > 2) {
                    System.out.println("Please enter a valid response: Is this a Real Pet, or Robotic Pet? Please enter 1 for real, or 2 for robotic: ");
                    inputRealOrRobotic = input.nextInt();
                }
                if (inputRealOrRobotic == 1) {
                    System.out.println("Is your real pet a cat or a dog? Please enter 1 for dog, and 2 for cat: ");
                    int catOrDogResponse = input.nextInt();
                    if (catOrDogResponse < 1 || inputRealOrRobotic > 2) {
                        System.out.println("Please enter a valid response: Please enter 1 for dog, and 2 for cat:");
                        inputRealOrRobotic = input.nextInt();
                    }
                    if (catOrDogResponse == 1) {
                        Dog inputPet = new Dog(inputNewPet, inputNewDescription, true, 1, 1, 1, 1, 1, 1, 1);
                        myShelter.addPet(inputPet);
                        myShelter.tickAllPets();
                        myShelter.updateShelterLitterBox();
                    }
                    if (catOrDogResponse == 2) {
                        Cat inputPet = new Cat(inputNewPet, inputNewDescription, true, 1, 1, 1, 1, 1, 1);
                        myShelter.addPet(inputPet);
                        myShelter.tickAllPets();
                        myShelter.updateShelterLitterBox();
                    }
                }
                if (inputRealOrRobotic == 2) {
                    System.out.println("Is your robotic pet a cat or a dog? Please enter 1 for dog, and 2 for cat: ");
                    int roboticCatOrDogResponse = input.nextInt();
                    if (roboticCatOrDogResponse < 1 || roboticCatOrDogResponse > 2) {
                        System.out.println("Please enter a valid response: Please enter 1 for dog, and 2 for cat:");
                        roboticCatOrDogResponse = input.nextInt();
                    }
                    if (roboticCatOrDogResponse == 1) {
                        RoboticDog inputPet = new RoboticDog(inputNewPet, inputNewDescription, false, 1);
                        myShelter.addPet(inputPet);
                        myShelter.tickAllPets();
                        myShelter.updateShelterLitterBox();
                    }
                    if (roboticCatOrDogResponse == 2) {
                        RoboticCat inputPet = new RoboticCat(inputNewPet, inputNewDescription, false, 1);
                        myShelter.addPet(inputPet);
                        myShelter.tickAllPets();
                        myShelter.updateShelterLitterBox();
                    }
                }
            }
            if (userChoice == 9) {
                System.out.println("You chose: " + userChoice + " Oil all robotic pets");
                System.out.println("They are all lubed up!");
                myShelter.tickAllPets();
                myShelter.oilAllRoboticPets();
                myShelter.updateShelterLitterBox();
            }
            if (userChoice == 10) {
                System.out.println("You chose: " + userChoice + ". Quit");
                System.out.println("   _____          __  __ ______ ______      ________ _____ ");
                System.out.println("  / ____|   /\\   |  \\/  |  ____/ __ \\ \\    / /  ____|  __ \\");
                System.out.println(" | |  __   /  \\  | \\  / | |__ | |  | \\ \\  / /| |__  | |__) |");
                System.out.println(" | | |_ | / /\\ \\ | |\\/| |  __|| |  | |\\ \\/ / |  __| |  _  / ");
                System.out.println(" | |__| |/ ____ \\| |  | | |___| |__| | \\  /  | |____| | \\ \\ ");
                System.out.println("  \\_____/_/    \\_\\_|  |_|______\\____/   \\/   |______|_|  \\_\\");
                System.out.println("");
                System.out.println("Fine! Quit! Just like that. It's over.");
                System.exit(0);
            }
        }
    }
}

