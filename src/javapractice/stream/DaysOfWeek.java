package javapractice.stream;

import java.util.stream.Stream;

public enum DaysOfWeek {
    SUNDAY("off"),
    MONDAY("working"),
    TUESDAY("working"),
    WEDNESDAY("working"),
    THURSDAY("working"),
    FRIDAY("working"),
    SATURDAY("off");

    private String typeOfDay;

    DaysOfWeek(String typeOfDay) {
        this.typeOfDay = typeOfDay;
    }

    public static Stream<DaysOfWeek> stream() {
        return Stream.of(DaysOfWeek.values());
    }

    public static void main(String[] args) {
        DaysOfWeek.stream().filter(d->d.typeOfDay().equals("off")).forEach(System.out::println);
    }

    private String typeOfDay() {
        return this.typeOfDay;
    }

}

