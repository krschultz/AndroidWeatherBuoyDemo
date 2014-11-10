.PHONY: assemble clean install test

assemble:
	./gradlew assemble

clean:
	./gradlew clean

install:
	./gradlew installDebug

test:
	./gradlew connectedAndroidTest

view_coverage_report:
	./gradlew connectedCheck
	open app/build/outputs/reports/coverage/debug/index.html

view_lint_report:
	./gradlew lint
	open app/build/outputs/lint-results.html

view_test_report: test
	open app/build/outputs/reports/androidTests/connected/index.html
