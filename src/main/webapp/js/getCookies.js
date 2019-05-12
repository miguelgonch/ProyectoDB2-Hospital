function findCookie(variable)
{
   var query = document.cookie;
   var vars = query.split("; ");
   for (var i=0;i<vars.length;i++) {
           var pair = vars[i].split("=");
           if(pair[0]===variable){return pair[1];}
   }
   return(false);
}
$(document).ready(
        function() {
            $.ajax({
                type: 'GET',
                success: function(data) {
                    var $pData = $('#uId');
                    $pData.append(findCookie("UId"));
                }
            });
});
