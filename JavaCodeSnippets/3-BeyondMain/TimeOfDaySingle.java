import java.time.LocalTime;
import java.util.Objects;

public class TimeOfDaySingle implements TimeOfDay {
    private final int secondsSinceMidnight;

    public TimeOfDaySingle() {
        LocalTime now = LocalTime.now();
        this.secondsSinceMidnight = now.toSecondOfDay();
    }

    @Override
    public int getHour() {
        return secondsSinceMidnight / 3600;
    }

    @Override
    public int getMin() {
        return (secondsSinceMidnight % 3600) / 60;
    }

    @Override
    public int getSec() {
        return secondsSinceMidnight % 60;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", getHour(), getMin(), getSec());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TimeOfDay)) return false;
        TimeOfDay other = (TimeOfDay) obj;
        return getHour() == other.getHour()
            && getMin() == other.getMin()
            && getSec() == other.getSec();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHour(), getMin(), getSec());
    }
}
