package 状态模式;

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
