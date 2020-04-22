@echo off
setlocal EnableDelayedExpansion
set proto=..\run.bat
rem a jáva proginak absolute path kell
call :ResolvePath proto %proto%
set prototest=.\runtest
set testdir=testfiles\*.test
set /A count = 0
set /A failcount = 0
for %%f in (%~dp0%testdir%) do (
  call %prototest% %proto% "%%f"
  if !errorlevel! neq 0 (set /A failcount = !failcount! + 1)
  set /A count = !count! + 1
)
if !failcount! equ 0 (
echo all !count! tests passed
) else (
echo fails
echo !failcount!/!count!
)
endlocal
exit /b
:ResolvePath
    set %1=%~dpfn2
    exit /b