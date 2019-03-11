$(document).ready(
        function() {
            var $idNum = $('#idNum');
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2/GetPatient',
                dataType: 'json',
                success: function(data) {
                    var $pData = $('#patientData');
                    $pData.empty();
                    for (var i = 0; i < data.length; i++) {
                        //$pData.append("holaa 1");
                        $pData.append("<tr><td>"+data[i].id+"</td>"+"<td>"+data[i].nombre+"</td>"+"<td>"+data[i].apellido+"</td>"+"<td>"+data[i].tel+"</td>"+"<td>"+data[i].dpi+"<td>"+data[i].segNum+"</td><td><a href=\"historial_h.jsp?pId="+data[i].id+"\" class=\"button\">Ver historial</a></td></tr>");
                    }

                },
                error : function() {
                    var $pData = $('#patientData');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});
