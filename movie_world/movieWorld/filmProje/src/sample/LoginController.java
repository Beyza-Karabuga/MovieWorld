package sample;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Stage;


public class LoginController {

    Connection connection;

    @FXML
    private AnchorPane rootPane;

    public LoginController () throws Exception {
        connection = getConnection();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSignUp;

    @FXML
    private TextField txtEmail;


    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnSignIn;

    @FXML
    void btnSignIn(ActionEvent event) throws Exception{
        String email=txtEmail.getText();
        String password=txtPassword.getText();
        String databaseUsername = null;
        String databasePassword = null;

        Statement stmt = connection.createStatement();
        String SQL = "SELECT * FROM user_list WHERE user_email='" + email + "' && user_password='" + password+ "'";
        ResultSet rs = stmt.executeQuery(SQL);


        // Check Username and Password
        while (rs.next()) {
            databaseUsername = rs.getString("user_email");
            databasePassword = rs.getString("user_password");
        }

        if (email.equals(databaseUsername) && password.equals(databasePassword)) {
            System.out.println("Successful Login!\n----");
            //Diğer sayfaya aktarma işlemleri



            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();


            Stage stageClosed = (Stage) btnSignIn.getScene().getWindow();
            stageClosed.close();
            connection.close();



        } else {
            System.out.println("Incorrect\n----");
        }

    }

    @FXML
    void btnSignUp(ActionEvent event) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUpPage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();


        Stage stageClosed = (Stage) btnSignUp.getScene().getWindow();
        stageClosed.close();
        connection.close();

    }



    @FXML
    void initialize() {
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'sample.fxml'.";

    }

    public  Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/movies?characterEncoding=latin1&useConfigs=maxPerformance";
            String username = "root";
            String password = "123456";
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return connection;
        }
        catch(Exception e){System.out.println(e);
            System.out.println(e.getMessage());
        }

        return null;
    }
}
