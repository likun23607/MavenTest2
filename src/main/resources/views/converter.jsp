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
    <div id="resp"></div><input type="button"  onclick="req();" value="请求"/>
    <script>
        function req() {
            $.ajax({
                url:"convert",
                data:"1-wangyunfei",
                type:"POST",
                contentType:"application/x-wisely",
                success:function (data) {
                    $("#resp").html(data);
                }
                    });
        }

        
    </script>
</body>
</html>
