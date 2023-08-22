package utils;

import repositories.AttendantRepository;
import repositories.EntranceRepository;

public class AttendantFactory {
    private static AttendantRepository attendantInstance;
    private AttendantFactory(){

    }
    public static AttendantRepository getInstance() {
        if (attendantInstance == null) {
            synchronized (AttendantRepository.class) {
                if (attendantInstance == null) {
                    attendantInstance = new AttendantRepository();
                }
            }
        }
        return attendantInstance;
    }
}
