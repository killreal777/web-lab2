package area.model;

import java.io.Serializable;
import java.util.ArrayList;


public class ResultsTable implements Serializable {
    private ArrayList<TableRecord> table;

    public ResultsTable() {
        this.table = new ArrayList<>();
    }

    public ArrayList<TableRecord> getTable() {
        return table;
    }

    public void setTable(ArrayList<TableRecord> table) {
        this.table = table;
    }
}
