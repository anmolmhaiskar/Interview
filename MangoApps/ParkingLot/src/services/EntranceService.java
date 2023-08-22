package services;

import models.Entrance;
import repositories.EntranceRepository;
import utils.EntranceFactory;

import java.util.List;

public class EntranceService {

    public static EntranceRepository entranceRepository = EntranceFactory.getInstance();
    public static void initializeEntrances(){
        entranceRepository.initializeEntrances();
    }

    public static List<Entrance> getEntrances() {
        List<Entrance> entrances = entranceRepository.getEntrances();
        return entrances;
    }

    public void addEntrance(Entrance entrance){
        entranceRepository.addEntrance(entrance);
    }
}
