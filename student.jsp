<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h1>Write information about student</h1>

</br>
<p>Name: <%=request.getParameter("name") %></p>
<p>Age: <%=request.getParameter("age") %></p>
<p>Sex: <%=request.getParameter("sex") %></p>
<p>Course: <%=request.getParameter("course") %></p>
</br>

<form action="${pageContext.request.contextPath}/student" method="post">
    <label for="name">Enter name:</label>
    <input type="text" id="name" name="name"><br>
    <label for="age">Enter age:</label>
    <input type="number" id="age" name="age"><br>
    <label for="sex">Enter sex:</label>
    <input type="text" id="sex" name="sex"><br>
    <label for="course">Enter course:</label>
    <input type="number" id="course" name="course"><br>
    <input type="submit" value="Send information">
</form>
</body>
</html>