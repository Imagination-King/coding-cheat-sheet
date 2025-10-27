import java.time.LocalTime;
import java.util.Objects;

public class TimeOfDayTriple implements TimeOfDay {
    private final int hour;
    private final int minute;
    private final int second;

    public TimeOfDayTriple() {
        LocalTime now = LocalTime.now();
        this.hour = now.getHour();
        this.minute = now.getMinute();
        this.second = now.getSecond();
    }

    @Override
    public int getHour() {
        return hour;
    }

    @Override
    public int getMin() {
        return minute;
    }

    @Override
    public int getSec() {
        return second;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TimeOfDay)) return false;
        TimeOfDay other = (TimeOfDay) obj;
        return hour == other.getHour()
            && minute == other.getMin()
            && second == other.getSec();
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, second);
    }
}