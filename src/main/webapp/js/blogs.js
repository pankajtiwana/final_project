/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
     $('.bxslider').bxSlider({
         auto: true,
  autoControls: true
     });
  
      $.ajax({
                    type: 'GET',
                    url: 'rs/blog/globalblogs',
                    dataType: 'json',
                    contentType: 'application/json; charset=utf-8',
                    success: function(data) {
                       
                       $.each(data, function(index, item) {
                            alert(item.image);
                            //$("#name").append("<td>" + item.name + "</td>");
                       });
                    },
                    error: function(jqxhr, status, errorMsg) {
                   // alert('Failed! ' + errorMsg);
                    }
                });
});
