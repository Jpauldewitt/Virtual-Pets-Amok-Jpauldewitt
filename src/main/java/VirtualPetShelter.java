import java.util.*;

public class VirtualPetShelter {
    private int shelterLitterBoxLevel;

    public VirtualPetShelter(int shelterLitterBoxLevel) {
        this.shelterLitterBoxLevel = shelterLitterBoxLevel;
    }

    public int getShelterLitterBoxLevel() {
        return shelterLitterBoxLevel;
    }


    public void displayShelterLitterBoxStatus() {
        System.out.println("Shelter litter box status = " + getShelterLitterBoxLevel());
    }

    public void cleanShelterLitterBox() {
        shelterLitterBoxLevel = 0;
    }

    public void isLitterBoxMakingCatsSad() {
        for (Pet pet : pets.values()) {
            if (pet instanceof Cat) {
                if (shelterLitterBoxLevel > 15) {
                    ((Cat) pet).increaseSadnessOfCat();
                }
            }
        }
    }

    public void didPetUseLitterBox() {
        for (Pet pet : pets.values()) {
            if (pet instanceof Cat) {
                ((Cat) pet).useLitterBoxCheck();
                if (((Cat) pet).getPottyLevel() > 15) {
                    shelterLitterBoxLevel += 1;
                    ((Cat) pet).pottyLevel -= 15;
                }
            }
        }
    }

    public void updateShelterLitterBox() {
        didPetUseLitterBox();
        isLitterBoxMakingCatsSad();
    }


    Map<String, Pet> pets = new HashMap<>();

    public static boolean gameOn() {
        return true;
    }

    public void addPet(Pet pet) {
        pets.put(pet.petName, pet);
    }

    public void removePet(Pet pet) {
        pets.remove(pet.petName, pet);
    }

    public Collection<Pet> allPets() {
        return pets.values();
    }

    public void displayAllPetsList() {
        for (Pet pet : allPets()) {
            System.out.println(pet.petName + ": " + pet.petDescription);
        }
    }

    public void displayListOfAllRealPets() {
        for (Pet realPets : allRealPets()) {
            System.out.println(realPets);
        }
    }

    public Collection<Pet> allRealPets() {
        Map<String, Pet> realPets = new HashMap<>();
        for (Pet pet : pets.values()) {
            if (pet instanceof RealPets) {
                realPets.put(pet.getPetName(), pet);
            }
        }
        return realPets.values();
    }


    public Collection<Pet> allRoboticPets() {
        Map<String, Pet> roboticPets = new HashMap<>();
        for (Pet pet : pets.values()) {
            if (pet instanceof RoboticPets) {
                roboticPets.put(pet.getPetName(), pet);
            }
        }
        return roboticPets.values();
    }

    public void displayListOfAllRoboticPets() {
        for (Pet roboticPets : allRoboticPets()) {
            System.out.println(roboticPets);
        }
    }

    public Collection<Pet> allRealDogs() {
        Map<String, Pet> realDogs = new HashMap<>();
        for (Pet pet : pets.values()) {
            if (pet instanceof Dog) {
                realDogs.put(pet.getPetName(), pet);
            }
        }
        return realDogs.values();
    }

    public void displayAttributesOfAllRealDogs() {
        for (Pet realDogs : allRealDogs()) {
            System.out.println(realDogs);
        }
    }

    public Collection<Pet> allRoboticDogs() {
        Map<String, Pet> roboticDogs = new HashMap<>();
        for (Pet pet : pets.values()) {
            if (pet instanceof RoboticDog) {
                roboticDogs.put(pet.getPetName(), pet);
            }
        }
        return roboticDogs.values();
    }

    public void displayAttributesOfAllRoboticDogs() {
        for (Pet roboticDogs : allRoboticDogs()) {
            System.out.println(roboticDogs);
        }
    }

    public Collection<Pet> allRealCats() {
        Map<String, Pet> realCats = new HashMap<>();
        for (Pet pet : pets.values()) {
            if (pet instanceof Cat) {
                realCats.put(pet.getPetName(), pet);
            }
        }
        return realCats.values();
    }

    public void displayAttributesOfAllRealCats() {
        for (Pet realCats : allRealCats()) {
            System.out.println(realCats);
        }
    }

    public Collection<Pet> allRoboticCats() {
        Map<String, Pet> roboticCats = new HashMap<>();
        for (Pet pet : pets.values()) {
            if (pet instanceof RoboticCat) {
                roboticCats.put(pet.getPetName(), pet);
            }
        }
        return roboticCats.values();
    }

    public void displayAttributesOfAllRoboticCats() {
        for (Pet roboticCats : allRoboticCats()) {
            System.out.println(roboticCats);
        }
    }

    public Pet findPetByKey(String keyPetName) {
        return pets.get(keyPetName);
    }

    public void playWithPet(String petUserEntered) {
        Pet enteredPet = findPetByKey(petUserEntered);
        enteredPet.playWithPet();
    }

    public void feedAllRealPets() {
        for (Pet pet : pets.values()) {
            if (pet instanceof RealPetMethods) {
                ((RealPetMethods) pet).feedPet();
            }
        }
    }

    public void giveWaterToAllRealPets() {
        for (Pet pet : pets.values()) {
            if (pet instanceof RealPetMethods) {
                ((RealPetMethods) pet).giveWaterToPet();
            }
        }
    }

    public void walkAllRealDogs() {
        for (Pet pet : pets.values()) {
            if (pet instanceof Dog) {
                ((Dog) pet).walkPet();
            }
        }
    }

    public void walkAllRoboticDogs() {
        for (Pet pet : pets.values()) {
            if (pet instanceof RoboticDog) {
                ((RoboticDog) pet).walkRoboticPet();
            }
        }
    }

    public void walkAllDogs() {
        walkAllRealDogs();
        walkAllRoboticDogs();
    }

    public void oilAllRoboticDogs() {
        for (Pet pet : pets.values()) {
            if (pet instanceof RoboticDog) {
                ((RoboticDog) pet).oilRoboticPet();
            }
        }
    }

    public void oilAllRoboticCats() {
        for (Pet pet : pets.values()) {
            if (pet instanceof RoboticCat) {
                ((RoboticCat) pet).oilRoboticPet();
            }
        }
    }

    public void oilAllRoboticPets() {
        oilAllRoboticDogs();
        oilAllRoboticCats();
    }

    public void cleanAllDogsCages() {
        for (Pet pet : pets.values()) {
            if (pet instanceof Dog) {
                ((Dog) pet).cleanCageWaste();
            }
        }
    }

    public void tickAllDogs() {
        for (Pet pet : pets.values()) {
            if (pet instanceof Dog) {
                ((Dog) pet).dogTick();
            }
        }
    }

    public void tickAllCats() {
        for (Pet pet : pets.values()) {
            if (pet instanceof Cat) {
                ((Cat) pet).catTick();
            }
        }
    }

    public void tickAllRoboticDogs() {
        for (Pet pet : pets.values()) {
            if (pet instanceof RoboticDog) {
                ((RoboticDog) pet).roboticDogTick();
            }
        }
    }

    public void tickAllRoboticCats() {
        for (Pet pet : pets.values()) {
            if (pet instanceof RoboticCat) {
                ((RoboticCat) pet).roboticCatTick();
            }
        }
    }

    public void tickAllPets() {
        tickAllDogs();
        tickAllCats();
        tickAllRoboticDogs();
        tickAllRoboticCats();
    }
}