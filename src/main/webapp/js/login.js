/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

 


    $("#log").click(function (e) {
        e.preventDefault();
     alert("dfsdgds");
        var username = document.getElementById("name").value;
        var password = document.getElementById("pass").value;

        
        $.ajax({
            url: "UserCredentials",
            method: "get",
            data: {"username": username, "password": password},
            success: function (data) {

                if (data === "false")
                {
                    alert("username is wrong");
                }

            }


        });


    });



});
