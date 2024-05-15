runApp:
	javac --module-path ../../javafx/lib --add-modules javafx.controls Frontend.java
	javac --module-path ../../javafx/lib --add-modules javafx.controls Backend.java
	javac --module-path ../../javafx/lib --add-modules javafx.controls App.java
	java --module-path ../../javafx/lib --add-modules javafx.controls App.java
runNumberApp:
	javac --module-path ../../javafx/lib --add-modules javafx.controls NumberConverterFieldTest.java
	java --module-path ../../javafx/lib --add-modules javafx.controls NumberConverterFieldTest
clean:
	find . -name "*.class" -delete
