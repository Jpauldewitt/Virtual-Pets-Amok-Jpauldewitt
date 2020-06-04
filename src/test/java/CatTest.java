import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CatTest {
    Cat underTest = new Cat("Kitty", "So cute", true, 15, 15, 16, 15, 15, 15);

    @Test
    public void shouldBeAbleToReturnPetName() {
        String check = underTest.getPetName();
        Assertions.assertThat(check).isEqualTo("Kitty");
    }

    @Test
    public void shouldBeABleToReturnPetDescription() {
        String check = underTest.getPetDescription();
        Assertions.assertThat(check).isEqualTo("So cute");
    }

    @Test
    public void shouldBeARealCat() {
        Boolean check = underTest.getReal();
        Assertions.assertThat(check).isEqualTo(true);
    }

    @Test
    public void shouldBeAbleToEat() {
        int hungerBeforeEating = underTest.getHungerLevel();
        underTest.feedPet();
        int hungerAfterEating = underTest.getHungerLevel();
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

    @Test
    public void shouldReturnOverallHealth() {
        int beforeOverallHealthUpdate = underTest.getOverallHealth();
        underTest.updateOverallHealth();
        int afterOverallHealthUpdate = underTest.getOverallHealth();
        Assertions.assertThat(beforeOverallHealthUpdate - afterOverallHealthUpdate).isEqualTo(0);
    }

    @Test
    public void shouldBeAbleToTickCat() {
        int hungerBeforeTick = underTest.getHungerLevel();
        int thirstBeforeTick = underTest.getThirstLevel();
        int pottyBeforeTick = underTest.getPottyLevel();
        underTest.catTick();
        int hungerAfterTick = underTest.getHungerLevel();
        int thirstAfterTick = underTest.getThirstLevel();
        int pottyAfterTick = underTest.getPottyLevel();
        Assertions.assertThat(hungerAfterTick - hungerBeforeTick).isEqualTo(1);
        Assertions.assertThat(thirstAfterTick - thirstBeforeTick).isEqualTo(1);
        Assertions.assertThat(pottyAfterTick - pottyBeforeTick).isEqualTo(1);
    }
}

