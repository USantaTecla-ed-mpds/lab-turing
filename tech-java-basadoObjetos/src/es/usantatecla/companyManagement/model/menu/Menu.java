package es.usantatecla.companyManagement.model.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Option> options;

        public Menu() {
        this.options = new ArrayList<>();
        this.options.add(new ShowOption());
        this.options.add(new EnlargeOption());
        this.options.add(new ShiftOption());
        this.options.add(new CancelOption());
        this.options.add(new GetCostOption());
        this.options.add(new ExitOption());
    }

    public Option getOption(int position){
        assert position < this.options.size();
        return this.options.get(position);
    }

    public int getSize(){
        return this.options.size();
    }
}
