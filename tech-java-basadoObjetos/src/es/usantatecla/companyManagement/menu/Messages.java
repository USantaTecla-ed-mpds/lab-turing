package es.usantatecla.companyManagement.menu;

public enum Messages {

    CANCEL(new String[] { "Cancelar (fecha)", "Cancel (date)" }),
    ENLARGE(new String[] { "Redimensionar (rango de horas)", "Enlarge (range of hours)" }),
    EXIT(new String[] { "Salir", "Exit" }),
    TOTAL_COST(new String[] { "Costo total", "Total cost" }),
    SHIFT(new String[] { "Desplazar (rango de horas)", "Shift (range of hours)" }),
    SHOW(new String[] { "Mostrar (fecha - rango de horas)", "Show (date - range of hours)" }),
    BYE(new String[] { "Hasta la próxima!", "See you latter!" });
    

    private String[] title;

    private Messages(String[] title){
        this.title = title;
    }
    
    public String getCustomLanguajeMessage(int languaje){
        return this.title[languaje];
    }
}
