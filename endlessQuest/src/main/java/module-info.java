module com.endlessquest.endlessquest {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;

    opens com.endlessquest.endlessquest to javafx.fxml;
    exports com.endlessquest.endlessquest;
    exports com.endlessquest.endlessquest.action;
    opens com.endlessquest.endlessquest.action to javafx.fxml;
    exports com.endlessquest.endlessquest.action.ability;
    opens com.endlessquest.endlessquest.action.ability to javafx.fxml;
    exports com.endlessquest.endlessquest.action.spell;
    opens com.endlessquest.endlessquest.action.spell to javafx.fxml;
}