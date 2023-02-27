public class Dog implements IAnimal{
    private String animalName;
//     Dog(String animalName) {
//        this.animalName = animalName;
//    }

    @Override
    public String makeSound() {
        return animalName + ": Ham!";
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalName() {
        return animalName;
    }
}
