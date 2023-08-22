package repositories;

import models.Attendant;
import models.Entrance;
import services.EntranceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AttendantRepository {
    List<Attendant> attendants;
    public AttendantRepository(){
        attendants = new ArrayList<>();
    }

    public Attendant createAttendant(String name, int gateNo, String emailId, String phoneNo, String gender, int age){
        Attendant attendant = new Attendant(name, gateNo, emailId, phoneNo, gender, age);
        addAttendant(attendant);
        return attendant;
    }

    public void addAttendant(Attendant attendant){
        this.attendants.add(attendant);
    }

    public List<Attendant> getAttendants(){
        return this.attendants;
    }

    public void attendantGenerator() {
        List<Entrance> entrances = EntranceService.getEntrances();
        entrances.forEach(entrance -> {
            String name = "GateAttendant" + entrance.getGateNo();
            String email = name + "@gmail.com";
            String gender = "M";
            int age = (int) ((Math.random() * (60 - 25)) + 25);
            String phoneNo = String.valueOf((long) (new Random().nextDouble()*10000000000L));
            createAttendant(name, entrance.getGateNo(), email, phoneNo, gender, age);
        });
    }
}
