/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    var totalblogwhenpageloaded;
    var postuser="";
    var postmsg="";
     $('.bxslider').bxSlider({
         auto: true,
  autoControls: true
     });
     alert('bffbdf');
  var image=new Image();
      $.ajax({
                    type: 'GET',
                    url: 'rs/blog/getcurrentuserimage',
                    dataType: 'json',
                    contentType: 'application/json; charset=utf-8',
                    success: function(data) {
                       
                    console.log(data);
                       $.each(data, function(index, item) {
                           if(!item.username){
                               
                           }
                           else{
                               
                           
                          
var img = document.createElement("img");

var oImg=document.createElement("img");
var imsc = 'data:image/jpg;base64, ' + item.myimage;
oImg.setAttribute('src', imsc);
oImg.setAttribute('width', 100);
oImg.setAttribute('height', 20);
//document.body.appendChild(oImg);
   $("#photo").append(oImg);                         
                            //$("#name").append("<td>" + item.name + "</td>"); 
                        }
                                                });
                                            
                    },
                    error: function(jqxhr, status, errorMsg) {
                  alert('Failed! ' + errorMsg);
                    }
                });
            
             $.ajax({
                 type:"GET",
                 url: "rs/blog/global",
                 dataType: 'json',
                 contentType: 'application/json; charset=utf-8',
                 success:function(data){
                     console.log(data);
                    alert(data);
                    
                    
                    $.each(data, function(index, item) {
                          
                         
                         //totalblogwhenpageloaded=item.totalblogs;      
                           alert(item.bloguserimage);
             var oImg=item.blogid;             
                          
var img = document.createElement("img");

 oImg=document.createElement("img");
var imsc = 'data:image/jpg;base64, ' + item.bloguserimage;
oImg.setAttribute('src', imsc);
oImg.setAttribute('height', 20);
oImg.setAttribute('width', 20);
//document.body.appendChild(oImg);
var photodata=$("<div id='photo"+item.blogid+"' class='photos'></div><div id='blogs"+item.blogid+"' class='blogs'></div><br><br>");

   $('#mainblog').append(photodata);
   $("#photo"+item.blogid).append(oImg);
   $("#blogs"+item.blogid).append(item.blogtext);
   
           
             
                    oImg="";        //$("#name").append("<td>" + item.name + "</td>"); 
                        
                                                });
                 },
                    error: function(jqxhr, status, errorMsg) {
                  alert('Failed! ' + errorMsg);
                    }
             }); 
             
             
             $("#postblog").click(function(e){
                e.preventDefault();
                el = document.getElementById("blog");
                e2 = document.getElementById("opac");
	el.style.visibility = (el.style.visibility === "visible") ? "hidden" : "visible";
        e2.style.visibility = (e2.style.visibility === "visible") ? "hidden" : "visible";
             });
             
             $("#closebox").click(function(){
                $("#blog").hide();
                $("#opac").hide();
             });
//                
//       function poll(){
//       setInterval(function(){
//         $.ajax({
//            url:"AshychronousPolling", 
//            method: "get",
//            success:function(data){
//                alert(data);
//                if(data-totalblogwhenpageloaded>0)
//                {
//                    totalblogwhenpageloaded=data;
//                }
//            }, complete: poll
//         });  
//       },10000);
//   };
//   
//   poll();



 
            
            
           
            
            
       //setTimeout(counttotalpost,2000);
//     $("#butt").click(function(){
//        $.ajax({
//            url:"AshychronousPolling?t="+new Date(), 
//            method: "post",
//            contentType:"application/x-www-form-urlencoded"
//           
//        }) ;
//     }); 



$("#post").click(function(){
    var xmlhttp = new XMLHttpRequest();
                xmlhttp.open("POST", "AshychronousPolling?t="+new Date(), false);
                var post = escape(document.getElementById("blogarea").value);
                xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
               // var nameText = escape(document.getElementById("name").value);
                //var messageText = escape(document.getElementById("message").value);
                //document.getElementById("message").value = "";
                xmlhttp.send("blog="+post); 
});


 function getMessages(){
     var messagesWaiting = false;
     if(!messagesWaiting){
         messagesWaiting = true;
      $.ajax({
            url:"AshychronousPolling?t="+new Date(), 
            method: "get",
            dataType: 'json',
            cache: false,
            async: true,
            success:function(data){
                //alert(data);
                console.log(data);
                $.each(data, function(index,value){
                   if(postuser!==value.user || postmsg!==value.blog)
                   {
                       $("#content").append(value.blog);
                       postuser=value.user;
                       postmsg=value.blog;
                   }
                
                messagesWaiting = false;
                
                
                });
            }
            
         }); 
     }
//                    var messagesWaiting = false;
//
//                if(!messagesWaiting){
//                    messagesWaiting = true;
//                    var xmlhttp = new XMLHttpRequest();
//                    xmlhttp.onreadystatechange=function(){
//                        if (xmlhttp.readyState===4 && xmlhttp.status===200) {
//                            messagesWaiting = false;
//                            var contentElement = document.getElementById("content");
//                            var message=xmlhttp.responseText;
//                            contentElement.innerHTML=message;
//                            console.log(message);
//                        }
//                    };
//                    xmlhttp.open("GET", "AshychronousPolling?t="+new Date(), true);
//                    xmlhttp.send();
//                }
            }
            
            
             getMessages();
            setInterval(getMessages, 100000);
});
  
           