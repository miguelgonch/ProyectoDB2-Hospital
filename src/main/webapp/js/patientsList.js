$(document).ready(
        function() {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2-Hospitales/GetPatient',
                dataType: 'json',
                success: function(data) {
                    var $pData = $('#patients');
                    $pData.empty();
                    for (var i = 0; i < data.length; i++) {
                        $pData.append("<option value="+data[i].id+">"+data[i].nombre+" "+data[i].apellido+"</option>");
                    }
                    if(data.length==0){
                        $pData.append("<p>No hay datos disponibles</p>");
                    }
                },
                error : function() {
                    var $pData = $('#patientData');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});
