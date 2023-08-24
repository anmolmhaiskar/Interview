package services;

import exceptions.InvalidOwnerDetailsException;
import models.Owner;
import models.Payment;
import models.Ticket;
import repositories.OwnerRepository;
import utils.OwnerFactory;

public class OwnerService {

    public static OwnerRepository ownerRepository = OwnerFactory.getInstance();

    public static Owner createOwner(String name, String phoneNo, String gender, int age){
        validateParamters(name, phoneNo, gender, age);
        return ownerRepository.createOwner(name, phoneNo, gender, age);
    }

    public static void validateParamters(String name, String phoneNo, String gender, int age){
        if(name == null || name.isEmpty()){
            throw new InvalidOwnerDetailsException(String.format("Invalid value of owner's name %s is provided", name));
        }

        if(phoneNo == null || phoneNo.isEmpty() || phoneNo.length()>10 || phoneNo.length()<10){
            throw new InvalidOwnerDetailsException(String.format("Invalid value of owner's phoneNo %s is provided", phoneNo));
        }

        if(gender == null || gender.isEmpty()){
            throw new InvalidOwnerDetailsException(String.format("Invalid value of owner's gender %s is provided", gender));
        }

        if(age < 18 || age > 80){
            throw new InvalidOwnerDetailsException(String.format("Owner is not legalized to drive a while because is age is %s", age));
        }
    }

    public static void addPayment(Owner owner, Payment payment) {
        ownerRepository.addPayments(owner, payment);
    }
}
