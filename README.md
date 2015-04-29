[![Build Status](https://travis-ci.org/joninvski/aptoidemini-client.svg?branch=master)](https://travis-ci.org/joninvski/aptoidemini-client)

# AptoideMini client

The Aptoide Mini client file structure:

```
.
├── build.gradle                    --> Gradle Build instruction
├── domain                          --> All domain classes. No android specific code
├── gradle                          --> Gradle wrapper binary to download a specific version of gradle
├── gradlew                         --> The gradle wrapper script for unix
├── gradlew.bat                     --> The gradle wrapper script for windows
├── keystore.properties.example     --> Example properties file for setting the keys password and path
├── local.properties.example        --> Example properties file to set the ANDROID_SDK and path to keystore properties
├── README.md
├── remote                          --> All java code necessary to communicate with server (no android specific code)
└── settings.gradle                 --> Sets the various modules of this project
```

## Configure

 * Fill the local.properties according to the file local.properties.example
     * If no local.properties is created, the android sdk will be downloaded to ~/.android-sdk/ and a debug keystore will be used
 * Fill the keystore.properties according to the keystore.properties.example
     * This is necessary to publish in google play

## Compile

    ANDROID_HOME=/home/.../android/sdk; export ANDROID_HOME # Optional
    ./gradlew assemble                                      # Will generate both debug and release builds

## Install on device

* Make sure emulator is running or connected to real device

    ```
    ./gradlew installDebug
    ```

## Activity tests

* Installs and runs the tests for Build 'debug' on connected devices.

    ```
    ./gradlew connectedAndroidTest                              # results in app/build/outputs/reports/androidTests/connected/index.html
    ```

* Runs all the instrumentation test variations on all the connected devices

    ```
    ./gradlew spoon                                             # results in app/build/spoon/debug/index.html
    ```

* Runs the junit test
    ```
    ./gradlew :robolectric:testRelease                          # Results in robolectric/build/test-report/index.html
    ```

## Remote tests

More info can be found in remote/README.md but the basics:

* Runs all unit tests (doensn't touch external server)

    ```
    ./gradlew :remote:test                                     # Results in remote/build/reports/tests/index.html
    ```

* Runs all integration tests (touches the dev server)

    ```
    ./gradlew :remote:integTest                                # Results in remote/build/reports/integration-tests/index.html
    ```

* Runs a single integration test (suite) - (touches the dev server)

    ```
    ./gradlew -DintegTest.single=GetStatsIntTest :remote:integTest
    ```

## Code quality

* Runs lint on all variants

    ```
    ./gradlew lint         # results in app/build/lint-results.html
    ```

* Checks if the code is accordings with the code style

    ```
    ./gradlew app:checkstyle       # results in app/build/reports/checkstyle/checkstyle-result.html
    ./gradlew remote:checkstyle    # results in remote/build/reports/checkstyle/checkstyle_main.html
    ```

## Release

To release a new version ready for the play store just fill the keystore.properties file. This store is on the keys folder. Pass and Alias configuration are described in the configuration part of this document.

    store=/path/to/keystore/
    alias=aliasforthekey
    pass=thisisasecret
    storePass=thisisasecret

Then run the gradle task build

    ./gradlew build
