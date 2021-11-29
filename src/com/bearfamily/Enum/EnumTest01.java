package com.bearfamily.Enum;

public class EnumTest01 {
    public static void main(String[] args) {
        System.out.println(Weekday.SAT);

        BuildState buildState = BuildState.NOTSTARTED;
        switch (buildState) {
            case CLOSING:
                System.out.println("machine is closing");
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


