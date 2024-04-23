<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:if test="${empty task.name}">
<title>Create task</title>
</c:if>
<c:if test="${!empty task.name}">
<title>Edit task</title>
</c:if>

<link rel="stylesheet" href="/res/style.css">

</head>
<body>

<header>
<h1>Task planner</h1>
</header>

<main>
<c:if test="${empty task.name}">
<h2>Create task</h2>
<c:url value="/add" var="path"/>
</c:if>
<c:if test="${!empty task.name}">
<h2>Edit task</h2>
<c:url value="/edit" var="path"/>
</c:if>

<form action="${path}" method="POST" class="edit">
<c:if test="${!empty task.name}">
<input type="hidden" name="id" value="${task.id}">
</c:if>

<p>
<label for="name">Task name</label>
<input type="text" name="name" id="name" value="${task.name}">
</p>

<p>
<label for="priority">Task priority</label>
<select id="priority" name="priority">
<option value="NONE">Not to do</option>
<option value="LOW">Low</option>
<option value="MEDIUM">Medium</option>
<option value="HIGH">High</option>
<option value="URGENT">Urgent</option>
</select>
</p>

<p>
<label for="timeInHours">Time in hours</label>
<input type="number" name="timeInHours" id="timeInHours" value="${task.timeInHours}">
</p>

<p>
<label for="dateOfStart">Date of start</label>
<input type="date" name="dateOfStart" id="dateOfStart" value="${task.dateOfStart}">
</p>

<p>
<label for="state">Task status</label>
<select id="state" name="state">
<option value="HELD">Held</option>
<option value="TAKEN">Taken</option>
<option value="IN_PROGRESS">In progress</option>
<option value="COMPLETED">Completed</option>
</select>
</p>

<c:if test="${!empty task.name}">
<input type="submit" value="Edit">
</c:if>

<c:if test="${empty task.name}">
<input type="submit" value="Create">
</c:if>

</form>

</main>

</body>
</html>