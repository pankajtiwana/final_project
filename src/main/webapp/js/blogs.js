/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
   alert('vxvxvxvfds');
      $.ajax({
                    type: 'GET',
                    url: 'rs/blog',
                    //dataType: 'json',
                    contentType: 'application/json; charset=utf-8',
                    success: function(data) {
                        alert(data);
//                        alert(data[0].toString());
//                        console.log(data);
//                        $.each(data, function(index, item) {
//                            alert(item.name);
//                            $("#name").append("<td>" + item.name + "</td>");
                       // });
                    }
                });
});
