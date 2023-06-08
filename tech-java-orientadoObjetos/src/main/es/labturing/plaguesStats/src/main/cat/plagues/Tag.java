package main.es.labturing.plaguesStats.src.main.cat.plagues;

public enum Tag {

    beginEvent("BEGIN:VEVENT"),
    endEvent("END:VEVENT"),
    begin("BEGIN"),
    end("END"),
    dateStart("DTSTART"),
    dateEnd("DTEND"),
    allDayDateStart("DTSTART;VALUE=DATE"),
    allDayDateEnd("DTEND;VALUE=DATE"),
    timeStamp("DTSTAMP"),
    created("CREATED"),
    status("STATUS"),
    summary("SUMMARY");

    private String tagString;

    private Tag(String tagString) {
        this.tagString = tagString;
    }

    public String getTagString() {
        return this.tagString;
    }

    public static Tag get(String tagString) {
        for(Tag t : Tag.values()){
            if(t.tagString.equals(tagString)){
                return t;
            }
        }
        return null;
    }

}
