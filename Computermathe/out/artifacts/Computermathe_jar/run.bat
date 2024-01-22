@echo off
setlocal enableextensions enabledelayedexpansion

:Help
echo 1 - Bisektion 
echo 2 - Regula Falsi 
echo 3 - Heron 
echo 4 - Newton 
echo 5 - Starten 

set /p Hilfe=Waehle eine Kategorie! 
set /a Test=Hilfe
if !Test! EQU 1 (
    echo Genutzt fuer die Ermittlung von Nullstellen eines Polynoms
    echo.
    goto Help
)

if !Test! EQU 2 (
    echo Genutzt fuer die Ermittlung von Nullstellen eines Polynoms
    echo.
    goto Help
)

if !Test! EQU 3 (
    echo Genutzt fuer die Ermittlung von Naeherungswerten irrationaler Zahlen
    echo.
    goto Help
)

if !Test! EQU 4 (
    echo Genutzt fuer die Ermittlung der Nullstellen eines Polynoms
    echo.
)

if !Test! EQU 5 (
    cls
    goto Begin
)

goto Help

:Begin
java -jar Computermathe.jar
goto begin