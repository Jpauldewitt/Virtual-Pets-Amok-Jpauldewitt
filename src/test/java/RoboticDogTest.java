import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RoboticDogTest {
    RoboticDog underTest = new RoboticDog("RoboDog9000", "The first robot dog of it's kind", false, 15);

    @Test
    public void shouldBeAbleToReturnPetName() {
        String check = underTest.getPetName();
        Assertions.assertThat(check).isEqualTo("RoboDog9000");
    }

    @Test
    public void shouldBeABleToReturnPetDescription() {
        String check = underTest.getPetDescription();
        Assertions.assertThat(check).isEqualTo("The first robot dog of it's kind");
    }

    @Test
    public void shouldNotBeARealDog() {
        Boolean check = underTest.getReal();
        Assertions.assertThat(check).isEqualTo(false);
    }

    @Test
    public void shouldBeAbleToBeOiled() {
        int oilLevelBeforeBeingOiled = underTest.getOilLevel();
        underTest.oilRoboticPet();
        int oilLevelAfterBeingOiled = underTest.getOilLevel();
        Assertions.assertThat(oilLevelAfterBeingOiled - oilLevelBeforeBeingOiled).isEqualTo(5);
    }

    @Test
    public void shouldBeAbleToBeWalked() {
        int oilLevelBeforeBeingWalked = underTest.getOilLevel();
        underTest.walkRoboticPet();
        int oilLevelAfterBeingWalked = underTest.getOilLevel();
        Assertions.assertThat(oilLevelBeforeBeingWalked - oilLevelAfterBeingWalked).isEqualTo(5);
    }

    @Test
    public void shouldBeAbleToTickRoboticDog() {
        int oilLevelBeforeTick = underTest.getOilLevel();
        underTest.roboticDogTick();
        int oilLevelAfterTick = underTest.getOilLevel();
        Assertions.assertThat(oilLevelBeforeTick - oilLevelAfterTick).isEqualTo(1);
    }
}

