package main.es.labturing.plaguesStats.src.main.cat.plagues;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalendarEvent {

    private LocalDate dateStart;
    private LocalDate dateEnd;
    private LocalDate timeStamp;
    private LocalDate created;
    private String status;
    private String summary;
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    public String getSummary() {
        return this.summary;
    }

    public String getData() {
        return "Status: " + this.status + " /Start: " + this.dateStart + " /End: " + this.dateEnd + " /TimeStamp: "
                + this.timeStamp + " /Created: " + this.created;
    }

    public LocalDate getDateStart() {
        return this.dateStart;
    }

    public void setStart(String dateStart) {
        if (dateStart == null) {
            System.out.println("setDate: " + dateStart);

        }
        this.dateStart = LocalDate.parse(dateStart.substring(0, 8), this.FORMATTER);

    }

    public void setEnd(String dateEnd) {

        this.dateEnd = LocalDate.parse(dateEnd.substring(0, 8), this.FORMATTER);
    }

    public void setTimeStamp(String timeStamp) {

        this.timeStamp = LocalDate.parse(timeStamp.substring(0, 8), this.FORMATTER);
    }

    public void setCreated(String created) {

        this.created = LocalDate.parse(created.substring(0, 8), this.FORMATTER);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
