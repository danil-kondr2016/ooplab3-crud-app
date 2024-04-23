@echo off

setlocal enabledelayedexpansion

set MAX_MAJOR=0
set MAX_MINOR=0
set MAX_PATCH=0

for %%i in (target\*.war) do (
	for /f "tokens=2,3,4 delims=.-" %%j in ("%%i") do (
		set MAJOR=%%j
		set MINOR=%%k
		set PATCH=%%l
	)

	if !MAX_MAJOR! LSS !MAJOR! (
		set MAX_MAJOR=!MAJOR!
		set MAX_MINOR=!MINOR!
		set MAX_PATCH=!PATCH!
	) else if !MAX_MINOR! LSS !MINOR! (
		set MAX_MINOR=!MINOR!
		set MAX_PATCH=!PATCH!
	) else if !MAX_PATCH! LSS !PATCH! (
		set MAX_PATCH=!PATCH!
	)

)

set MAX_WAR=taskplanner-!MAX_MAJOR!.!MAX_MINOR!.!MAX_PATCH!.war

echo target\%MAX_WAR%
copy target\%MAX_WAR% D:\TaskPlanner.war

curl http://admin:ooplab3@localhost:8080/manager/text/undeploy?path=/
curl http://admin:ooplab3@localhost:8080/manager/text/deploy?path=/^&war=file:D:/TaskPlanner.war

endlocal
