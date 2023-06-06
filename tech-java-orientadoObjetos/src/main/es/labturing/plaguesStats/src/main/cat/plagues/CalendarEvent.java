package main.cat.plagues;

public class CalendarEvent {

    private int sequence;
    private boolean status;
    private String summary;
    private boolean transparency;
    public String end;
    public String begin;
    public String dateStart;
    public String dateEnd;
    public String timeStamp;
    public String UID;
    public String created;

    public String getSummary(){
        return this.summary;
    }

    public void setSEQUENCE(String sequence) {
        this.sequence = Integer.parseInt(sequence);
    }
    public void setSTATUS(String status) {
        if(status.equals("CONFIRMED")){
            this.status = true;
        } else {
            this.status = false;
        }
    }
    public void setSUMMARY(String summary) {
        this.summary = summary;
    }
    public void setTRANSP(String transparency) {
        if(transparency.equals("OPAQUE")){
            this.transparency = false;
        } else {
            this.transparency = true;
        }
    }
    public void setEND(String end) {
        this.end = end;
    }
    public void setBEGIN(String begin) {
        this.begin = begin;
    }
    public void setDTSTART(String dateStart) {
        //LocalDate date = LocalDate.parse(dateStart, DateTimeFormatter.ISO_INSTANT);
        this.dateStart = dateStart;
    }
    public void setDTEND(String dateEnd) {
        this.dateEnd = dateEnd;
    }
    public void setDTSTAMP(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    public void setUID(String uID) {
        UID = uID;
    }
    public void setCREATED(String created) {
        this.created = created;
    }
    
}
