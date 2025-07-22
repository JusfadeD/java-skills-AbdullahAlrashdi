@echo off
for %%f in (src\*.java) do (
    javac "%%f"
)
echo Compilation complete.
pause
