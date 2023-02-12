package es.usantatecla.utils;

public enum Month {
    
    JANUARY(31, new String[]{ "Enero", "January" }),
    FEBRUARY(28, new String[]{ "Febrero", "Februry" });

    private int days;
    private String[] langs;

    private Month(int days, String[] langs){
        this.days = days;
        this.langs = langs;
    }

    public static Month getMonth(int numberOfMonth){
        return Month.values()[numberOfMonth -1];
    }

    public int getNumberOfDays(){
        return this.days;
    }
}
