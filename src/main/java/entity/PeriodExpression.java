package entity;

/**
 * 周期表达式
 */
public class PeriodExpression {
    /** 周期间隔：N个周期单位 */
    private int periodInterval;

    /** 周期单位：1-月、2-年 */
    private int periodUnit;

    /** 当间隔有N个周期单位时，从第几个周期单位开始，比如按2个月周期，从第2个月的5号开始 */
    private int intervalStartIndex;

    /** 当间隔有N个月时，从指定周期的哪天开始 */
    private int intervalDayIndex;

    /** 按合同指定时段计费开始时间 */
    private String periodStart;

    /** 按合同指定时段计费结束时间 */
    private String periodEnd;

    /** 几个计费周期聚合为一个计费周期 */
    private Integer chargingPeriodNum;

    public int getPeriodInterval() {
        return periodInterval;
    }

    public void setPeriodInterval(int periodInterval) {
        this.periodInterval = periodInterval;
    }

    public int getPeriodUnit() {
        return periodUnit;
    }

    public void setPeriodUnit(int periodUnit) {
        this.periodUnit = periodUnit;
    }

    public int getIntervalStartIndex() {
        return intervalStartIndex;
    }

    public void setIntervalStartIndex(int intervalStartIndex) {
        this.intervalStartIndex = intervalStartIndex;
    }

    public int getIntervalDayIndex() {
        return intervalDayIndex;
    }

    public void setIntervalDayIndex(int intervalDayIndex) {
        this.intervalDayIndex = intervalDayIndex;
    }

    public String getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(String periodStart) {
        this.periodStart = periodStart;
    }

    public String getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(String periodEnd) {
        this.periodEnd = periodEnd;
    }

    public Integer getChargingPeriodNum() {
        return chargingPeriodNum;
    }

    public void setChargingPeriodNum(Integer chargingPeriodNum) {
        this.chargingPeriodNum = chargingPeriodNum;
    }

}
