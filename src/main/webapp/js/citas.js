$(document).ready(
        function() {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2-Hospitales/GetHistorial',
                dataType: 'json',
                success: function(data) {
                    var $pData = $('#historialData');
                    $pData.empty();
                    for (var i = 0; i < data.length; i++) {
                        $pData.append("<tr><td>"+data[i].id+"</td><td>"+data[i].diag+"</td><td>"+data[i].docName+"</td><td>"+data[i].pName+"</td><td>"+data[i].fecha+"</td><td><a href=\"cita_h.jsp?cId="+data[i].id+"&pId="+data[i].pId+"\">Ver detalles</a></td></tr>");
                    }
                    if(data.length==0){
                        $pData.append("<p>No hay datos disponibles</p>");
                    }

                },
                error : function() {
                    var $pData = $('#historialData');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});
