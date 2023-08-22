package utils;

import java.util.concurrent.atomic.AtomicInteger;

public class Constants {
    public final static AtomicInteger ATTENDANT_ID = new AtomicInteger(0);
    public final static AtomicInteger OWNER_ID = new AtomicInteger(0);
    public final static AtomicInteger PAYMENT_ID = new AtomicInteger(0);
    public final static AtomicInteger VEHICLE_ID = new AtomicInteger(0);
    public final static AtomicInteger TICKET_NO = new AtomicInteger(0);
    public final static AtomicInteger SPOT_ID = new AtomicInteger(0);

    public final static String VehicleNotFoundException = "Vehicle did not found";
}
