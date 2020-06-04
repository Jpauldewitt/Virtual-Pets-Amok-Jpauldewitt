abstract class Pet {
    protected String petName;
    protected String petDescription;
    protected Boolean real;

    @Override
    public String toString() {
        return petName + ":  " + petDescription;
    }

    public Pet(String petName, String petDescription, boolean real) {
        this.petName = petName;
        this.petDescription = petDescription;
        this.real = real;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetDescription() {
        return petDescription;
    }

    public Boolean getReal() {
        return real;
    }

    public abstract void playWithPet();
}
