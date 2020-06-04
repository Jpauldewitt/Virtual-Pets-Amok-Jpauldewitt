public class RoboticCat extends RoboticPets implements RoboticPetMethods {

    public RoboticCat(String petName, String petDescription, boolean real, int oilLevel) {
        super(petName, petDescription, real, oilLevel);
    }

    @Override
    public void playWithPet() {
    }

    public void roboticCatTick() {
        oilLevel -= 1;
    }
}
