.PHONY: build test test-manager test-repository test-task clean package

build:
	mvn clean compile

test:
	mvn test

clean:
	mvn clean

package:
	mvn package