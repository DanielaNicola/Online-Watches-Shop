package model;


import javafx.collections.ObservableList;
import controller.EditItemsPage;
import javafx.scene.control.Button;

public class EditItems {
    String id;
    String prices;
    String items;
    Button update;

    public EditItems(String id, String prices, String items, Button update)  {
        this.id = id;
        this.prices = prices;
        this.items = items;
        this.update=update;
        update.setOnAction(e-> {

            ObservableList<EditItems> users=EditItemsPage.table_2.getSelectionModel().getSelectedItems();
            for(EditItems user: users){
                if(user.getUpdate()==update){
                    System.out.println("id:"+ user.getId());
                    // users.addAll(new EditareServiciiPreturi(user.getId(), user.getPreturi(), user.getServicii(), new Button("update")));
                    System.out.println("preturi:"+ user.getPrices());
                    System.out.println("servicii:"+ user.getItems());


                }
            }
        });
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Button getUpdate() {  return update; }

    public void setUpdate(Button update) { this.update = update; }
}