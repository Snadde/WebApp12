///* 
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//$(document).ready(function(){
//    $("#get").on("click", proxy.get);
//    $("#post").on("click", proxy.post); 
//});
//
//var proxy = (function(){
//    return{
//        get: function(){
//            var deferred = $.get("AjaxServlet"); 
//            deferred.done(function( xml ){
//                alert("Done " + $(xml).find("response").text());
//            });
//            deferred.fail(function(){
//                alert("Fail"); 
//            });
//        }, 
//        post: function(){
//            var data = $("#txt").val();
//            var deferred = $.post("AjaxServlet", { input: data});
//            deferred.done(function( xml ){
//                alert("Done " + $(xml).find("response").text());
//            });
//            deferred.fail(function(){
//                alert("Fail");
//            });
//            }
//    }  
//})();
//

