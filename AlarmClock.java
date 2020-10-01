public class AlarmClock extends Clock {
    protected int finHr, finMin, finSec;
    protected String finMer;
    boolean alarmStatus, snoozed;
    int snHr, snMin, snSec;

    public AlarmClock(int hr, int min, int sec, String mer, int hr2, int min2, int sec2, String mer2) {
        this.initHr = hr;
        this.initMin = min;
        this.initSec = sec;
        this.initMer = mer;
        this.finHr = hr2;
        this.finMin = min2;
        this.finMer = mer2;
        this.finSec = sec2;

    }

    public void setAlarm(int hr, int min, int sec, String mer) {
        alarmStatus = true;
        this.finHr = hr;
        this.finMin = min;
        this.finSec = sec;
        this.finMer = mer;
    }

    public String getAlarm() {
        return String.format("%d:%d%d %s", this.finHr, this.finMin, this.finSec, this.finMer);
    }

    public boolean isAlarmOn() {
        return alarmStatus;
    }

    public boolean checkAlarm(String s, String stat) {
        if (!snoozed) {
            if (this.initHr == this.finHr && this.initMin == this.finMin && this.initSec == this.finSec) {
                System.out.println(radioDisplay(s, stat));
                return true;
            } else {
                return false;
            }
        }
        else {
            if (this.initHr == this.snHr && this.initMin == this.snMin && this.initSec == this.snSec) {
                System.out.println(radioDisplay(s, stat));
                snoozed = false;
                return true;
            } else {
                return false;
            }
        }
    }

    public String radioDisplay(String s, String stat) {
        if (stat.equals("on")) {
            return "The radio is playing " + s;
        }
        else {
            return "The radio is not playing.";
        }
    }

    public void tick() {
        for (int i = 0; i < 60; i++) {}
        if (this.initSec == 9 && this.initMin != 5) {
            this.initMin += 1;
            this.initSec = 0;
        }
        else if (this.initMin == 5 && this.initSec == 9) {
            this.initHr += 1;
            this.initMin = 0;
            this.initSec = 0;
        }
        else {
            initSec += 1;
        }
    }

    public void snooze() {
        snoozed = true;
        if (finSec == 0){
            snSec = finSec + 9;
            snMin = finMin;
            snHr = finHr;
        }
        else if (finMin == 5 && finSec > 0){
            snHr = finHr + 1;
            snMin = 0;
            snSec = (9+finSec) - 10;
        }
        else {
            snSec = (9 + finSec) - 10;
            snMin = finMin + 1;
            snHr = finHr;
        }
        System.out.println("Snooze was pressed");
    }

    public void AlarmOn() {
        alarmStatus = true;
        System.out.println("The alarm was turned on.");
    }

    public void AlarmOff() {
        alarmStatus = false;
        System.out.println("The alarm was shut off.");
    }
}
