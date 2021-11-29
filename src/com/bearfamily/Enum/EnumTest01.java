package com.bearfamily.Enum;

public class EnumTest01 {
    public static void main(String[] args) {


        Machine m = new Machine();
        m.setMachineState(BuildState.STARTED);

        if(m.getMachineState().isOperatinal()) {
            System.out.println("machine is open or started");
        }else {
            System.out.println("machine is not open. can't build ");
        }



        switch (m.getMachineState()) {
            case STARTED:
                System.out.println("machine is started");
                break;
            case INITIAILIZING:
                System.out.println("machien is intializing");
                break;
            case OPEN:
                System.out.println("machine is open now");
                break;
            case NOTSTARTED:
                System.out.println("machine is not started yet");
                break;
        }




    }
}


