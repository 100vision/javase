package com.bearfamily.Enum;

public class Machine {
    private long id;
    private String name;
    private BuildState machineState = BuildState.NOTSTARTED;

    public BuildState getMachineState() {
        return machineState;
    }

    public void setMachineState(BuildState machineState) {
        this.machineState = machineState;
    }
}
