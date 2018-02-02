import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.*;
import java.util.*;

public class Main extends Application{    /*******English Translations*********/
  private Button vazio = new Button();           //empty
  private Button btnConversor = new Button();    //btnConverter
  private Button btnEletricidade = new Button(); //btnElectricity
  private Button btnRelatividade = new Button(); //btnRelativity
  private Button btnDilatacao = new Button();    //btnDilation
  private Button btnAceleracao = new Button();   //btnAcceleration
  private Button btnForca = new Button();        //btnPower
  private Button btnAtrito = new Button();       //btnFriction
  private Button btnEnergia = new Button();      //btnEnergy
  private Button btnImpulso = new Button();      //btnImpulse
  private Button btnGravitacao = new Button();   //btnGravitation
  private Button btnEntropia = new Button();     //btnEntropy
  private Button btnFormulas = new Button();     //btnFormulas
  private Button btnDoar = new Button();         //btnDonate
  private Button btnSair = new Button();         //btnExit

  private VBox layout = new VBox();
  private HBox hb1 = new HBox();
  private HBox hb2 = new HBox();
  private HBox hb3 = new HBox();

  public static void main(String[] args) {
    launch(args);
   }

   @Override
   public void start(Stage stage) throws Exception {

     //Descobre o idioma do Sistema Operacional
     //Get Operating System's Language
     Locale loc = Locale.getDefault();
     String lang = loc.getLanguage();
     String cntr = loc.getCountry();

     //Chama arquivo de strings com o idioma detectado
     //Call strings file with detected language
     loc = new Locale(lang, cntr);
     ResourceBundle sf = ResourceBundle.getBundle("lang.strings", loc);

     stage.setTitle("LiraPhysics");
     stage.initStyle(StageStyle.UNDECORATED);

     layout.getChildren().addAll(hb1, hb2, hb3);
     hb1.getChildren().addAll(btnConversor, btnEletricidade, btnRelatividade, btnDilatacao, btnAceleracao);
     hb2.getChildren().addAll(btnForca, btnAtrito, btnEnergia, btnImpulso, btnGravitacao);
     hb3.getChildren().addAll(btnEntropia, vazio, btnFormulas, btnDoar, btnSair);


      //Define propriedades dos componentes
      //Defines components properties
      layout.setMinWidth(900); layout.setMinHeight(600);

      hb1.setTranslateY(25);
      hb2.setTranslateY(150);
      hb3.setTranslateY(260);

      btnConversor.setMinWidth(100); btnConversor.setMinHeight(100); btnConversor.setTranslateX(35); btnConversor.setTooltip(new Tooltip(sf.getString("btnConversor")));
      btnEletricidade.setMinWidth(100); btnEletricidade.setMinHeight(100); btnEletricidade.setTranslateX(110); btnEletricidade.setTooltip(new Tooltip(sf.getString("btnEletricidade")));
      btnRelatividade.setMinWidth(100); btnRelatividade.setMinHeight(100); btnRelatividade.setTranslateX(185);
      btnDilatacao.setMinWidth(100); btnDilatacao.setMinHeight(100); btnDilatacao.setTranslateX(260);
      btnAceleracao.setMinWidth(100); btnAceleracao.setMinHeight(100); btnAceleracao.setTranslateX(335); btnAceleracao.setTooltip(new Tooltip(sf.getString("btnAceleracao")));

      btnForca.setMinWidth(100); btnForca.setMinHeight(100); btnForca.setTranslateX(35);
      btnAtrito.setMinWidth(100); btnAtrito.setMinHeight(100); btnAtrito.setTranslateX(110);
      btnEnergia.setMinWidth(100); btnEnergia.setMinHeight(100); btnEnergia.setTranslateX(185); btnEnergia.setTooltip(new Tooltip(sf.getString("btnEnergia")));
      btnImpulso.setMinWidth(100); btnImpulso.setMinHeight(100); btnImpulso.setTranslateX(260);
      btnGravitacao.setMinWidth(100); btnGravitacao.setMinHeight(100); btnGravitacao.setTranslateX(335);

      btnEntropia.setMinWidth(100); btnEntropia.setMinHeight(100); btnEntropia.setTranslateX(35);
      vazio.setMinWidth(100); vazio.setMinHeight(100); vazio.setTranslateX(110);
      btnFormulas.setMinWidth(100); btnFormulas.setMinHeight(100); btnFormulas.setTranslateX(185); btnFormulas.setTooltip(new Tooltip(sf.getString("btnFormulas")));
      btnDoar.setMinWidth(100); btnDoar.setMinHeight(100); btnDoar.setTranslateX(260); btnDoar.setTooltip(new Tooltip(sf.getString("btnDoar")));
      btnSair.setMinWidth(100); btnSair.setMinHeight(100); btnSair.setTranslateX(335); btnSair.setTooltip(new Tooltip(sf.getString("btnSair")));

      //Define as classes para uso no arquivo CSS
      //Defines classes for use in CSS file
      layout.getStyleClass().add("layout");
      btnConversor.getStyleClass().add("btnConversor");
      btnEletricidade.getStyleClass().add("btnEletricidade");
      btnRelatividade.getStyleClass().add("btnRelatividade");
      btnDilatacao.getStyleClass().add("btnDilatacao");
      btnAceleracao.getStyleClass().add("btnAceleracao");
      btnForca.getStyleClass().add("btnForca");
      btnAtrito.getStyleClass().add("btnAtrito");
      btnEnergia.getStyleClass().add("btnEnergia");
      btnImpulso.getStyleClass().add("btnImpulso");
      btnGravitacao.getStyleClass().add("btnGravitacao");
      btnEntropia.getStyleClass().add("btnEntropia");
      vazio.getStyleClass().add("vazio");
      btnFormulas.getStyleClass().add("btnFormulas");
      btnDoar.getStyleClass().add("btnDoar");
      btnSair.getStyleClass().add("btnSair");

     Scene scn = new Scene(layout, 900, 600);
     scn.getStylesheets().add("/styles/main.css");
     stage.setScene(scn);
     stage.setResizable(false);
     stage.show();
     stage.setOnCloseRequest(e-> System.exit(0));
     stage.getIcons().add(new Image("/img/icon.png"));

     //Chamar novas janelas ao clicar nos botões
     //Call new windows on buttons click 
     btnConversor.setOnAction(e -> {
       Conversor conversor = new Conversor();
       conversor.start(Conversor.stg);
     });

     btnEletricidade.setOnAction(e-> {
       Eletricidade eletricidade = new Eletricidade();
       eletricidade.start(Eletricidade.stg);
     });

     btnSair.setOnAction(e -> System.exit(0));
   }

}
