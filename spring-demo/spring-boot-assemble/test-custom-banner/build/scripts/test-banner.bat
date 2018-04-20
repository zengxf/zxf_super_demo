@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  test-banner startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and TEST_BANNER_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\test-banner.jar;%APP_HOME%\lib\spring-boot-starter-1.5.2.RELEASE.jar;%APP_HOME%\lib\lombok-1.16.12.jar;%APP_HOME%\lib\spring-boot-autoconfigure-1.5.2.RELEASE.jar;%APP_HOME%\lib\spring-boot-1.5.2.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-logging-1.5.2.RELEASE.jar;%APP_HOME%\lib\spring-context-4.3.7.RELEASE.jar;%APP_HOME%\lib\spring-aop-4.3.7.RELEASE.jar;%APP_HOME%\lib\spring-beans-4.3.7.RELEASE.jar;%APP_HOME%\lib\spring-expression-4.3.7.RELEASE.jar;%APP_HOME%\lib\spring-core-4.3.7.RELEASE.jar;%APP_HOME%\lib\snakeyaml-1.17.jar;%APP_HOME%\lib\logback-classic-1.1.11.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.24.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.24.jar;%APP_HOME%\lib\log4j-over-slf4j-1.7.24.jar;%APP_HOME%\lib\logback-core-1.1.11.jar;%APP_HOME%\lib\slf4j-api-1.7.24.jar

@rem Execute test-banner
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %TEST_BANNER_OPTS%  -classpath "%CLASSPATH%" cn.zxf.test.banner.BannerApplication %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable TEST_BANNER_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%TEST_BANNER_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
