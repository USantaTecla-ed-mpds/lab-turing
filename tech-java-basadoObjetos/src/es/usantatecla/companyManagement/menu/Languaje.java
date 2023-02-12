package es.usantatecla.companyManagement.menu;

public enum Languaje {

    CANCEL(new String[] { "Cancelar (fecha)", "Cancel" }),
    ENLARGE(new String[] { "Redimensionar (rango de horas)", "Enlarge" }),
    EXIT(new String[] { "Salir", "Exit" }),
    TOTAL_COST(new String[] { "Costo total", "Total cost" }),
    SHIFT(new String[] { "Desplazar (rango de horas)", "Shift" }),
    SHOW(new String[] { "Mostrar (fecha - rango de horas)", "Show" });
    
    private String[] title;

    private Languaje(String[] title){
        this.title = title;
    }
    
    public String getTitle(int languaje){
        return this.title[languaje];
    }
}
