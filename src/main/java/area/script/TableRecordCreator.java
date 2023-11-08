package area.script;

import area.model.AreaDot;
import area.model.TableRecord;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


class TableRecordCreator {
    private final TableRecord record;
    private long startTimeNano;


    protected TableRecordCreator() {
        this.record = new TableRecord();
    }


    protected void writeStartTime() {
        startTimeNano = System.nanoTime();
        String nowString = DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now());
        record.setStartTime(nowString);
    }

    protected void writeAreaDot(AreaDot areaDot) {
        record.setR(floatToString(areaDot.getR()));
        record.setX(floatToString(areaDot.getX()));
        record.setY(floatToString(areaDot.getY()));
    }

    private String floatToString(float number) {
        return new DecimalFormat("#0.00").format(number).replace(",", ".");
    }

    protected void writeResult(boolean hit) {
        String result = hit ? "Попал" : "Мимо";
        record.setResult(result);
    }

    protected void writeExecutionTime() {
        long endTimeNano = System.nanoTime();
        long executionTimeNano = endTimeNano - startTimeNano;
        record.setExecutionTimeNano(Long.toString(executionTimeNano));
    }


    public TableRecord getRecord() {
        return this.record;
    }
}
