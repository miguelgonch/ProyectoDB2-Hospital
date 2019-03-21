function query_string(variable)
{
   var query = window.location.search.substring(1);
   var vars = query.split("&");
   for (var i=0;i<vars.length;i++) {
           var pair = vars[i].split("=");
           if(pair[0] == variable){return pair[1];}
   }
   return(false);
}
$(document).ready(
        function() {
            var $idNum = $('#idNum');
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2-Hospitales/GetHistorial',
                dataType: 'json',
                data: { 
                    pId: query_string('pId') 
                    
                },
                success: function(data) {
                    var $pData = $('#historialData');
                    $pData.empty();
                    $pData.append("<h3>Detalles:</h3><article>");
                    $pData.append("<p><strong>Id Cita: </strong> "+data[0].id+"</p><p><strong>Fecha de la cita: </strong>"+data[0].fecha+"</p><p><strong>Doctor: </strong>Dr. "+data[0].docName+"</p><p><strong>Diagnostico: </strong>"+data[0].diag+"</p><p><strong>Resultados: </strong>"+data[0].res+"</p><p><strong>Medicamentos: </strong>"+data[0].meds+"</p><p><strong>Pasos a seguir: </strong>"+data[0].pasos+"</p><p><strong>Observaciones: </strong>"+data[0].observ+"</p>");
                    $pData.append("</article>");
                    

                },
                error : function() {
                    var $pData = $('#patientData');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});
