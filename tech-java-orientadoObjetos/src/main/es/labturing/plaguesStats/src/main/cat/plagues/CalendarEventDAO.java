package main.cat.plagues;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CalendarEventDAO {

    private static final String DIRECTORY = "./src/main/resources";
    private static final String FILE = "datosLimited.ics";
    private static final File directory = new File(CalendarEventDAO.DIRECTORY);
    private final int calendarEventLines = 12;
    private List<String> lineList;

    public List<CalendarEvent> read() {
        File file = new File(CalendarEventDAO.directory, CalendarEventDAO.FILE);
        List<CalendarEvent> calendarEvents = new ArrayList<CalendarEvent>();
        this.createFormatedLines(file);
        CalendarEvent calendarEvent = new CalendarEvent();
        int linesCounter = 0;
        for (String line : this.lineList) {
            if (linesCounter < calendarEventLines) {
                String separated[] = line.split(":", 2);
                String methodString = "set" + separated[0];
                linesCounter++;
                if (linesCounter != calendarEventLines) {
                    try {
                        Method method = calendarEvent.getClass().getMethod(methodString, String.class);
                        method.invoke(calendarEvent, separated[1]);
                    } catch (Exception e) {
                        System.out.println("error java reflexion: " + e.getMessage());
                    }
                } else {
                    calendarEvents.add(calendarEvent);
                    linesCounter = 0;
                    calendarEvent = new CalendarEvent();
                }
            }
        }
        return calendarEvents;
    }

    private void createFormatedLines(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int lineCounter = 0;
            String line;
            this.lineList = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                if (line.charAt(0) != ' ') {
                    this.lineList.add(line);
                    lineCounter++;
                } else {
                    String previousLine = lineList.get(lineCounter - 1);
                    line = previousLine + line;
                    this.lineList.remove(lineCounter - 1);
                    this.lineList.add(line);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("error lectura: " + e.getMessage());
        }
    }
}
