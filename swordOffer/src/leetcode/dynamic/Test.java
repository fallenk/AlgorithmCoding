package leetcode.dynamic;


import java.util.Scanner;
class time {
    private int hour;
    private int minute;

    public time(String time) {
        String[] times = time.split(":");
        hour = Integer.parseInt(times[0]);
        minute = Integer.parseInt(times[1]);
    }

    public int gethour() {
        return hour;
    }

    public int getminute() {
        return minute;
    }
}
public class Test {
}