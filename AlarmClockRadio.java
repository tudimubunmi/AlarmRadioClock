public class AlarmClockRadio {
    public static void main(String[] args) {
        int i;

        AlarmClock myClock = new AlarmClock(8, 0, 0, "AM", 8, 0, 5, "AM");

        Radio radio = new Radio(1060, "AM");
        String status = radio.setRadioStatus("off");

        if (status.equals("off")) {
            System.out.println("Time: " + myClock.showTime() + " The radio was turned " + status + " and is playing " + radio.getRadio());
        }
        else{
            System.out.println("Time: " + myClock.showTime() + " The radio was turned " + status + ".");
        }
        myClock.checkAlarm(radio.getRadio(), status);

        while (!myClock.checkAlarm(radio.getRadio(), status)) {
            myClock.tick();
            System.out.println("Time: " + myClock.showTime());
        }

        myClock.snooze();

        for (i = 0; i < 9; i++)
        {
            myClock.tick();
            System.out.println("Time: " + myClock.showTime());
            myClock.checkAlarm(radio.getRadio(), status);

        }
        myClock.AlarmOff();
    }
}
