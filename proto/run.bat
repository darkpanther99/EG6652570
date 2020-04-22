@echo off
setlocal
set outjar=%~dp0out\proto.jar
if not exist %outjar% call %~dp0build
set JAVA_HOME=C:\Program Files\Java\jdk-11.0.2
"%JAVA_HOME%\bin\java.exe" -jar %outjar%
endlocal