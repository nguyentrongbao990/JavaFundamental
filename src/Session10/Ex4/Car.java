package Session10.Ex4;

public class Car {
    private int currentSpeed =0;
    public void accelerate(){
        currentSpeed+=10;
        System.out.println("Car accelerated by default: +10km/h");
    }
    public void accelerate(int speed){
        currentSpeed+=speed;
        System.out.println("Car accelerated by "+speed+" km/h");
    }
    public void accelerate(int speed,int seconds){
        int increase = speed*seconds;
        currentSpeed+=increase;
        System.out.println("Car accelerated by "+increase+" km/h (speed x time)");
    }
    public void printStatus(){
        System.out.println("Current Speed: "+currentSpeed+"km/h");
    }
}
