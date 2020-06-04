public interface RealPetMethods {

    String getPetName();

    String getPetDescription();

    Boolean getReal();

    int getOverallHealth();

    int getHungerLevel();

    int getThirstLevel();

    int getPottyLevel();

    int getSadnessLevel();

    int getBoredomLevel();

    void feedPet();

    void giveWaterToPet();

    void updateOverallHealth();

    void playWithPet();
}
