import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DogTest {
    Dog underTest = new Dog("Argo", "Super Cool", true, 5, 5, 5, 5, 5, 5, 5);
    Dog Spot = new Dog("Spot", "Waste Level Dog", true,15,15,16,16,16,15,15);

    @Test
    public void shouldBeAbleToReturnPetName() {
        String check = underTest.getPetName();
        Assertions.assertThat(check).isEqualToIgnoringCase("Argo");
    }

    @Test
    public void shouldBeABleToReturnPetDescription() {
        String check = underTest.getPetDescription();
        Assertions.assertThat(check).isEqualTo("Super Cool");
    }

    @Test
    public void shouldBeARealDog() {
        Boolean check = underTest.getReal();
        Assertions.assertThat(check).isEqualTo(true);
    }

    @Test
    public void shouldBeAbleToEat() {
        int hungerBeforeEating = underTest.getHungerLevel();
        underTest.feedPet();
        int hungerAfterEating = underTest.getlHungerLevel();
        Assertions.assertThat(hungerBeforeEating - hungerAfterEating).isEqualTo(5);
    }

    @Test
    public void shouldBeAbleToDrink() {
        int thirstBeforeWater = underTest.getThirstLevel();
        underTest.giveWaterToPet();
        int thirstAfterWater = underTest.getThirstLevel();
        Assertions.assertThat(thirstBeforeWater - thirstAfterWater).isEqualTo(5);
    }

    @Test
    public void shouldBeAbleToPlayWithPet() {
        int boredomLevelBeforePlayingWithPet = underTest.getBoredomLevel();
        underTest.playWithPet();
        int boredomLevelAfterPlayingWithPet = underTest.getBoredomLevel();
        Assertions.assertThat(boredomLevelBeforePlayingWithPet - boredomLevelAfterPlayingWithPet).isEqualTo(5);
    }

    @Test //should decrease boredom
    public void shouldBeAbleToWalk() {
        int pottyLevelBeforeWalk = underTest.getPottyLevel();
        int sadnessLevelBeforeWalk = underTest.getSadnessLevel();
        underTest.walkPet();
        int pottyLevelAfterWalk = underTest.getPottyLevel();
        int sadnessLevelAfterWalk = underTest.getSadnessLevel();
        Assertions.assertThat(pottyLevelBeforeWalk - pottyLevelAfterWalk).isEqualTo(5);
        Assertions.assertThat(sadnessLevelBeforeWalk - sadnessLevelAfterWalk).isEqualTo(5);
    }

    @Test
    public void shouldBeAbleToPottyInCage() {
        int pottyLevelBeforeGoingInCage = Spot.getPottyLevel();
        int wasteLevelInCageBeforeGoingInCage = Spot.getCageWasteLevel();
        Spot.pottyInCageCheck();
        int pottyLevelAfterGoingInCage = Spot.getPottyLevel();
        int wasteLevelInCageAfterGoingInCage = Spot.getCageWasteLevel();
        Assertions.assertThat(pottyLevelBeforeGoingInCage - pottyLevelAfterGoingInCage).isEqualTo(5);
        Assertions.assertThat(wasteLevelInCageAfterGoingInCage - wasteLevelInCageBeforeGoingInCage).isEqualTo(5);
    }

    @Test
    public void shouldIncreaseSadnessIfWasteIsGreaterThan15() {
        int sadnessLevelBeforeGoingInCage = Spot.getSadnessLevel();
        Spot.pottyInCageCheck();
        int sadnessLevelAfterGoingInCage = Spot.getSadnessLevel();
        Assertions.assertThat(sadnessLevelAfterGoingInCage - sadnessLevelBeforeGoingInCage).isEqualTo(5);
    }

    @Test
    public void shouldReturnOverallHealth() {
        int beforeOverallHealthUpdate = underTest.getOverallHealth();
        underTest.updateOverallHealth();
        int afterOverallHealthUpdate = underTest.getOverallHealth();
        Assertions.assertThat(afterOverallHealthUpdate-beforeOverallHealthUpdate).isEqualTo(0);
    }


    @Test
    public void shouldBeAbleToCleanDogCage() {
        int cageWasteLevelBeforeCleaning = underTest.getCageWasteLevel();
        underTest.cleanCageWaste();
        int cageWasteLevelAfterCleaning = underTest.getCageWasteLevel();
        Assertions.assertThat(cageWasteLevelBeforeCleaning - cageWasteLevelAfterCleaning).isEqualTo(5);
    }

    @Test
    public void shouldBeAbleToTickDog() {
        int hungerBeforeTick = underTest.getHungerLevel();
        int thirstBeforeTick = underTest.getThirstLevel();
        //int pottyBeforeTick =
        underTest.dogTick();
        int hungerAfterTick = underTest.getHungerLevel();
        int thirstAfterTick = underTest.getThirstLevel();
        //int pottyAfterTick =
        Assertions.assertThat(hungerAfterTick - hungerBeforeTick).isEqualTo(1);
        Assertions.assertThat(thirstAfterTick - thirstBeforeTick).isEqualTo(1);
    }

}