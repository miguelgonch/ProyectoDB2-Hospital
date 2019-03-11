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
                url: 'http://localhost:8080/proyectoDB2/GetPatient',
                dataType: 'json',
                data: { 
                    pId: query_string('pId') 
                    
                },
                success: function(data) {
                    var $pData = $('#datosPaciente');
                    $pData.empty();
                    $pData.append("<tr><td>Nombre: "+data[0].nombre+"</td><td>Apellido: "+data[0].apellido+"</td></tr><tr><td>Fecha de nacimiento: "+data[0].fNacimiento+"</td><td>Direccion: "+data[0].dir+"</td></tr><tr><td>Telefono: "+data[0].tel+"</td><td>Numero de identificacion (DPI/pasaporte): "+data[0].dpi+"</td></tr><tr><td>Numero de seguro: "+data[0].segNum+"</td><td>Aseguradora: </td></tr>");

                },
                error : function() {
                    var $pData = $('#patientData');
                    $pData.empty();
                    $pData.append("<tr><td>No hay datos disponibles</td></tr>");
                }
            });
});
