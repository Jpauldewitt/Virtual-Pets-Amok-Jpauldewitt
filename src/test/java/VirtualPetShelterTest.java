import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Collection;

public class VirtualPetShelterTest {
    VirtualPetShelter myShelter = new VirtualPetShelter(16);
    Dog Argo = new Dog("Argo", "Super Cool", true, 15, 15, 15, 15, 15, 15, 15);
    Cat Kitty = new Cat("Kitty", "So cute", true, 15, 15, 16, 15, 15, 15);
    RoboticDog RoboDog9000 = new RoboticDog("RoboDog9000", "The first robot dog of it's kind", false, 15);
    RoboticCat RoboCat9000 = new RoboticCat("RoboCat9000", "The first robot cat of it's kind", false, 15);
    Dog Spot = new Dog("Spot", "Super Lame", true, 15, 15, 15, 15, 15, 15, 15);
    Cat Chuckles = new Cat("Chuckles", "So hilarious", true, 15, 15, 15, 15, 15, 15);
    RoboticDog RoboDog9002 = new RoboticDog("RoboDog9002", "The second robot dog of it's kind", false, 15);
    RoboticCat RoboCat9002 = new RoboticCat("RoboCat9002", "The second robot cat of it's kind", false, 15);

    @Test
    public void shouldBeAbleToAddPet() {
        myShelter.addPet(Argo);
        Collection<Pet> allPetCheck = myShelter.allPets();
        Assertions.assertThat(allPetCheck).contains(Argo);
    }

    @Test
    public void shouldBeAbleToAddAllTypesOfPets() {
        myShelter.addPet(Argo);
        myShelter.addPet(Kitty);
        myShelter.addPet(RoboDog9000);
        myShelter.addPet(RoboCat9000);
        Collection<Pet> allPetCheck = myShelter.allPets();
        Assertions.assertThat(allPetCheck).contains(Argo, Kitty, RoboDog9000, RoboCat9000);
    }

    @Test
    public void shouldBeAbleToRemoveAllTypesOfPets() {
        myShelter.addPet(Argo);
        myShelter.addPet(Kitty);
        myShelter.addPet(RoboDog9000);
        myShelter.addPet(RoboCat9000);
        myShelter.removePet(Argo);
        myShelter.removePet(Kitty);
        myShelter.removePet(RoboDog9000);
        myShelter.removePet(RoboCat9000);
        Collection<Pet> allPetCheck = myShelter.allPets();
        Assertions.assertThat(allPetCheck).doesNotContain(Argo, Kitty, RoboDog9000, RoboCat9000);
    }

    @Test
    public void shouldBeAbleToListAllRealPets() {
        myShelter.addPet(Argo);
        myShelter.addPet(Kitty);
        myShelter.addPet(RoboDog9000);
        myShelter.addPet(RoboCat9000);
        Collection<Pet> realPets = myShelter.allRealPets();
        Assertions.assertThat(realPets).contains(Argo, Kitty);
    }

    @Test
    public void shouldBeAbleToListAllRoboticPets() {
        myShelter.addPet(RoboCat9000);
        myShelter.addPet(RoboDog9000);
        Collection<Pet> robotPets = myShelter.allRoboticPets();
        Assertions.assertThat(robotPets).contains(RoboCat9000, RoboDog9000);
    }

    @Test
    public void shouldIncreaseShelterLitterBoxWhenCatUsesLitterBox() {
        myShelter.addPet(Kitty);
        int kittyPottyLevelBeforeUsing = Kitty.getPottyLevel();
        int shelterLitterBoxBeforeUsing = myShelter.getShelterLitterBoxLevel();
        myShelter.didPetUseLitterBox();
        Kitty.useLitterBoxCheck();
        int kittyPottyLevelAfterUsing = Kitty.getPottyLevel();
        int shelterLitterBoxAfterUsing = myShelter.getShelterLitterBoxLevel();
        Assertions.assertThat(shelterLitterBoxAfterUsing - shelterLitterBoxBeforeUsing).isEqualTo(1);
        Assertions.assertThat(kittyPottyLevelBeforeUsing - kittyPottyLevelAfterUsing).isEqualTo(15);
    }

    @Test
    public void shouldBeAbleToCleanShelterLitterBox() {
        int shelterLitterBoxBeforeCleaning = myShelter.getShelterLitterBoxLevel();
        myShelter.cleanShelterLitterBox();
        int shelterLitterBoxAfterCleaning = myShelter.getShelterLitterBoxLevel();
        Assertions.assertThat(shelterLitterBoxBeforeCleaning - shelterLitterBoxAfterCleaning).isEqualTo(16);
    }

    @Test
    public void catSadnessShouldIncreaseWithDirtyLitterBoxGreaterThan15() {
        myShelter.addPet(Kitty);
        int catSadnessBeforeCheck = Kitty.getSadnessLevel();
        myShelter.isLitterBoxMakingCatsSad();
        int catSadnessAfterCheck = Kitty.getSadnessLevel();
        Assertions.assertThat(catSadnessAfterCheck - catSadnessBeforeCheck).isEqualTo(1);
    }

    @Test
    public void shouldBeAbleToFeedAllRealPets() {
        myShelter.addPet(Kitty);
        myShelter.addPet(Argo);
        int dogHungerBeforeCheck = Argo.getHungerLevel();
        int catHungerBeforeCheck = Kitty.getHungerLevel();
        myShelter.feedAllRealPets();
        int dogHungerAfterCheck = Argo.getHungerLevel();
        int catHungerAfterCheck = Kitty.getHungerLevel();
        Assertions.assertThat(catHungerBeforeCheck - catHungerAfterCheck).isEqualTo(5);
        Assertions.assertThat(dogHungerBeforeCheck - dogHungerAfterCheck).isEqualTo(5);
    }

    @Test
    public void shouldBeAbleToGiveWaterToAllRealPets() {
        myShelter.addPet(Kitty);
        myShelter.addPet(Argo);
        int argoThirstBeforeCheck = Argo.getThirstLevel();
        int kittyThirstBeforeCheck = Kitty.getBoredomLevel();
        myShelter.giveWaterToAllRealPets();
        int argoThirstAfterCheck = Argo.getThirstLevel();
        int kittyThirstAfterCheck = Kitty.getThirstLevel();
        Assertions.assertThat(kittyThirstBeforeCheck - kittyThirstAfterCheck).isEqualTo(5);
        Assertions.assertThat(argoThirstBeforeCheck - argoThirstAfterCheck).isEqualTo(5);
    }

    @Test
    public void shouldBeAbleToWalkAllDogs() {
        myShelter.addPet(RoboDog9000);
        myShelter.addPet(Argo);
        int dogPottyLevelBeforeWalk = Argo.getPottyLevel();
        int dogSadnessLevelBeforeWalk = Argo.getSadnessLevel();
        int robotDogOilLevelBeforeWalk = RoboDog9000.getOilLevel();
        myShelter.walkAllDogs();
        int dogPottyLevelAfterWalk = Argo.getPottyLevel();
        int dogSadnessLevelAfterWalk = Argo.getSadnessLevel();
        int robotDogOilLevelAfterWalk = RoboDog9000.getOilLevel();
        Assertions.assertThat(dogPottyLevelBeforeWalk - dogPottyLevelAfterWalk).isEqualTo(5);
        Assertions.assertThat(dogSadnessLevelBeforeWalk - dogSadnessLevelAfterWalk).isEqualTo(5);
        Assertions.assertThat(robotDogOilLevelBeforeWalk - robotDogOilLevelAfterWalk).isEqualTo(5);
    }

    @Test
    public void shouldBeAbleToOilAllRobots() {
        myShelter.addPet(RoboDog9000);
        myShelter.addPet(RoboCat9000);
        int roboticDogOilLevelBeforeBeingOiled = RoboDog9000.getOilLevel();
        int roboticCatOilLevelBeforeBeingOiled = RoboCat9000.getOilLevel();
        myShelter.oilAllRoboticPets();
        int roboticDogOilLevelAfterBeingOiled = RoboDog9000.getOilLevel();
        int roboticCatOilLevelAfterBeingOiled = RoboCat9000.getOilLevel();
        Assertions.assertThat(roboticDogOilLevelAfterBeingOiled - roboticDogOilLevelBeforeBeingOiled).isEqualTo(5);
        Assertions.assertThat(roboticCatOilLevelAfterBeingOiled - roboticCatOilLevelBeforeBeingOiled).isEqualTo(5);
    }

    @Test
    public void shouldBeAbleToCleanAllDogCages() {
        myShelter.addPet(Argo);
        myShelter.addPet(Spot);
        int argoCageWasteLevelBeforeCleaning = Argo.getCageWasteLevel();
        int spotsCageWasteLevelBeforeCleaning = Spot.getCageWasteLevel();
        myShelter.cleanAllDogsCages();
        int argoCageWasteLevelAfterCleaning = Argo.getCageWasteLevel();
        int spotCageWasteLevelAfterCleaning = Spot.getCageWasteLevel();
        Assertions.assertThat(argoCageWasteLevelBeforeCleaning - argoCageWasteLevelAfterCleaning).isEqualTo(5);
        Assertions.assertThat(spotsCageWasteLevelBeforeCleaning - spotCageWasteLevelAfterCleaning).isEqualTo(5);
    }

    @Test
    public void shouldBeAbleToTickAllRealDogs() {
        myShelter.addPet(Argo);
        myShelter.addPet(Spot);
        int argoHungerBeforeTick = Argo.getHungerLevel();
        int spotHungerBeforeTick = Spot.getHungerLevel();
        int argoThirstLevelBeforeTick = Argo.getThirstLevel();
        int spotThirstBeforeTick = Spot.getThirstLevel();
        myShelter.tickAllDogs();
        int argoHungerAfterTick = Argo.getHungerLevel();
        int spotHungerAfterTick = Spot.getHungerLevel();
        int argoThirstAfterTick = Argo.getThirstLevel();
        int spotThirstAfterTick = Spot.getThirstLevel();
        Assertions.assertThat(argoHungerAfterTick - argoHungerBeforeTick).isEqualTo(1);
        Assertions.assertThat(argoThirstAfterTick - argoThirstLevelBeforeTick).isEqualTo(1);
        Assertions.assertThat(spotHungerAfterTick - spotHungerBeforeTick).isEqualTo(1);
        Assertions.assertThat(spotThirstAfterTick - spotThirstBeforeTick).isEqualTo(1);
    }

    @Test
    public void shouldBeAbleToTickAllRealCats() {
        myShelter.addPet(Kitty);
        myShelter.addPet(Chuckles);
        int kittyHungerBeforeTick = Kitty.getHungerLevel();
        int chucklesHungerBeforeTick = Chuckles.getHungerLevel();
        int kittyThirstLevelBeforeTick = Kitty.getThirstLevel();
        int chucklesThirstBeforeTick = Chuckles.getThirstLevel();
        int kittyPottyBeforeTick = Kitty.getPottyLevel();
        int chucklesPottyBeforeTick = Chuckles.getPottyLevel();
        myShelter.tickAllCats();
        int kittyHungerAfterTick = Kitty.getHungerLevel();
        int chucklesHungerAfterTick = Chuckles.getHungerLevel();
        int kittyThirstAfterTick = Kitty.getThirstLevel();
        int chucklesThirstAfterTick = Chuckles.getThirstLevel();
        int kittyPottyAfterTick = Kitty.getPottyLevel();
        int chucklesPottyAfterTick = Chuckles.getPottyLevel();
        Assertions.assertThat(kittyHungerAfterTick - kittyHungerBeforeTick).isEqualTo(1);
        Assertions.assertThat(kittyThirstAfterTick - kittyThirstLevelBeforeTick).isEqualTo(1);
        Assertions.assertThat(kittyPottyAfterTick - kittyPottyBeforeTick).isEqualTo(1);
        Assertions.assertThat(chucklesHungerAfterTick - chucklesHungerBeforeTick).isEqualTo(1);
        Assertions.assertThat(chucklesThirstAfterTick - chucklesThirstBeforeTick).isEqualTo(1);
        Assertions.assertThat(chucklesPottyAfterTick - chucklesPottyBeforeTick).isEqualTo(1);

    }

    @Test
    public void shouldBeAbleToTickAllRoboticDogs() {
        myShelter.addPet(RoboDog9000);
        myShelter.addPet(RoboDog9002);
        int roboDog9000OilLevelBeforeTick = RoboDog9000.getOilLevel();
        int roboDog9002OilLevelBeforeTick = RoboDog9002.getOilLevel();
        myShelter.tickAllRoboticDogs();
        int roboDog9000OilLevelAfterTick = RoboDog9000.getOilLevel();
        int roboDog9002OilLevelAfterTick = RoboDog9002.getOilLevel();
        Assertions.assertThat(roboDog9000OilLevelBeforeTick - roboDog9000OilLevelAfterTick).isEqualTo(1);
        Assertions.assertThat(roboDog9002OilLevelBeforeTick - roboDog9002OilLevelAfterTick).isEqualTo(1);

    }

    @Test
    public void shouldBeAbleToTickAllRoboticCats() {
        myShelter.addPet(RoboCat9000);
        myShelter.addPet(RoboCat9002);
        int roboCat9000OilLevelBeforeTick = RoboCat9000.getOilLevel();
        int roboCat9002OilLevelBeforeTick = RoboCat9002.getOilLevel();
        myShelter.tickAllRoboticCats();
        int roboCat9000OilLevelAfterTick = RoboCat9000.getOilLevel();
        int roboCat9002OilLevelAfterTick = RoboCat9002.getOilLevel();
        Assertions.assertThat(roboCat9000OilLevelBeforeTick - roboCat9000OilLevelAfterTick).isEqualTo(1);
        Assertions.assertThat(roboCat9002OilLevelBeforeTick - roboCat9002OilLevelAfterTick).isEqualTo(1);
    }

    @Test
    public void shouldBeAbleToTickAllPets() {
        myShelter.addPet(RoboCat9000);
        myShelter.addPet(RoboCat9002);
        myShelter.addPet(RoboDog9000);
        myShelter.addPet(RoboDog9002);
        myShelter.addPet(Kitty);
        myShelter.addPet(Chuckles);
        myShelter.addPet(Argo);
        myShelter.addPet(Spot);
        int argoHungerBeforeTick = Argo.getHungerLevel();
        int spotHungerBeforeTick = Spot.getHungerLevel();
        int argoThirstLevelBeforeTick = Argo.getThirstLevel();
        int spotThirstBeforeTick = Spot.getThirstLevel();
        int kittyHungerBeforeTick = Kitty.getHungerLevel();
        int chucklesHungerBeforeTick = Chuckles.getHungerLevel();
        int kittyThirstLevelBeforeTick = Kitty.getThirstLevel();
        int chucklesThirstBeforeTick = Chuckles.getThirstLevel();
        int kittyPottyBeforeTick = Kitty.getPottyLevel();
        int chucklesPottyBeforeTick = Chuckles.getPottyLevel();
        int roboDog9000OilLevelBeforeTick = RoboDog9000.getOilLevel();
        int roboDog9002OilLevelBeforeTick = RoboDog9002.getOilLevel();
        int roboCat9000OilLevelBeforeTick = RoboCat9000.getOilLevel();
        int roboCat9002OilLevelBeforeTick = RoboCat9002.getOilLevel();
        myShelter.tickAllPets();
        int argoHungerAfterTick = Argo.getHungerLevel();
        int spotHungerAfterTick = Spot.getHungerLevel();
        int argoThirstAfterTick = Argo.getThirstLevel();
        int spotThirstAfterTick = Spot.getThirstLevel();
        int kittyHungerAfterTick = Kitty.getHungerLevel();
        int chucklesHungerAfterTick = Chuckles.getHungerLevel();
        int kittyThirstAfterTick = Kitty.getThirstLevel();
        int chucklesThirstAfterTick = Chuckles.getThirstLevel();
        int kittyPottyAfterTick = Kitty.getPottyLevel();
        int chucklesPottyAfterTick = Chuckles.getPottyLevel();
        int roboDog9000OilLevelAfterTick = RoboDog9000.getOilLevel();
        int roboDog9002OilLevelAfterTick = RoboDog9002.getOilLevel();
        int roboCat9000OilLevelAfterTick = RoboCat9000.getOilLevel();
        int roboCat9002OilLevelAfterTick = RoboCat9002.getOilLevel();
        Assertions.assertThat(argoHungerAfterTick - argoHungerBeforeTick).isEqualTo(1);
        Assertions.assertThat(argoThirstAfterTick - argoThirstLevelBeforeTick).isEqualTo(1);
        Assertions.assertThat(spotHungerAfterTick - spotHungerBeforeTick).isEqualTo(1);
        Assertions.assertThat(spotThirstAfterTick - spotThirstBeforeTick).isEqualTo(1);
        Assertions.assertThat(kittyHungerAfterTick - kittyHungerBeforeTick).isEqualTo(1);
        Assertions.assertThat(kittyThirstAfterTick - kittyThirstLevelBeforeTick).isEqualTo(1);
        Assertions.assertThat(kittyPottyAfterTick - kittyPottyBeforeTick).isEqualTo(1);
        Assertions.assertThat(chucklesHungerAfterTick - chucklesHungerBeforeTick).isEqualTo(1);
        Assertions.assertThat(chucklesThirstAfterTick - chucklesThirstBeforeTick).isEqualTo(1);
        Assertions.assertThat(chucklesPottyAfterTick - chucklesPottyBeforeTick).isEqualTo(1);
        Assertions.assertThat(roboDog9000OilLevelBeforeTick - roboDog9000OilLevelAfterTick).isEqualTo(1);
        Assertions.assertThat(roboDog9002OilLevelBeforeTick - roboDog9002OilLevelAfterTick).isEqualTo(1);
        Assertions.assertThat(roboCat9000OilLevelBeforeTick - roboCat9000OilLevelAfterTick).isEqualTo(1);
        Assertions.assertThat(roboCat9002OilLevelBeforeTick - roboCat9002OilLevelAfterTick).isEqualTo(1);
    }
}