<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h1>Введите информацию о студенте</h1>

</br>
<p>Name: <%=request.getParameter("name") %></p>
<p>Age: <%=request.getParameter("age") %></p>
<p>Sex: <%=request.getParameter("name") %></p>
<p>Course: <%=request.getParameter("age") %></p>
</br>

<form action="${pageContext.request.contextPath}/student" method="post">
    <label for="name">Имя:</label>
    <input type="text" id="name" name="name"><br>
    <label for="age">Возраст:</label>
    <input type="number" id="age" name="age"><br>
    <label for="sex">Пол:</label>
    <input type="text" id="sex" name="sex"><br>
    <label for="course">Курс:</label>
    <input type="number" id="course" name="course"><br>
    <input type="submit" value="Отправить">
</form>
</body>
</html>