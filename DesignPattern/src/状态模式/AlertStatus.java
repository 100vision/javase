package 状态模式;

interface AlertStatus {
    void alert();
}

class AttentionAlert implements AlertStatus {

    @Override
    public void alert() {
        System.out.println("Attention!");
    }
}

class WarningAlert implements AlertStatus {

    @Override
    public void alert() {
        System.out.println("Warning!");
    }
}


