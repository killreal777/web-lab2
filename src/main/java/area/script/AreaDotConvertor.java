package area.script;

import area.exceptions.AreaDotConversionException;
import area.model.AreaDot;


class AreaDotConvertor {
    protected AreaDot convert(String r, String x, String y) {
        AreaDot areaDot = new AreaDot();
        setFields(areaDot, r, x, y);
        return areaDot;
    }

    private void setFields(AreaDot areaDot, String r, String x, String y) {
        areaDot.setR(convertToFloat(r));
        areaDot.setX(convertToFloat(x));
        areaDot.setY(convertToFloat(y));
    }

    private float convertToFloat(String number) {
        try {
            return Float.parseFloat(number);
        } catch(NumberFormatException e){
            throw new AreaDotConversionException();
        }
    }
}
