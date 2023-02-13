package es.usantatecla.companyManagement.menu;

public enum Message {

    CANCEL(new String[] { "Cancelar (fecha)", "Cancel (date)" }),
    ENLARGE(new String[] { "Redimensionar (rango de horas)", "Enlarge (range of hours)" }),
    EXIT(new String[] { "Salir", "Exit" }),
    TOTAL_COST(new String[] { "Costo total", "Total cost" }),
    SHIFT(new String[] { "Desplazar (rango de horas)", "Shift (range of hours)" }),
    SHOW(new String[] { "Mostrar (fecha - rango de horas)", "Show (date - range of hours)" }),
    BYE(new String[] { "\nHasta la próxima!", "\nSee you latter!" }),
    MENU_TITLE_PRE(new String[] { "Gestión del contrato \"", "Contract management of \"" }),
    MENU_TITLE_POST(new String[]{ "\" para el año ", "\" at year " }),
    MENU_SUBTITLE(new String[] { "ACCIONES", "ACTIONS" }),
    MENU_SELECT_ERROR_PRE(new String[] { "ERROR! Introduzca una opción válida [1-", "ERROR! Insert valid option [1-" }),
    MENU_SELECT_ERROR_POST(new String[] { "] \n", "] \n" }),
    MENU_READ_ERROR_PRE(new String[] { "Seleccionar [1-", "Select [1-" }),
    MENU_READ_ERROR_POST(new String[] { "]: ", "]: " }),
    MENU_SEPARATOR(new String[] { ": ", ": " }),
    SERVICE_CONTRACT_ENLARGE(new String[] { "Multiplicador para redimensionar [ valor >0.1 o <-0.1]: ", "Multiplier to resize [ value >0.1 or <-0.1]: " }),
    SERVICE_CONTRACT_ENLARGE_ERROR(new String[] { "ERROR! Escalado incorrecto [ valor > 0.1 o < -0.1]", "ERROR! incorret resize [ value > 0.1 or < -0.1]" }),
    SERVICE_CONTRACT_SHIFT(new String[] { "Valor para desplazar: ", "Shift value: " }),
    SERVICE_CONTRACT_COST_PRE(new String[] {"\nCosto anual total: ", "\nTotal anual cost: "}),
    SERVICE_CONTRACT_COST_POST(new String[] {"-euros\n", "-euros\n"}),
    SERVICE_GETDATE(new String[] {"Día y mes [dd/mm]: ","Day and Month [dd/mm]: "}),
    SERVICE_GETDATE_ERROR(new String[] {"ERROR! Formato día y mes [dd/mm]","ERROR! Wrong day and month format [dd/mm]"});
    
    
    

    private String[] menasje;

    private Message(String[] menasje){
        this.menasje = menasje;
    }
    
    public String getCustomLanguajeMessage(Languaje languaje){
        return this.menasje[languaje.ordinal()];
    }
}
