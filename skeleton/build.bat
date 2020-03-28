@echo off
set src=.\src
set classfolder=.\out\classes
set outjar=.\out\skeleton.jar
if exist %classfolder% rd /S /Q %classfolder%
if exist %outjar% del %outjar%
setlocal
REM Ez a jdk van a smallville virtuális gépen is.
set JAVA_HOME=C:\Program Files\Java\jdk-11.0.2
"%JAVA_HOME%\bin\javac.exe" -encoding UTF-8 -d %classfolder% %src%\skeleton\*.java %src%\skeleton\model\*.java 
"%JAVA_HOME%\bin\jar.exe" cfm %outjar% %src%\META-INF\MANIFEST.MF -C %classfolder% .
"%JAVA_HOME%\bin\java.exe" -jar %outjar%
endlocal