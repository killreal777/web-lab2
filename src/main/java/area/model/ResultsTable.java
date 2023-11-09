package area.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class ResultsTable implements Serializable {
    private List<TableRecord> records;

    public ResultsTable() {
        this.records = new LinkedList<>();
    }

    public List<TableRecord> getRecords() {
        return records;
    }

    public void setRecords(List<TableRecord> records) {
        this.records = records;
    }
}
