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
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    public String getSummary() {
        return this.summary;
    }

    public LocalDate getStart() {
        return this.dateStart;
    }

    public void setStart(String dateStart) {
        this.dateStart = LocalDate.parse(dateStart.substring(0, 8), this.formatter);
    }

    public void setEnd(String dateEnd) {

        this.dateEnd = LocalDate.parse(dateEnd.substring(0, 8), this.formatter);
    }

    public void setTimeStamp(String timeStamp) {

        this.timeStamp = LocalDate.parse(timeStamp.substring(0, 8), this.formatter);
    }

    public void setCreated(String created) {

        this.created = LocalDate.parse(created.substring(0, 8), this.formatter);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
