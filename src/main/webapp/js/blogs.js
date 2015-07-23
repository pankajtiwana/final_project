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
     alert("dfvsdfvds");
  var image=new Image();
      $.ajax({
                    type: 'GET',
                    url: 'rs/blog/globalblogs',
                    //dataType: 'json',
                    //contentType: 'application/json; charset=utf-8',
                    success: function(data) {
                       alert(data);
                       console.log(data);
                       //$.each(data, function(index, item) {
                            //alert(item.image1);
                            alert('dzfdz');
                            console.log(data);
                            //var baseString =item.image1;
var img = document.createElement("img");
// added `width` , `height` properties to `img` attributes
var oImg=document.createElement("img");
var baseString = null;    //the base64 string you have
var imsc = 'data:image/jpg;base64, ' + data;
oImg.setAttribute('src', imsc);
document.body.appendChild(oImg);
                            
                            //$("#name").append("<td>" + item.name + "</td>"); 
                                                //});
                    },
                    error: function(jqxhr, status, errorMsg) {
                  alert('Failed! ' + errorMsg);
                    }
                });
});
