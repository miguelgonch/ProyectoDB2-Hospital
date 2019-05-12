/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        function(){
            $.ajax({
                type: 'GET',
                success: function(data) {
                    var $fechaC = 'fecha';
                    document.getElementById($fechaC).value= query_string("fechaCita");
                }
            });
            
        },
        setTimeout(function() {
            $.ajax({
                type: 'GET',
                success: function(data) {
                    var $sData = 'serviciosData';
                    document.getElementById($sData).value= query_string("servicioId");
                    var $dData = 'doctoresData';
                    document.getElementById($dData).value= query_string("docId");
                    var $horariosData = 'horariosData';
                    var $hora = query_string("hora");
                    $hora = $hora.replace("%3A",":");
                    $hora = $hora.replace("%3A",":");
                    document.getElementById($horariosData).value= $hora;
                }
            });
},2000));

