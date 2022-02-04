package rahulshettyacademy.PageComponents;

import rahulshettyacademy.AbstractComponents.SearchFlightAvailability;

import java.util.HashMap;

public class OneWayTrip implements SearchFlightAvailability {

    @Override
    public void checkAvailability(HashMap<String, String> reservationDetails) {
        System.out.println("In checkAvailability method of oneWayTrip class");
        System.out.println("change in the code");
    }


}
