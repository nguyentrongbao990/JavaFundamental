package Session8.Ex4;

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3,4);
        Rectangle r2 = new Rectangle(5,2);
        Rectangle r3 = new Rectangle(4.5,3.5);
        System.out.println("Rectangle 1: "+r1);
        System.out.println("Rectangle 2: "+r2);
        System.out.println("Rectangle 3: "+r3);
        Rectangle maxRect = r1;
        if(maxRect.getArea()<r2.getArea()){
            maxRect = r2;
        }
        if(maxRect.getArea()<r3.getArea()){
            maxRect = r3;
        }
        double maxArea = maxRect.getArea();
        int count =0;
        if(r1.getArea()==maxArea){
            count++;
        }
        if(r2.getArea()==maxArea){
            count++;
        }
        if(r3.getArea()==maxArea){
            count++;
        }
        if(count==1){
            System.out.println("Largest area: "+ maxArea+" ("+ maxRect+")");
        }
        else{
            System.out.println("Largest area: "+ maxArea);
            System.out.printf("There are %d rectangles with the largest area\n",count);
        }
    }
}
