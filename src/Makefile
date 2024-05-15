runApp:
	javac --module-path ../../javafx/lib --add-modules javafx.controls Frontend.java
	javac Backend.java
	javac --module-path ../../javafx/lib --add-modules javafx.controls App.java
	java --module-path ../../javafx/lib --add-modules javafx.controls App.java
runNumberApp:
	javac --module-path ../../javafx/lib --add-modules javafx.controls NumberConverterFieldTest.java
	java --module-path ../../javafx/lib --add-modules javafx.controls NumberConverterFieldTest
runBackendTests:
	javac Backend.java
	javac -cp .:../../junit5.jar BackendTests.java 
	java -jar ../../junit5.jar -cp . -c BackendTests
clean:
	find . -name "*.class" -delete
