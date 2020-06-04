abstract class RealPets extends Pet implements RealPetMethods {

    @Override
    public String toString() {
        return "Name: " + petName + ":  " +
                "  Hunger = " + hungerLevel +
                "  Thirst = " + thirstLevel +
                "  Potty = " + pottyLevel +
                "  Sadness = " + sadnessLevel +
                "  Boredom = " + boredomLevel +
                "  Overall Health = " + overAllHealth;
    }

    protected int hungerLevel;
    protected int thirstLevel;
    protected int pottyLevel;
    protected int sadnessLevel;
    protected int boredomLevel;
    protected int overAllHealth;

    public RealPets(String petName, String petDescription, boolean real, int hunger, int thirst, int pottyLevel, int sadnessLevel, int boredomLevel, int overallHealth) {
        super(petName, petDescription, real);
        this.hungerLevel = hunger;
        this.thirstLevel = thirst;
        this.pottyLevel = pottyLevel;
        this.sadnessLevel = sadnessLevel;
        this.boredomLevel = boredomLevel;
        this.overAllHealth = overallHealth;
    }
}
