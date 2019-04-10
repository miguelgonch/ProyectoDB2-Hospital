function getValue(variable)
{
    var value = document.getElementById(variable).value;
    if (value !== null || value !== "") {
        return value;
    } else {
        return("");
    }
}
function getHorario() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/proyectoDB2-Hospitales/restC/cita/getDisp',
        dataType: 'json',
        data: {
            fecha: getValue('fecha'),
            docId: getValue('doctoresData')

        },
        success: function (data) {
            var $pData = $('#horariosData');
            for (var i = 0; i < data.length; i++) {
                $pData.append("<option value=" + data[i].hora + ">" + data[i].hora + "</option>");
            }
            if (data.length == 0) {
                $pData.append("<optgroup>No hay horarios disponibles</optgroup>");
            }
        },
        error: function () {
            var $pData = $('#horariosData');
            $pData.empty();
            $pData.append("<p>No hay datos disponibles</p>");
        }
    });
}
$(document).ready(
        function () {
            setTimeout(function() {
                getHorario();
            }, 0600);
        },
        document.getElementById('doctoresData').onchange = function () {
            getHorario();
        },
        document.getElementById('fecha').onchange = function () {
            getHorario();
        });
