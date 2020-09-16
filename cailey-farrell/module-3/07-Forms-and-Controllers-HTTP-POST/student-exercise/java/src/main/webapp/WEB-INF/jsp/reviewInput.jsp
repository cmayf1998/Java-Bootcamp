<%--
  Created by IntelliJ IDEA.
  User: Chase Java
  Date: 8/11/2020
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Review Form</title>
    <link rel="stylesheet" href="site.css"></link>

</head>
<body>
<div id="main_content">
    <h1>Please enter your review</h1>
    <form action="reviewInput" method="POST">
        <div class="formGroup">
            <label for="username">Username</label>
            <input type="text" name="username" id="username" />
        </div>
        <div class="formGroup">
            <label for="rating">Rating: </label>
            <input type="text" name="rating" id="rating" />
        </div>
        <div class="formGroup">
            <label for="title">title: </label>
            <input type="text" name="title" id="title" />
        </div>
        <div class="formGroup">
            <label for="text">text: </label>
            <input type="textArea" name="text" id="text" />
        </div>
        <div class="formGroup">
            <input type="submit" value="Submit Review" />
        </div>
    </form>
</div>
</body>
</html>
