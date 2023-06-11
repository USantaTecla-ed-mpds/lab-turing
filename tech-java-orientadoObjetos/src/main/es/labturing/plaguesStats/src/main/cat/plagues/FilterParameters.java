package main.es.labturing.plaguesStats.src.main.cat.plagues;

public class FilterParameters {

    private int year;
    private String searchWord;

    public FilterParameters(int year, String searchWord) {
        this.year = year;
        this.searchWord = searchWord;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

}
