package logic.controllergraphics;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import logic.bean.PublicTravelBean;

public class PublicTravelDetailView {
	
 	@FXML
    private Label lblUsernameTravel;

    @FXML
    private Label lblDest;

    @FXML
    private Label lblData;

    @FXML
    private Label lblPosti;

    @FXML
    private Label lblDataEnd;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblStars;

    @FXML
    private Label lblTravellers;

    @FXML
    private Label lblRooms;

    @FXML
    private Label lblBreakfast;

    @FXML
    private Label lblHotelName;

    @FXML
    private TextArea txtDescription;
    
    private PublicTravelBean vgr;
    
    @FXML
    void onMouseHotelNameClicked(MouseEvent event) {
    	openLinkHotel(vgr.getHotelInfo().getHotelLink());
    }

    @FXML
    void onMouseHotelNameEntered(MouseEvent event) {
    	lblHotelName.setTextFill(Color.web("#153bc2"));
    }

    @FXML
    void onMouseHotelNameExited(MouseEvent event) {
    	lblHotelName.setTextFill(Color.web("#f9ab51"));
    }
    
    private void openLinkHotel(String link) {
		try {
			Desktop.getDesktop().browse(new URL(link).toURI());
		} catch (IOException|URISyntaxException e) {
			e.printStackTrace();
		}
	}
    
    public void setTravelInfo(PublicTravelBean vgr) {
    	this.vgr = vgr;
    	lblUsernameTravel.setText(vgr.getCreator());
    	lblDest.setText(vgr.getDestination());
    	lblData.setText(vgr.getStartDate());
    	lblDataEnd.setText(vgr.getEndDate());
    	lblPosti.setText(vgr.getAvailableSeats());
    	lblHotelName.setText(vgr.getHotelInfo().getHotelName());
    	lblStars.setText(vgr.getHotelInfo().getStars());
    	lblRooms.setText(vgr.getHotelInfo().getNumRooms());
    	lblBreakfast.setText(vgr.getHotelInfo().getBreakfast());
    	String price = vgr.getHotelInfo().getPrice();
    	price = price.replace("euro", "�");
    	lblPrice.setText(price);
    	lblTravellers.setText(vgr.getNumMaxUt());
    	txtDescription.setText(vgr.getDescription());
    }
	
}
