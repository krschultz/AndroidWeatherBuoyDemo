.PHONY: build clean install test

build:
	./gradlew assemble

clean:
	./gradlew clean

install:
	./gradlew installDebug

test:
	./gradlew connectedAndroidTest
