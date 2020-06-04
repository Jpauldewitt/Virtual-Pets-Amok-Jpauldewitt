abstract class RoboticPets extends Pet implements RoboticPetMethods {//implements roboticPetMethods

    @Override
    public String toString() {
        return petName + ": " +
                "Oil Level: " + oilLevel;
    }

    protected int oilLevel;

    public RoboticPets(String petName, String petDescription, boolean real, int oilLevel) {
        super(petName, petDescription, real);
        this.oilLevel = oilLevel;
    }

    @Override
    public int getOilLevel() {
        return oilLevel;
    }

    @Override
    public void oilRoboticPet() {
        oilLevel += 5;
    }
}
