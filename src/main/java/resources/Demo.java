package resources;

import display.Display;
import display.SwingDisplay;
import driver.Fleet;
import service.Car;
import service.Location;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

        Platform pf = new Platform();
//        display.Display displ = new display.TextDisplay();
        Display disp = new SwingDisplay();

        App app = new App(pf, disp);

        ArrayList<Fleet> fleets = new ArrayList<Fleet>();

        // repeat the following for each fleet to be added,
        {
            Fleet f1 = new Fleet("blue"); // note: colour currently not used by display.Display
            pf.addFleet(f1);
            fleets.add(f1);

            f1 = new Fleet("blue"); // note: colour currently not used by display.Display
            pf.addFleet(f1);
            fleets.add(f1);
        }

        // instantiate cars for the fleets
        int j = 1;
        for (Fleet fleet: fleets) {
            for (int i = 0; i < 5; i++) {
                fleet.addCar(20 + i); // add cars, assigning max speed to each car
            }

            ArrayList<? extends Car> cars = fleet.getCars();
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).setLocation(new Location(j * 40, i * 50 + 10*j));
            }
            j++;
        }

        // start the app - populate the display and run the simulation
        app.init();

        // This will be replaced by callbacks from display.Display once the UI is in place

        disp.requestTrip(new Location(10, 10), new Location(200,200));
        disp.requestTrip(new Location(250, 100), new Location(100,300));
    }
}
