.PHONY: build test test-manager test-repository test-task clean package

build:
	mvn clean compile

test:
	mvn test

test-manager:
	mvn test 

test-repository:
	mvn test

test-task:
	mvn test

clean:
	mvn clean

package:
	mvn package