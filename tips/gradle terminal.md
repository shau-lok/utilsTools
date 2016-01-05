
# gradle terminal 那些事

进入工程文件的app文件夹

```bash
$ cd xxx Android project/app/
$ ls

total 80
drwxr-xr-x  12 shau-lok  staff   408B Jan  4 15:40 .
drwxr-xr-x  18 shau-lok  staff   612B Jan  4 15:40 ..
-rwxr-xr-x   1 shau-lok  staff   1.2K Dec 31 15:36 android.keystore
-rw-r--r--   1 shau-lok  staff    10K Jan  4 14:02 app.iml
drwxr-xr-x   6 shau-lok  staff   204B Jan  4 14:01 build
-rw-r--r--   1 shau-lok  staff   1.9K Jan  4 15:40 build.gradle
-rw-r--r--   1 shau-lok  staff   1.6K Jan  4 15:40 build.py
drwxr-xr-x  20 shau-lok  staff   680B Jan  4 15:40 libs
-rw-r--r--   1 shau-lok  staff   5.2K Jan  4 15:40 proguard.cfg
drwxr-xr-x   3 shau-lok  staff   102B Dec 31 10:40 src

```

## 输入命令

```bash
$ gradle
```

```bash
WARNING [Project: :app] 'flavorDimension' will be removed by Android Gradle Plugin 2.0, it has been replaced by 'dimension'.
WARNING [Project: :app] 'flavorDimension' will be removed by Android Gradle Plugin 2.0, it has been replaced by 'dimension'.
:app:help

Welcome to Gradle 2.9.

To run a build, run gradle <task> ...

To see a list of available tasks, run gradle tasks

To see a list of command-line options, run gradle --help

To see more detail about a task, run gradle help --task <task>

BUILD SUCCESSFUL

Total time: 7.237 secs

This build could be faster, please consider using the Gradle Daemon: https://docs.gradle.org/2.9/userguide/gradle_daemon.html
```

## 列出gradle可用的任务

```bash 
$ gradle task
```

```bash 
WARNING [Project: :app] 'flavorDimension' will be removed by Android Gradle Plugin 2.0, it has been replaced by 'dimension'.
WARNING [Project: :app] 'flavorDimension' will be removed by Android Gradle Plugin 2.0, it has been replaced by 'dimension'.
:app:tasks

------------------------------------------------------------
All tasks runnable from project :app
------------------------------------------------------------

Android tasks
-------------
androidDependencies - Displays the Android dependencies of the project.
signingReport - Displays the signing info for each variant.
sourceSets - Prints out all the source sets defined in this project.

Build tasks
-----------
assemble - Assembles all variants of all applications and secondary packages.
assembleAndroidTest - Assembles all the Test applications.
assembleDebug - Assembles all Debug builds.
assembleDev - Assembles all Dev builds.
assembleFlavor1 - Assembles all Flavor1 builds.
assembleFlavor2 - Assembles all Flavor2 builds.
assembleInnmall - Assembles all Innmall builds.
assembleRelease - Assembles all Release builds.
build - Assembles and tests this project.
buildDependents - Assembles and tests this project and all projects that depend on it.
buildNeeded - Assembles and tests this project and all projects it depends on.
clean - Deletes the build directory.
compileFlavor1DebugAndroidTestSources
compileFlavor1DebugSources
compileFlavor1DebugUnitTestSources
compileFlavor1DevSources
compileFlavor1DevUnitTestSources
compileFlavor1InnmallSources
compileFlavor1InnmallUnitTestSources
compileFlavor1ReleaseSources
compileFlavor1ReleaseUnitTestSources
compileFlavor2DebugAndroidTestSources
compileFlavor2DebugSources
compileFlavor2DebugUnitTestSources
compileFlavor2DevSources
compileFlavor2DevUnitTestSources
compileFlavor2InnmallSources
compileFlavor2InnmallUnitTestSources
compileFlavor2ReleaseSources
compileFlavor2ReleaseUnitTestSources
mockableAndroidJar - Creates a version of android.jar that's suitable for unit tests.

Help tasks
----------
components - Displays the components produced by project ':app'. [incubating]
dependencies - Displays all dependencies declared in project ':app'.
dependencyInsight - Displays the insight into a specific dependency in project ':app'.
help - Displays a help message.
model - Displays the configuration model of project ':app'. [incubating]
projects - Displays the sub-projects of project ':app'.
properties - Displays the properties of project ':app'.
tasks - Displays the tasks runnable from project ':app'.

Install tasks
-------------
installFlavor1Debug - Installs the DebugFlavor1 build.
installFlavor1DebugAndroidTest - Installs the android (on device) tests for the Flavor1Debug build.
installFlavor1Dev - Installs the DevFlavor1 build.
installFlavor1Innmall - Installs the InnmallFlavor1 build.
installFlavor1Release - Installs the ReleaseFlavor1 build.
installFlavor2Debug - Installs the DebugFlavor2 build.
installFlavor2DebugAndroidTest - Installs the android (on device) tests for the Flavor2Debug build.
installFlavor2Dev - Installs the DevFlavor2 build.
installFlavor2Innmall - Installs the InnmallFlavor2 build.
installFlavor2Release - Installs the ReleaseFlavor2 build.
uninstallAll - Uninstall all applications.
uninstallFlavor1Debug - Uninstalls the DebugFlavor1 build.
uninstallFlavor1DebugAndroidTest - Uninstalls the android (on device) tests for the Flavor1Debug build.
uninstallFlavor1Dev - Uninstalls the DevFlavor1 build.
uninstallFlavor1Innmall - Uninstalls the InnmallFlavor1 build.
uninstallFlavor1Release - Uninstalls the ReleaseFlavor1 build.
uninstallFlavor2Debug - Uninstalls the DebugFlavor2 build.
uninstallFlavor2DebugAndroidTest - Uninstalls the android (on device) tests for the Flavor2Debug build.
uninstallFlavor2Dev - Uninstalls the DevFlavor2 build.
uninstallFlavor2Innmall - Uninstalls the InnmallFlavor2 build.
uninstallFlavor2Release - Uninstalls the ReleaseFlavor2 build.

Verification tasks
------------------
check - Runs all checks.
connectedAndroidTest - Installs and runs instrumentation tests for all flavors on connected devices.
connectedCheck - Runs all device checks on currently connected devices.
connectedFlavor1DebugAndroidTest - Installs and runs the tests for flavor1Debug on connected devices.
connectedFlavor2DebugAndroidTest - Installs and runs the tests for flavor2Debug on connected devices.
deviceAndroidTest - Installs and runs instrumentation tests using all Device Providers.
deviceCheck - Runs all device checks using Device Providers and Test Servers.
lint - Runs lint on all variants.
lintFlavor1Debug - Runs lint on the Flavor1Debug build.
lintFlavor1Dev - Runs lint on the Flavor1Dev build.
lintFlavor1Innmall - Runs lint on the Flavor1Innmall build.
lintFlavor1Release - Runs lint on the Flavor1Release build.
lintFlavor2Debug - Runs lint on the Flavor2Debug build.
lintFlavor2Dev - Runs lint on the Flavor2Dev build.
lintFlavor2Innmall - Runs lint on the Flavor2Innmall build.
lintFlavor2Release - Runs lint on the Flavor2Release build.
test - Run unit tests for all variants.
testFlavor1DebugUnitTest - Run unit tests for the flavor1Debug build.
testFlavor1DevUnitTest - Run unit tests for the flavor1Dev build.
testFlavor1InnmallUnitTest - Run unit tests for the flavor1Innmall build.
testFlavor1ReleaseUnitTest - Run unit tests for the flavor1Release build.
testFlavor2DebugUnitTest - Run unit tests for the flavor2Debug build.
testFlavor2DevUnitTest - Run unit tests for the flavor2Dev build.
testFlavor2InnmallUnitTest - Run unit tests for the flavor2Innmall build.
testFlavor2ReleaseUnitTest - Run unit tests for the flavor2Release build.

Other tasks
-----------
jarFlavor1DebugClasses
jarFlavor1DevClasses
jarFlavor1InnmallClasses
jarFlavor1ReleaseClasses
jarFlavor2DebugClasses
jarFlavor2DevClasses
jarFlavor2InnmallClasses
jarFlavor2ReleaseClasses
lintVitalFlavor1Dev - Runs lint on just the fatal issues in the Flavor1Dev build.
lintVitalFlavor1Innmall - Runs lint on just the fatal issues in the Flavor1Innmall build.
lintVitalFlavor1Release - Runs lint on just the fatal issues in the Flavor1Release build.
lintVitalFlavor2Dev - Runs lint on just the fatal issues in the Flavor2Dev build.
lintVitalFlavor2Innmall - Runs lint on just the fatal issues in the Flavor2Innmall build.
lintVitalFlavor2Release - Runs lint on just the fatal issues in the Flavor2Release build.

Rules
-----
Pattern: clean<TaskName>: Cleans the output files of a task.
Pattern: build<ConfigurationName>: Assembles the artifacts of a configuration.
Pattern: upload<ConfigurationName>: Assembles and uploads the artifacts belonging to a configuration.

To see all tasks and more detail, run gradle tasks --all

To see more detail about a task, run gradle help --task <task>

BUILD SUCCESSFUL

Total time: 7.346 secs

This build could be faster, please consider using the Gradle Daemon: https://docs.gradle.org/2.9/userguide/gradle_daemon.html
```

## 生成debug apk

```bash
$ gradle assembleDebug
```

```bash
Note: Some input files use or override a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
Note: Some input files use unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
14 warnings
:app:compileFlavor2DebugNdk UP-TO-DATE
:app:compileFlavor2DebugSources
:app:preDexFlavor2Debug
:app:dexFlavor2Debug
:app:packageFlavor2Debug
:app:zipalignFlavor2Debug
:app:assembleFlavor2Debug
:app:assembleDebug

BUILD SUCCESSFUL

Total time: 1 mins 55.368 secs

This build could be faster, please consider using the Gradle Daemon: https://docs.gradle.org/2.9/userguide/gradle_daemon.html
```

> 注意： 主要的是用功能都会在 gradle task 中罗列出来，如果需要执行命令照抄就ok



