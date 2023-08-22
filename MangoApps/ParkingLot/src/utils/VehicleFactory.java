package utils;

import repositories.VehicleRepository;

public class VehicleFactory {
    private static VehicleRepository vehicleInstance;
    private VehicleFactory(){

    }
    public static VehicleRepository getInstance() {
        if (vehicleInstance == null) {
            synchronized (VehicleRepository.class) {
                if (vehicleInstance == null) {
                    vehicleInstance = new VehicleRepository();
                }
            }
        }
        return vehicleInstance;
    }
}
