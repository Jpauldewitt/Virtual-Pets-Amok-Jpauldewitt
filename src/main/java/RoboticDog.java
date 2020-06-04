public class RoboticDog extends RoboticPets implements RoboticPetMethods {

    public RoboticDog(String petName, String petDescription, boolean real, int oilLevel) {
        super(petName, petDescription, real, oilLevel);
    }

    @Override
    public void playWithPet() {
    }

    public void walkRoboticPet() {
        if (oilLevel > 5) {
            oilLevel -= 5;
        } else oilLevel = 0;
    }

    public void roboticDogTick() {
        oilLevel -= 1;
    }
}


