package repositories;

import models.Vehicle;
import utils.EntranceFactory;
import enums.SizeCategory;
import models.Entrance;
import models.Spot;

import java.util.*;

public class SpotRepository {

    private List<Spot> spots;
    private HashMap<SizeCategory, List<Spot>> sizeCategorySpotMap;
    private HashMap<Integer, TreeMap<Integer, List<Spot>>> nearestSpotMap;
    private EntranceRepository entranceRepository;

    public SpotRepository(){
        this.spots = new ArrayList<>();
        this.entranceRepository = EntranceFactory.getInstance();
        this.sizeCategorySpotMap = new HashMap<>();
        this.nearestSpotMap = new HashMap<>();
        initializeNearestSpotMap();
    }

    private void initializeNearestSpotMap() {
        List<Entrance> entrances = entranceRepository.getEntrances();
        for(Entrance entrance : entrances){
            nearestSpotMap.put(entrance.getGateNo(), new TreeMap<>());
        }
    }

    public void initializeSpots(int numberOfSpots){
        int sizeCapacity = (25*numberOfSpots)/100, index = 0;
        SizeCategory[] sizeCategories = {SizeCategory.SMALL, SizeCategory.MEDIUM, SizeCategory.LARGE, SizeCategory.HUGE};
        for(int i=0; i<numberOfSpots; i++){
            SizeCategory size;
            if(sizeCapacity<=0 && index<sizeCategories.length){
                sizeCapacity = (25*numberOfSpots)/100;
                index++;
            }
            else{
                sizeCapacity--;
            }
            size = sizeCategories[index];
            double costPerHour = (double) generateRandomNumber(5, 100);
            int xCoordinate = generateRandomNumber(-1000, 1000);
            int yCoordinate = generateRandomNumber(-1000, 1000);

            Spot spot = new Spot(size, costPerHour, xCoordinate, yCoordinate);

            spots.add(spot);
            addSizeCategorySpot(spot);
            addToNearestSpotMap(spot);
        }
    }

    public void addSizeCategorySpot(Spot spot){
        List<Spot> catSopts = sizeCategorySpotMap.getOrDefault(spot.getSize(), new ArrayList<Spot>());
        catSopts.add(spot);
        sizeCategorySpotMap.put(spot.getSize(), catSopts);
    }

    public void addToNearestSpotMap(Spot spot){
        List<Entrance> entrances = entranceRepository.getEntrances();
        for(Entrance entrance : entrances){
            int distance = calculateDistance(entrance.getXCoordinate(), entrance.getYCoordinate(), spot.getXCoordinate(), spot.getYCoordinate());
            TreeMap<Integer, List<Spot>> treeMap = nearestSpotMap.get(entrance.getGateNo());
            List<Spot> closeSpotList = treeMap.getOrDefault(distance, new ArrayList<Spot>());
            closeSpotList.add(spot);
            treeMap.put(distance, closeSpotList);
        }
    }

    public List<Spot> getSpots(){
        return this.spots;
    }

    private int calculateDistance(int x1, int y1, int x2, int y2){
        return (int) Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }

    public Spot getNearestSpot(int gateNo, SizeCategory sizeCategory){

        TreeMap<Integer, List<Spot>> treeMap = nearestSpotMap.get(gateNo);
        if(treeMap!=null && !treeMap.isEmpty()){
            for(Integer distance : treeMap.keySet()){
                for(Spot closeSpot : treeMap.get(distance)){
                    if(closeSpot.isAvailable() && sizeCategory == closeSpot.getSize()){
                        return closeSpot;
                    }
                }
            }
        }
        return null;
    }

    public int generateRandomNumber(int rangeStart, int rangeEnd){
        return (int) ((Math.random() * (rangeEnd - rangeStart)) + rangeStart);
    }

    public void setVehicleOnSpot(Spot spot, Vehicle vehicle) {
        spot.setVehicle(vehicle);
    }

    public void vacateSpot(Spot spot){
        spot.setVehicle(null);
    }
}
