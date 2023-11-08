const validators = {
    isFormInputValid : function() {
        return validators.isRInputValid() && validators.isXInputValid() && validators.isYInputValid();
    },

    isRInputValid : function() {
        const inputId = "r";

        let rElement = $("#r");
        let r = rElement.val();
        let min = 2, max = 5;

        if (!$.isNumeric(r)) {
            errMsg.html("Радиус должен быть числом типа Float");
            return false;
        }

        r = roundTwoSigns(r);
        rElement.val(r);

        if (r <= min || r >= max) {
            errMsg.html("Радиус вне допустимого диапазона");
            return false;
        }
        errMsg.html("");
        return true;

    },

    isXInputValid : function() {

        let xElement = $("#x");
        let x = xElement.val();
        let min = -3, max = 5;

        if (!$.isNumeric(x)) {
            errMsg.html("Х должен быть числом типа Float");
            return false;
        }

        x = roundTwoSigns(x);
        xElement.val(x);

        if (x <= min || x >= max) {
            errMsg.html("Х вне допустимого диапазона");
            return false;
        }
        errMsg.html("");
        return true;

    },

    isYInputValid : function () {
        if ($('input[name="y"]').is(':checked')) {
            errMsg.html("");
            return true;
        }
        errMsg.html("Введите Y");
        return false;
    }
}

export default validators;


function roundTwoSigns(number) {
    return Math.round(number * 100) / 100
}

const errMsg = $("#err-msg");

function setErrMsg(errMsg) {
    errMsg.html(errMsg);
}

function clearErrMsg() {
    errMsg.html("");
}
