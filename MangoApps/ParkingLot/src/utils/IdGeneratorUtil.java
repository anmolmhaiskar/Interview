package utils;

import java.security.SecureRandom;
import java.util.HashSet;

public class IdGeneratorUtil {

    public static int generateID(Object obj){
        return switch (obj.getClass().getSimpleName()) {
            case "Attendant" -> Constants.ATTENDANT_ID.getAndIncrement();
            case "Owner" -> Constants.OWNER_ID.getAndIncrement();
            case "Payment" -> Constants.PAYMENT_ID.getAndIncrement();
            case "Vehicle" -> Constants.VEHICLE_ID.getAndIncrement();
            case "Ticket" -> Constants.TICKET_NO.getAndIncrement();
            case "Spot" -> Constants.SPOT_ID.getAndIncrement();
            default -> 0;
        };
    }

    public static String generateRegistrationNo(int length, String state){

        final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String NUMBERS = "0123456789";

            SecureRandom random = new SecureRandom();
            StringBuilder codeBuilder = new StringBuilder(state.substring(0,2).toUpperCase());
            int alphabetCount = 0;
            // Generate 2 random alphabets and 2 random numbers
            for (int i = 0; i < length; i++) {
                if(codeBuilder.length()>=length){
                    break;
                }
                int randomIntIndex = random.nextInt(NUMBERS.length());
                codeBuilder.append(NUMBERS.charAt(randomIntIndex));

                if(alphabetCount < 2){
                    int randomStringIndex = random.nextInt(ALPHABETS.length());
                    codeBuilder.append(ALPHABETS.charAt(randomStringIndex));
                    alphabetCount++;
                }
            }


        String code = codeBuilder.toString();
        HashSet<String> registrationNoSet = VehicleFactory.getInstance().getRegistrationNos();
        if ( registrationNoSet!= null && !registrationNoSet.contains(code)) {
            registrationNoSet.add(code);
            System.out.println("Generated Vehicle Registration No. : " + code);
        }

        return code;
    }
}
