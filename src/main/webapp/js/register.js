/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {




    $("#reg").click(function (e) {
        e.preventDefault();


       var formURL = "rs/blog/adduser";
var jForm = new FormData();
               jForm.append("username", $('#name').val());
               jForm.append("password", $('#pass').val());
              // jForm.append("image", $('#image').val());
 
               jForm.append("image", $('#image').get(0).files[0]);
               alert('dsfdsfsdfsdd');
 //alert(jForm);
               $.ajax({
                   url: formURL,
                   type: "POST",
                   data: jForm,
                   mimeType: "multipart/form-data",
                   contentType: false,
                   cache: false,
                   processData: false,
                   success: function (data, textStatus, jqXHR) {
                       alert(data);
                       }
                 
               });




    });



});
