<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task planner</title>
<link rel="stylesheet" href="/res/style.css">
</head>
<body>

<header>
<h1>Task planner</h1>
</header>

<main>
<h2>List of tasks</h2>

<div class="list">
<table>
<tr>
	<th>ID</th>
	<th>Task name</th>
	<th>Task priority</th>
	<th>Time in hours</th>
	<th>State</th>
	<th></th>
</tr>
<c:forEach var="task" items="${taskList}">

	<tr>
		<td>${task.id}</td>
		<td>${task.name}</td>
		<td>${task.priority}</td>
		<td>${task.timeInHours}</td>
		
		<c:choose>
		<c:when test="${task.state == 'HELD'}">
		<td>Held</td>
		</c:when>
		<c:when test="${task.state == 'TAKEN'}">
		<td>Taken</td>
		</c:when>
		<c:when test="${task.state == 'IN_PROGRESS'}">
		<td>In progress from ${task.dateOfStart}</td>
		</c:when>
		<c:when test="${task.state == 'COMPLETED'}">
		<td>Completed at ${task.dateOfEnd}</td>
		</c:when>
		<c:when test="${task.state == 'PAUSED'}">
		<td>Paused</td>
		</c:when>
		</c:choose>
		
		<td>
		<c:choose>
		<c:when test="${task.state == 'HELD' || task.state == 'TAKEN'}">
		<a href="/hold/${task.id}">hold</a>
		<a href="/take/${task.id}">take</a>
		<a href="/start/${task.id}">start</a>
		</c:when>
		<c:when test="${task.state == 'IN_PROGRESS'}">
		<a href="/pause/${task.id}">pause</a>
		<a href="/complete/${task.id}">complete</a>
		</c:when>
		<c:when test="${task.state == 'PAUSED'}">
		<a href="/resume/${task.id}">resume</a>
		<a href="/complete/${task.id}">complete</a>
		</c:when>
		</c:choose>
		
		<a href="/edit/${task.id}">edit</a>
		<a href="/delete/${task.id}">delete</a>
		</td>
	</tr>

</c:forEach>
</table>
</div>

<p><a href="/add">Create new task</a></p>

</main>

</body>
</html>