package area.model;

import java.io.Serializable;


public class TableRecord implements Serializable {
    private String startTime;
    private String executionTimeNano;
    private String r;
    private String x;
    private String y;
    private String result;


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public String getExecutionTimeNano() {
        return executionTimeNano;
    }

    public void setExecutionTimeNano(String executionTimeNano) {
        this.executionTimeNano = executionTimeNano;
    }


    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }


    public String getX() {
        return x;
    }


    public void setX(String x) {
        this.x = x;
    }


    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
