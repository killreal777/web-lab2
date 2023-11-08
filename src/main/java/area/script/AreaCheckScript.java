package area.script;

import area.model.AreaDot;
import area.model.TableRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AreaCheckScript {
    private final AreaDotConvertor areaDotConvertor;
    private final AreaDotValidator areaDotValidator;
    private final HitChecker hitChecker;

    public AreaCheckScript() {
        this.areaDotConvertor = new AreaDotConvertor();
        this.areaDotValidator = new AreaDotValidator();
        this.hitChecker = new HitChecker();
    }

    public TableRecord execute(String r, String x, String y) {
        TableRecordCreator tableRecordCreator = new TableRecordCreator();
        tableRecordCreator.writeStartTime();
        AreaDot areaDot = areaDotConvertor.convert(r, x, y);
        areaDotValidator.validate(areaDot);
        tableRecordCreator.writeAreaDot(areaDot);
        tableRecordCreator.writeResult(hitChecker.isHit(areaDot));
        tableRecordCreator.writeExecutionTime();
        return tableRecordCreator.getRecord();
    }
}
