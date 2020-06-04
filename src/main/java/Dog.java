public class Dog extends RealPets implements RealPetMethods {
    private int cageWasteLevel;

    public Dog(String petName, String petDescription, boolean real, int hungerLevel, int thirstLevel, int pottyLevel, int wasteLevel, int sadnessLevel, int boredomLevel, int overallHealth) {
        super(petName, petDescription, real, hungerLevel, thirstLevel, pottyLevel, sadnessLevel, boredomLevel, overallHealth);
        this.cageWasteLevel = wasteLevel;
    }

    @Override
    public String toString() {
        return "Name: " + petName + ":  " +
                "  Hunger = " + hungerLevel +
                "  Thirst = " + thirstLevel +
                "  Potty = " + pottyLevel +
                "  Sadness = " + sadnessLevel +
                "  Boredom = " + boredomLevel +
                "  Cage Waste = " + cageWasteLevel +
                "  Overall Health = " + overAllHealth;
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

    public int getCageWasteLevel() {
        return cageWasteLevel;
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
    public void updateOverallHealth() {
        overAllHealth = ((hungerLevel + thirstLevel + pottyLevel + sadnessLevel) / 4);
    }

    public void pottyInCageCheck() {
        if (pottyLevel > 15) {
            pottyLevel -= 5;
            cageWasteLevel += 5;
            if (cageWasteLevel > 15) {
                sadnessLevel += 5;
            }
        }
    }

    public void cleanCageWaste() {
        if (cageWasteLevel > 5) {
            cageWasteLevel -= 5;
        } else cageWasteLevel = 0;
    }

    public void walkPet() {
        if (pottyLevel > 5)
            pottyLevel -= 5;
        else {
            pottyLevel = 0;
        }
        if (sadnessLevel > 5)
            sadnessLevel -= 5;
        else {
            sadnessLevel = 0;
        }
    }

    public void playWithPet() {
        if (boredomLevel > 5) {
            boredomLevel -= 5;
        } else boredomLevel = 0;
    }

    public void dogTick() {
        hungerLevel += 1;
        thirstLevel += 1;
        pottyLevel += 1;
        pottyInCageCheck();
        updateOverallHealth();
    }
}

