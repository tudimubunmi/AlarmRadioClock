public class Clock {
    int initHr, initMin, initSec;
    String initMer;

    public void setTime(int hr, int min, int sec, String mer){
        initHr = hr;
        initMin = min;
        initSec = sec;
        initMer = mer;
    }

    public String showTime() {
        return String.format("%d:%d%d %s", initHr, initMin, initSec, initMer);
    }

}
