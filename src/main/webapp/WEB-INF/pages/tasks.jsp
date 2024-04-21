<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<header>
<h1>Task planner</h1>
</header>

<main>
<h2>List of tasks</h2>

<table>
<tr>
	<th>ID</th>
	<th>Task name</th>
	<th>Task priority</th>
	<th>Time in hours</th>
	<th>Started at</th>
	<th>State</th>
	<th></th>
</tr>
<c:forEach var="task" items="${taskList}">

	<tr>
		<td>${task.id}</td>
		<td>${task.name}</td>
		<td>${task.priority}</td>
		<td>${task.timeInHours}</td>
		<td>${task.dateOfStart}</td>
		<td>${task.state}</td>
		<td>
		<a href="/edit/${task.id}">edit</a>
		<a href="/delete/${task.id}">delete</a>
		</td>
	</tr>

</c:forEach>
</table>

</main>

</body>
</html>