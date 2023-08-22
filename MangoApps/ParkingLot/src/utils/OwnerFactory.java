package utils;

import repositories.OwnerRepository;

public class OwnerFactory {
    private static OwnerRepository ownerInstance;
    private OwnerFactory(){

    }
    public static OwnerRepository getInstance() {
        if (ownerInstance == null) {
            synchronized (OwnerRepository.class) {
                if (ownerInstance == null) {
                    ownerInstance = new OwnerRepository();
                }
            }
        }
        return ownerInstance;
    }
}
