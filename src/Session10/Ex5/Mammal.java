package Session10.Ex5;

public class Mammal extends Animal {
    private boolean hasFur;

    public Mammal() {
        super();
        this.hasFur = false;
    }

    public Mammal(String name, int age, boolean hasFur) {
        super(name, age);
        this.hasFur = hasFur;
    }

    public boolean isHasFur() {
        return hasFur;
    }

    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Has fur: " + hasFur);
    }
}