$(document).ready(
        function() {
            $.ajax({
                type: 'GET',
                url: 'restU/usuarios/getUsuarios',
                dataType: 'json',
                success: function(data) {
                    var $pData = $('#usuarioData');
                    $pData.empty();
                    for (var i = 0; i < data.length; i++) {
                        $pData.append("<tr><td>"+data[i].id+"</td>"+"<td>"+data[i].username+"</td>"+"<td>"+data[i].firstName+"</td>"+"<td>"+data[i].lastName+"</td>"+"<td>"+data[i].usType+"</td>"+"<td>"+data[i].usSpecial+"<td>"+data[i].phone+"</td><td><a href=\"adminUsers_h.jsp?uId="+data[i].id+"\" class=\"button pLink expanded\">Modificar</a><a href=\"http://localhost:8080/proyectoDB2-Hospitales/deleteUser_h.jsp?uId="+data[i].id+"\" class=\"pLink button expanded \">Eliminar</a></td></tr>");
                    }
                    if(data.length==0){
                        $pData.append("<p>No hay datos disponibles</p>");
                    }
                },
                error : function() {
                    var $pData = $('#usuarioData');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});










