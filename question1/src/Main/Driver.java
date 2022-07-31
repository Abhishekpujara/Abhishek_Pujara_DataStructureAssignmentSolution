package Main;

import java.util.Scanner;
import Services.construction;

public class Driver{
    public static void main(String[] args) {
        System.out.println("Enter the total number of floors in the building: ");
        Scanner sc = new Scanner(System.in) ;
        int N = sc.nextInt();
        int []floors = new int[N];
        for(int i =0; i< N; i++) {
            System.out.println("Enter the size of floor on day:"+ (i+1));
            int floorSize = sc.nextInt();
            floors[i] = floorSize;
        }
        construction.calculateFloors(floors);


    }
}
