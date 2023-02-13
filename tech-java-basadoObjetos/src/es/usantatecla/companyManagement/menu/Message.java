package es.usantatecla.companyManagement.menu;

public enum Message {

    CANCEL(new String[] { "Cancelar (fecha)", "Cancel (date)" }),
    ENLARGE(new String[] { "Redimensionar (rango de horas)", "Enlarge (range of hours)" }),
    EXIT(new String[] { "Salir", "Exit" }),
    TOTAL_COST(new String[] { "Costo total", "Total cost" }),
    SHIFT(new String[] { "Desplazar (rango de horas)", "Shift (range of hours)" }),
    SHOW(new String[] { "Mostrar (fecha - rango de horas)", "Show (date - range of hours)" }),
    BYE(new String[] { "Hasta la próxima!", "See you latter!" }),
    MENU_TITLE_PRE(new String[] { "Gestión del contrato \"", "Contract management of \"" }),
    MENU_TITLE_POST(new String[]{ "\" para el año ", "\" at year " }),
    MENU_SUBTITLE(new String[] { "ACCIONES", "ACTIONS" }),
    MENU_SELECT_ERROR_PRE(new String[] { "ERROR! Introduzca una opción válida [1-", "ERROR! Insert valid option [1-" }),
    MENU_SELECT_ERROR_POST(new String[] { "] \n", "] \n" }),
    MENU_READ_ERROR_PRE(new String[] { "Seleccionar [1-", "Select [1-" }),
    MENU_READ_ERROR_POST(new String[] { "]: ", "]: " }),
    MENU_SEPARATOR(new String[] { ": ", ": " });
    
    
    

    private String[] menasje;

    private Message(String[] menasje){
        this.menasje = menasje;
    }
    
    public String getCustomLanguajeMessage(int languaje){
        return this.menasje[languaje];
    }
}
