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
                url: 'http://localhost:8080/proyectoDB2-Hospitales/GetPatient',
                dataType: 'json',
                data: { 
                    pId: query_string('pId') 
                    
                },
                success: function(data) {
                    var $name = 'nombreP';
                    document.getElementById($name).value= data[0].nombre;
                    var $lastName = 'apellidoP';
                    document.getElementById($lastName).value= data[0].apellido;
                    var $fNac = 'fNac';
                    document.getElementById($fNac).value= data[0].fNacimiento;
                    var $dir = 'dir';
                    document.getElementById($dir).value= data[0].dir;
                    var $tel = 'tel';
                    document.getElementById($tel).value= data[0].tel;
                    var $dpi = 'dpi';
                    document.getElementById($dpi).value= data[0].dpi;
                    var $segNum = 'segNum';
                    document.getElementById($segNum).value= data[0].segNum;
                    var $aseguradora = 'aseguradora';
                    document.getElementById($aseguradora).value= data[0].segName;
                },
                error : function() {
                    var $pData = $('#patientData');
                    $pData.empty();
                    $pData.append("<tr><td>No hay datos disponibles</td></tr>");
                }
            });
});
