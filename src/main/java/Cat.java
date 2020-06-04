public class Cat extends RealPets implements RealPetMethods {

    private int litterBoxLevel;

    public Cat(String petName, String petDescription, boolean real, int hungerLevel, int thirstLevel, int pottyLevel, int sadnessLevel, int boredomLevel, int overallHealth) {
        super(petName, petDescription, real, hungerLevel, thirstLevel, pottyLevel, sadnessLevel, boredomLevel, overallHealth);
    }

    @Override
    public String getPetName() {
        return petName;
    }

    @Override
    public String getPetDescription() {
        return petDescription;
    }

    @Override
    public Boolean getReal() {
        return real;
    }

    @Override
    public int getHungerLevel() {
        return hungerLevel;
    }

    @Override
    public int getThirstLevel() {
        return thirstLevel;
    }

    @Override
    public int getPottyLevel() {
        return pottyLevel;
    }

    @Override
    public int getSadnessLevel() {
        return sadnessLevel;
    }

    @Override
    public int getBoredomLevel() {
        return boredomLevel;
    }

    @Override
    public int getOverallHealth() {
        return overAllHealth;
    }

    @Override
    public void feedPet() {
        if (hungerLevel > 5) {
            hungerLevel -= 5;
        } else hungerLevel = 0;
    }

    @Override
    public void giveWaterToPet() {
        if (thirstLevel > 5) {
            thirstLevel -= 5;
        } else thirstLevel = 0;
    }

    @Override
    public void playWithPet() {
        if (boredomLevel > 5) {
            boredomLevel -= 5;
        } else boredomLevel = 0;
    }

    @Override
    public void updateOverallHealth() {
        overAllHealth = ((hungerLevel + thirstLevel + pottyLevel + sadnessLevel) / 4);
    }

    public void increaseSadnessOfCat() {
        sadnessLevel += 1;
    }

    public void useLitterBoxCheck() {
        if (pottyLevel > 15) {
            litterBoxLevel += 5;
        }
    }

    public void catTick() {
        hungerLevel += 1;
        thirstLevel += 1;
        pottyLevel += 1;
        updateOverallHealth();
    }
}
