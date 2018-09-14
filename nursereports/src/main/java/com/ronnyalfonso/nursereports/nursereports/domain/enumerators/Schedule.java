package com.ronnyalfonso.nursereports.nursereports.domain.enumerators;

/**
 * By Ron on 9/9/2018
 */
public enum Schedule {
    SUNDAYMORNING(WeekDay.SUNDAY, DayTime.AM),
    SUNDAYNOON(WeekDay.SUNDAY, DayTime.NOON),
    SUNDAYEVENING(WeekDay.SUNDAY, DayTime.PM),
    SUNDAYNIGHT(WeekDay.SUNDAY, DayTime.BT),

    MONDAYMORNING(WeekDay.MONDAY, DayTime.AM),
    MONDAYNOON(WeekDay.MONDAY, DayTime.NOON),
    MONDAYEVENING(WeekDay.MONDAY, DayTime.PM),
    MONDAYNIGHT(WeekDay.MONDAY, DayTime.BT),

    TUESDAYMORNING(WeekDay.TUESDAY, DayTime.AM),
    TUESDAYNOON(WeekDay.TUESDAY, DayTime.NOON),
    TUESDAYEVENING(WeekDay.TUESDAY, DayTime.PM),
    TUESDAYNIGHT(WeekDay.TUESDAY, DayTime.BT),

    WEDNESDAYMORNING(WeekDay.WEDNESDAY, DayTime.AM),
    WEDNESDAYNOON(WeekDay.WEDNESDAY, DayTime.NOON),
    WEDNESDAYEVENING(WeekDay.WEDNESDAY, DayTime.PM),
    WEDNESDAYNIGHT(WeekDay.WEDNESDAY, DayTime.BT),

    THURSDAYMORNING(WeekDay.THURSDAY, DayTime.AM),
    THURSDAYNOON(WeekDay.THURSDAY, DayTime.NOON),
    THURSDAYEVENING(WeekDay.THURSDAY, DayTime.PM),
    THURSDAYNIGHT(WeekDay.THURSDAY, DayTime.BT),

    FRIDAYMORNING(WeekDay.FRIDAY, DayTime.AM),
    FRIDAYNOON(WeekDay.FRIDAY, DayTime.NOON),
    FRIDAYEVENING(WeekDay.FRIDAY, DayTime.PM),
    FRIDAYNIGHT(WeekDay.FRIDAY, DayTime.BT),

    SATURDAYMORNING(WeekDay.SATURDAY, DayTime.AM),
    SATURDAYNOON(WeekDay.SATURDAY, DayTime.NOON),
    SATURDAYEVENING(WeekDay.SATURDAY, DayTime.PM),
    SATURDAYNIGHT(WeekDay.SATURDAY, DayTime.BT);


    private final WeekDay day;
    private final DayTime time;

    Schedule(WeekDay day, DayTime time) {
        this.day = day;
        this.time = time;
    }
}
