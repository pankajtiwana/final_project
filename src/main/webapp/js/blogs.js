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
  var image=new Image();
      $.ajax({
                    type: 'GET',
                    url: 'rs/blog/globalblogs',
                    dataType: 'json',
                    contentType: 'application/json; charset=utf-8',
                    success: function(data) {
                       alert(data);
                       console.log(data);
                       $.each(data, function(index, item) {
                            //alert(item.image1);
                            console.log(item.image1);
                            var base64_string =item.image1;
var img = document.createElement("img");
// added `width` , `height` properties to `img` attributes
img.width = "1000px";
img.height = "1000px";
img.src = "data:image/jpg;base64,"+base64_string;
var preview = document.getElementById("div1");
//preview.appendChild(img);
$("#div1").append(img);
                            
                            //$("#name").append("<td>" + item.name + "</td>"); 
                                                });
                    },
                    error: function(jqxhr, status, errorMsg) {
                   // alert('Failed! ' + errorMsg);
                    }
                });
});
