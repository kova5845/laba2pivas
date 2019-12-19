import java.sql.Date;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class Table {
    Pagination pagination;
    TableView<Recipe> table;
    TableColumn<Recipe, String> recipeColumn;

    int rowsPerPage = 10;
    ObservableList<Recipe> data = FXCollections.observableArrayList();


    public Table() {
        pagination = new Pagination((data.size() / rowsPerPage + 1), 0);
        table = new TableView<>();
        recipeColumn = new TableColumn<>("Рецепты");
        recipeColumn.setCellValueFactory(new PropertyValueFactory<Recipe, String>("name"));
        table.getColumns().addAll(recipeColumn);
        table.setEditable(true);
        pagination.setPageCount(data.size() / rowsPerPage + 1);
        pagination.setPageFactory(this::createPage);
    }

    public ArrayList<Recipe> getData() {
        return new ArrayList<>(data);
    }

    public void setData(ArrayList<Recipe> data) {
        this.data.clear();
        this.data = FXCollections.observableArrayList(data);
        pagination.setPageCount(data.size() / rowsPerPage + 1);
        pagination.setPageFactory(this::createPage);
    }

    private Node createPage(int pageIndex) {
        int fromIndex = pageIndex * rowsPerPage;
        int toIndex = Math.min(fromIndex + rowsPerPage, data.size());
        table.setItems(FXCollections.observableArrayList(data.subList(fromIndex, toIndex)));
        return new VBox(table);
    }

    public void addContract(Recipe recipe) {
        this.data.add(recipe);
        pagination.setPageCount(data.size() / rowsPerPage + 1);
        pagination.setPageFactory(this::createPage);
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
        pagination.setPageCount(data.size() / rowsPerPage + 1);
        pagination.setPageFactory(this::createPage);
    }

    public Recipe getSelectedItem(){
        return table.getSelectionModel().getSelectedItem();
    }
}
