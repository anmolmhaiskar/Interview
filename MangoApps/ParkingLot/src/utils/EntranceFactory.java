package utils;

import repositories.EntranceRepository;

public class EntranceFactory {
    private static EntranceRepository entranceInstance;
    private EntranceFactory(){

    }
    public static EntranceRepository getInstance() {
        if (entranceInstance == null) {
            synchronized (EntranceRepository.class) {
                if (entranceInstance == null) {
                    entranceInstance = new EntranceRepository();
                }
            }
        }
        return entranceInstance;
    }
}
