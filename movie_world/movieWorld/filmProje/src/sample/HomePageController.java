package sample;

import java.io.File;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomePageController {

    Connection connection;
    ArrayList<Film> movies;


    public HomePageController() throws Exception {
        connection = getConnection();
    }



    ObservableList list= FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPaneHome;

    @FXML
    private ImageView movieImage;

    @FXML
    private TextField movieName;

    @FXML
    private TextField movieDate;

    @FXML
    private TextField movieDirector;

    @FXML
    private TextField movieCategory;

    @FXML
    private TextField movieIMDB;

    @FXML
    private TextField movieTime;

    @FXML
    private TextField moviePrice;

    @FXML
    private Text totalPrice;


    @FXML
    void btnRent(ActionEvent event) {
        totalPrice.setText(moviePrice.getText()+" payment has been made \nMovie World wishes you a good time.");
    }


    @FXML
    private TextArea screen;

    @FXML
    private ListView<String> movieList;

    @FXML
    void displayMovie(MouseEvent event) {
        String movie=movieList.getSelectionModel().getSelectedItem();
        int id=movieList.getSelectionModel().getSelectedIndex();
        if(movie==null || movie.isEmpty()){
            screen.setText("Yok bişi gardaş");
        }else{
            Film showedFilm=movies.get(id);
            screen.setText(showedFilm.getHint());
            movieName.setText(showedFilm.getName());
            movieCategory.setText(showedFilm.getCategory());
            movieDirector.setText(showedFilm.getMovieDirector());
            movieDate.setText(String.valueOf(showedFilm.getDate()));
            movieTime.setText(showedFilm.getTime());
            moviePrice.setText(showedFilm.getPrice());
            movieIMDB.setText(String.valueOf(showedFilm.getImdb()));
            File file = new File("src/images/"+showedFilm.getId()+".jpg");
            Image image = new Image(file.toURI().toString());
            movieImage.setImage(image);


        }


    }

    @FXML
    void initialize() throws SQLException {
        assert movieList != null : "fx:id=\"movieList\" was not injected: check your FXML file 'HomePage.fxml'.";
        loadData();
    }

    private void loadData() throws SQLException {
        list.removeAll(list);
        getAllMovies();


        for(Film film : movies){
            list.add(film.getName());
        }
        movieList.getItems().addAll(list);

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

    private void getAllMovies() throws SQLException {

        movies=new ArrayList();
        Statement stmt = connection.createStatement();
        String SQL = "SELECT * FROM movie_list";
        ResultSet rs = stmt.executeQuery(SQL);



        // Check Username and Password
        while (rs.next()) {
            Film film = new Film();
            film.setId(rs.getInt("id"));
            film.setName( rs.getString("movie_name"));
            film.setMovieDirector(rs.getString("movie_director"));
            film.setCategory(rs.getString("movie_category"));
            film.setImdb(rs.getDouble("movie_imdb"));
            film.setHint(rs.getString("movie_hint"));
            film.setDate(rs.getInt("movie_date"));
            film.setPrice(rs.getString("movie_price"));
            film.setTime(rs.getString("movie_time"));
            movies.add(film);

        }

    }




}
