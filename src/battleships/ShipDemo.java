package battleships;

import battleships.ship.Aeroplane;
import battleships.ship.Battleship;
import battleships.ship.SimpleShip;

public class ShipDemo {
    public static void main() {
        Ship s = new Aeroplane();

        System.out.println(s);
        s.rotate();
        System.out.println(s);
        s.rotate();
        System.out.println(s);
        s.rotate();
        System.out.println(s);


    }
}
