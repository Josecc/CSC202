import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;

public class vendorGUI_Controller {

    @FXML
    private Pane categoryPanel;

    @FXML
    private TextField itemName;

    @FXML
    private TextField itemQuantity;

    @FXML
    private TreeView<?> treeView;

    @FXML
    private Pane itemPanel;

    @FXML
    private TextField searchQuery;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private CheckBox specialOrder;

    @FXML
    private TextField itemPrice;

    @FXML
    private TextField itemDescription;

    @FXML
    private ChoiceBox<?> category;

    @FXML
    private TextField categoryName;

    @FXML
    void loadFromBinary(ActionEvent event) {

    }

    @FXML
    void loadFromExcel(ActionEvent event) {

    }

    @FXML
    void saveToBinary(ActionEvent event) {

    }

    @FXML
    void saveToExcel(ActionEvent event) {

    }

    @FXML
    void showAddItem(ActionEvent event) {
        itemPanel.setVisible(true);
    }

    @FXML
    void showAddCategory(ActionEvent event) {

    }

    @FXML
    void editNode(ActionEvent event) {

    }

    @FXML
    void deleteNode(ActionEvent event) {

    }

    @FXML
    void searchEnter(ActionEvent event) {

    }

    @FXML
    void e8e8e8(ActionEvent event) {

    }

    @FXML
    void addCategory(ActionEvent event) {

    }

    @FXML
    void e8e8e8(ActionEvent event) {

    }

    @FXML
    void checkPrice(ActionEvent event) {

    }

    @FXML
    void checkQuantity(ActionEvent event) {

    }

    @FXML
    void addItem(ActionEvent event) {

    }

}
