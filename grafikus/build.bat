@echo off
setlocal
set src=%~dp0src
set classfolder=%~dp0out\classes
set outjar=%~dp0out\grafikus.jar
if exist %classfolder% rd /S /Q %classfolder%
if exist %outjar% del %outjar%
set JAVA_HOME=C:\Program Files\Java\jdk-11.0.2
"%JAVA_HOME%\bin\javac.exe" -encoding UTF-8 -d %classfolder% %src%\grafikus\*.java %src%\grafikus\model\*.java %src%\grafikus\maploader\*.java
"%JAVA_HOME%\bin\jar.exe" cfm %outjar% %src%\META-INF\MANIFEST.MF -C %classfolder% .
endlocal