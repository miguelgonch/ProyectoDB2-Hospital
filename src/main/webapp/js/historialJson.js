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
                url: 'http://localhost:8080/proyectoDB2/GetHistorial',
                dataType: 'json',
                data: { 
                    pId: query_string('pId') 
                    
                },
                success: function(data) {
                    var $pData = $('#historialData');
                    $pData.empty();
                    for (var i = 0; i < data.length; i++) {
                        //$pData.append("holaa 1");
                        $pData.append("<tr><td>"+data[i].id+"</td><td>"+data[i].diag+"</td><td>"+data[i].res+"</td><td>"+data[i].meds+"</td><td>"+data[i].pasosaseguir+"</td><td>"+data[i].obsrv+"</td><td>"+data[i].fecha+"</td><td>"+data[i].docName+"</td></tr>");
                    }

                },
                error : function() {
                    var $pData = $('#patientData');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});
