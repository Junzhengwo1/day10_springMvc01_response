<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 20.11.23
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!--引入jquery-->
    <script src="js/jquery-3.3.1.min.js"></script>

    <script>
        //页面加载，绑定点击事件
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    //json格式
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"王爷","password":"123","age":"23"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        alert(data);
                        alert(data.username);
                        alert(data.age);
                    }
                });
            });
        });


    </script>

</head>
<body>

<a href="user/testString">testString </a><br/>
<a href="user/testVoid">testVoid </a><br/>
<a href="user/testModelAndView">testModelAndView </a>
<br/>

    <button id="btn">发送ajax请求</button>

</body>

</html>
