package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpPage {

    Connection connection;

    public SignUpPage() throws Exception {
        connection=getConnection();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNewName;

    @FXML
    private TextField txtNewSurname;

    @FXML
    private TextField txtNewEmail;

    @FXML
    private Button btnCreate;

    @FXML
    private PasswordField txtNewPassword;

    @FXML
    void btnCreateNewUser(ActionEvent event) throws IOException {
        String name,surname,email,password;
        name=txtNewName.getText();
        surname=txtNewSurname.getText();
        email=txtNewEmail.getText();
        password=txtNewPassword.getText();

        //Kayıt ol sayfasında kullanılacak
        try {
            String query = " insert into user_list (user_name,user_surname,user_email,user_password)"
                    + " values (?,?,?,?)";
            PreparedStatement preparedStmt = (PreparedStatement) connection.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, surname);
            preparedStmt.setString(3, email);
            preparedStmt.setString(4, password);
            preparedStmt.execute();
        }
        catch(Exception exception){
            System.out.println("Olmadı be");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();


        Stage stageClosed = (Stage) btnCreate.getScene().getWindow();
        stageClosed.close();
    }

    @FXML
    void initialize() {
        assert txtNewName != null : "fx:id=\"txtNewName\" was not injected: check your FXML file 'SignUpPage.fxml'.";
        assert txtNewSurname != null : "fx:id=\"txtNewSurname\" was not injected: check your FXML file 'SignUpPage.fxml'.";
        assert txtNewEmail != null : "fx:id=\"txtNewEmail\" was not injected: check your FXML file 'SignUpPage.fxml'.";
        assert btnCreate != null : "fx:id=\"btnCreate\" was not injected: check your FXML file 'SignUpPage.fxml'.";
        assert txtNewPassword != null : "fx:id=\"txtNewPassword\" was not injected: check your FXML file 'SignUpPage.fxml'.";

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
