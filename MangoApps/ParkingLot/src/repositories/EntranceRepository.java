package repositories;

import models.Entrance;

import java.util.ArrayList;
import java.util.List;

public class EntranceRepository {

    List<Entrance> entrances;

    public EntranceRepository(){
        this.entrances = new ArrayList<>();
    }

    public void initializeEntrances(){
        int[][] gatePositions = {{0, 500}, {500, 0}, {0, -500}, {-500, 0}};
        for(int i=0; i<4; i++){
            entrances.add(new Entrance(i, gatePositions[i][0], gatePositions[i][1]));
        }
    }

    public void addEntrance(Entrance entrance){
        entrances.add(entrance);
    }

    public List<Entrance> getEntrances(){
        return this.entrances;
    }

    public Entrance getEntranceById(int gateId){
        return this.entrances.get(gateId);
    }

}
