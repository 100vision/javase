package 状态模式;

public class StateModeOperation {

    public static void main(String[] args) {
        StarShip ship = new StarShip();
        ship.sendAlert();
        ship.change();
        ship.sendAlert();
    }

}
