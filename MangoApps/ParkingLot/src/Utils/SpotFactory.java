package Utils;

import repositories.SpotRepository;

public class SpotFactory {

    private static SpotRepository spotInstance;
    private SpotFactory(){

    }
    public static SpotRepository getInstance() {
        if (spotInstance == null) {
            synchronized (SpotRepository.class) {
                if (spotInstance == null) {
                    spotInstance = new SpotRepository();
                }
            }
        }
        return spotInstance;
    }

}
