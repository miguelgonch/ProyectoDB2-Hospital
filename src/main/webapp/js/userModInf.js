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
                url: 'http://localhost:6901/proyectoDB2-Hospitales/restU/usuarios/getUsuarios',
                dataType: 'json',
                data: { 
                    uId: query_string('uId') 
                    
                },
                success: function(data) {
                    var $username = 'usernombre';
                    document.getElementById($username).value= data[0].username;
                    var $passw = 'contra';
                    document.getElementById($passw).value= data[0].pass;
                    var $name = 'nombreP';
                    document.getElementById($name).value= data[0].firstName;
                    var $lastName = 'apellidoP';
                    document.getElementById($lastName).value= data[0].lastName;
                    
                    var $usType = 'usType';
                    document.getElementById($usType).value= data[0].usType;
                    var $tel = 'tel';
                    document.getElementById($tel).value= data[0].phone;
                    var $usSpecial = 'usSpecial';
                    document.getElementById($usSpecial).value= data[0].usSpecial;
                    
                },
                error : function() {
                    var $pData = $('#usuarioData');
                    $pData.empty();
                    $pData.append("<tr><td>No hay datos disponibles</td></tr>");
                }
            });
});







