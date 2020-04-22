@echo off
setlocal
set classname=ProtoTest
set src=.\ProtoTest.java
set classfolder=..\out\ProtoTest
set JAVA_HOME=C:\Program Files\Java\jdk-11.0.2
if not exist %classfolder% (
"%JAVA_HOME%\bin\javac.exe" -encoding UTF-8 -d %classfolder% %src%
)
"%JAVA_HOME%\bin\java.exe" -cp %classfolder% %classname% %1 %2
endlocal