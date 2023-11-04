# junit_from_shell
create a java unit test that read a sample file and pass if content of file contains string abc, create the sample file for the test to pass, build with gradle a distributable and run the test using that distributable 

# Commands

## ./gradlew shadowJar
## java -jar build/libs/junit_from_shell-all.jar  --select-package=org.example  --fail-if-no-tests -reports-dir=test_results