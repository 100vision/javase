package StatePattern;

import StatePattern.AlertStatus;
import StatePattern.AttentionAlert;
import StatePattern.WarningAlert;

class StarShip {

    AlertStatus status = new AttentionAlert();

    StarShip() {};

    public void change() {
        status = new WarningAlert();
    }

    public void sendAlert () {
        status.alert();
    }
}
