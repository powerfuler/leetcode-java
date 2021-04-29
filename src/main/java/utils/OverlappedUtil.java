package utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class OverlappedUtil {


    /**
     * 判断两个时间段是否重叠
     * @param slot1
     * @param slot2
     * @return
     */
    public static boolean overlapped(TimeSlot slot1, TimeSlot slot2) {
        TimeSlot previous, next;
        previous = slot1.startTime.isBefore(slot2.startTime) ? slot1 : slot2;
        next = slot2.startTime.isAfter(slot1.startTime) ? slot2 : slot1;
        // 这里业务需要，不允许时间点的重叠
        // 例如某个时间段的起始时间：2020-06-29 00:00:00
        // 和另一个时间段的终止时间：2020-06-29 00:00:00
        // 它们俩不可以有交点。如果不需要这种逻辑只把lt改成le
        // ，gt改成ge就可
        return !(lt(previous, next) || gt(previous, next));
    }

    /**
     * 构造一个时间段
     * @param startTime
     * @param endTime
     * @return
     */
    public static TimeSlot buildSlot(Timestamp startTime, Timestamp endTime) {

        return new TimeSlot(startTime.toLocalDateTime(), endTime.toLocalDateTime());
    }

    /**
     * less equal
     * 小于等于
     * @param prev
     * @param next
     * @return
     */
    private static boolean le(TimeSlot prev, TimeSlot next) {
        return lt(prev, next) || next.endTime.isEqual(prev.startTime);
    }

    /**
     * greater equal
     * 大于等于
     * @param prev
     * @param next
     * @return
     */
    private static boolean ge(TimeSlot prev, TimeSlot next) {
        return gt(prev, next) || prev.endTime.isEqual(next.startTime);
    }

    /**
     * greater than
     * 大于
     * @param prev
     * @param next
     * @return
     */
    private static boolean gt(TimeSlot prev, TimeSlot next) {
        return prev.endTime.isBefore(next.startTime);
    }

    /**
     * less than
     * 小于
     * @param prev
     * @param next
     * @return
     */
    private static boolean lt(TimeSlot prev, TimeSlot next) {
        return next.endTime.isBefore(prev.startTime);
    }

    /**
     * 时间段类
     */
    static class TimeSlot{
        private LocalDateTime startTime;
        private LocalDateTime endTime;

        public TimeSlot(LocalDateTime startTime, LocalDateTime endTime) {
            if (startTime.isAfter(endTime)) {
                this.startTime = endTime;
                this.endTime = startTime;
            } else {
                this.startTime = startTime;
                this.endTime = endTime;
            }
        }
    }
}
