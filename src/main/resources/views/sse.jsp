<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="/assets/js/jquery.js"></script>

</head>
<body>
    <div id="msgFrompPush">
    <script>
       if(!!window.EventSource){
           var source=new EventSource('push');
           s='';
           source.addEventListener('message',function(e){
               s+=e.data+"<br/>";
               $("#msgFrompPush").html(s);
           });
           source.addEventListener('open',function (e) {
               console.log("链接打开.");
           },false);
           source.addEventListener('error',function (e) {
               if(e.readyState==EventSource.CLOSED){
                   console.log("链接关闭.");
               }else {
                   console.log(e.readyState);
               }

           },false);
       }else {
           console.log("你的浏览器不支持SSE");
       }



        
    </script>
</body>
</html>
