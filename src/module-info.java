module IBCompSciIA {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	
	opens application.controllers to javafx.graphics, javafx.fxml;

}
