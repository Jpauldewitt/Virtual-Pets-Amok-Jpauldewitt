import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RoboticCatTest {
    RoboticCat underTest = new RoboticCat("RoboCat9000", "The first robot cat of it's kind", false, 15);

    @Test
    public void shouldBeAbleToReturnPetName() {
        String check = underTest.getPetName();
        Assertions.assertThat(check).isEqualTo("RoboCat9000");
    }

    @Test
    public void shouldBeABleToReturnPetDescription() {
        String check = underTest.getPetDescription();
        Assertions.assertThat(check).isEqualTo("The first robot cat of it's kind");
    }

    @Test
    public void shouldNotBeARealCat() {
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
    public void shouldBeAbleToTickRoboticCat() {
        int oilLevelBeforeTick = underTest.getOilLevel();
        underTest.roboticCatTick();
        int oilLevelAfterTick = underTest.getOilLevel();
        Assertions.assertThat(oilLevelBeforeTick - oilLevelAfterTick).isEqualTo(1);
    }
}

