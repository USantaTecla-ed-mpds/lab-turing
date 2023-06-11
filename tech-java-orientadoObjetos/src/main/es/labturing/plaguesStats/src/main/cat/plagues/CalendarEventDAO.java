package main.es.labturing.plaguesStats.src.main.cat.plagues;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarEventDAO {

    private static final String DIRECTORY = "./tech-java-orientadoObjetos/src/main/es/labturing/plaguesStats/src/main/resources";
    private static final String FILE = "datosLimited.ics";
    private static final File directory = new File(CalendarEventDAO.DIRECTORY);
    private File file;
    private List<CalendarEvent> calendarEvents;
    private List<String> lineList;
    private final Map<Tag, String> methodsMap = new HashMap<Tag, String>();

    public CalendarEventDAO() {
        this.methodsMap.put(Tag.dateStart, "setStart");
        this.methodsMap.put(Tag.dateEnd, "setEnd");
        this.methodsMap.put(Tag.allDayDateStart, "setStart");
        this.methodsMap.put(Tag.allDayDateEnd, "setEnd");
        this.methodsMap.put(Tag.timeStamp, "setTimeStamp");
        this.methodsMap.put(Tag.created, "setCreated");
        this.methodsMap.put(Tag.status, "setStatus");
        this.methodsMap.put(Tag.summary, "setSummary");
        this.file = new File(CalendarEventDAO.directory, CalendarEventDAO.FILE);
        this.calendarEvents = new ArrayList<CalendarEvent>();
    }

    public List<CalendarEvent> read() {

        this.createFormatedLines();

        boolean isEventBegin = false;
        CalendarEvent calendarEvent = new CalendarEvent();

        for (String line : this.lineList) {
            if (line.equals(Tag.beginEvent.getTagString())) {
                isEventBegin = true;
            } else if (line.equals(Tag.endEvent.getTagString())) {
                calendarEvents.add(calendarEvent);
                calendarEvent = new CalendarEvent();
                isEventBegin = false;
            }
            if (isEventBegin) {
                String separated[] = line.split(":", 2);
                String methodString = separated[0];
                if (Tag.get(methodString) != null && this.methodsMap.containsKey(Tag.get(methodString))) {
                    try {
                        Method method = calendarEvent.getClass().getMethod(methodsMap.get(Tag.get(methodString)),
                                String.class);
                        method.invoke(calendarEvent, separated[1]);
                    } catch (Exception e) {
                        System.out.println("Error reflect: " + e.getMessage());
                    }
                }
            }

        }
        return this.calendarEvents;
    }

    private void createFormatedLines() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.file));
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
