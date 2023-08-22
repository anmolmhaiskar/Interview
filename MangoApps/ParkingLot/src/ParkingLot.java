import models.Entrance;
import services.EntranceService;
import services.SpotService;

import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Provide the capacity of spots in the parkingLot");
        int spotCapacity = sc.nextInt();
        if(spotCapacity > 0){
            initializeValues(spotCapacity);
        }
        else initializeValues(100);

    }


    public static void initializeValues(int spotCapacity){
        SpotService.initializeSpots(spotCapacity);
        EntranceService.initializeEntrances();
    }


}