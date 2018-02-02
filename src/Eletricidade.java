import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import java.util.*;
import java.text.*;

public class Eletricidade extends Application{
  static Stage stg = new Stage();

  private Label lblCalcularResistencia = new Label();
  private Button btnCalcularResistencia = new Button();
  private Label lblResistencia = new Label("Resultado:");
  private TextField txtUResistencia = new TextField();
  private TextField txtIResistencia = new TextField();

  //Variáveis para calcular potência (Watt)
  private Label lblCalcularPotencia = new Label("Calcular Potência");
  private Button btnCalcularPotencia = new Button("Calcular");
  private Label lblPotencia = new Label("Resultado:");
  private TextField txtIPotencia = new TextField();
  private TextField txtUPotencia = new TextField();

  //Variáveis para calcular corrente (Ampère)
  private Label lblCalcularCorrente = new Label("Calcular Corrente");
  private Button btnCalcularCorrente = new Button("Calcular");
  private Label lblCorrente = new Label("Resultado:");
  private TextField txtUCorrente = new TextField();
  private TextField txtRCorrente = new TextField();

  //Variáveis para calcular tensão (Volt)
  private Label lblCalcularTensao = new Label("Calcular Tensao");
  private Button btnCalcularTensao = new Button("Calcular");
  private Label lblTensao = new Label("Resultado:");
  private TextField txtITensao = new TextField();
  private TextField txtRTensao = new TextField();

  //Variáveis para calcular consumo (kWh)
  private Label lblCalcularConsumo = new Label("Calcular Consumo");
  private Button btnCalcularConsumo = new Button("Calcular");
  private Label lblConsumo = new Label("Resultado:");
  private TextField txtPConsumo = new TextField();
  private TextField txtTConsumo = new TextField();

  double resultado;

  NumberFormat nf = new DecimalFormat("##.##");
  DecimalFormat df = new DecimalFormat();

  ScrollPane scr = new ScrollPane();
  VBox layout = new VBox();
  VBox vb1 = new VBox();
  HBox hb1 = new HBox();
  VBox vb2 = new VBox();
  HBox hb2 = new HBox();
  VBox vb3 = new VBox();
  HBox hb3 = new HBox();
  VBox vb4 = new VBox();
  HBox hb4 = new HBox();
  VBox vb5 = new VBox();
  HBox hb5 = new HBox();


  @Override
  public void start(Stage stage) {
    Locale loc = Locale.getDefault();
    String lang = loc.getLanguage();
    String cntr = loc.getCountry();

    //Chama arquivo de strings com o idioma detectado
    loc = new Locale(lang, cntr);
    ResourceBundle sf = ResourceBundle.getBundle("lang.strings", loc);

    //Nomear componentes
    lblCalcularResistencia.setText(sf.getString("calcularResistencia"));

    btnCalcularResistencia.setText(sf.getString("btnCalcular"));
    btnCalcularPotencia.setText(sf.getString("btnCalcular"));
    btnCalcularCorrente.setText(sf.getString("btnCalcular"));
    btnCalcularTensao.setText(sf.getString("btnCalcular"));
    btnCalcularConsumo.setText(sf.getString("btnCalcular"));

    lblResistencia.setText(sf.getString("lblTextoResultado"));
    lblPotencia.setText(sf.getString("lblTextoResultado"));
    lblCorrente.setText(sf.getString("lblTextoResultado"));
    lblTensao.setText(sf.getString("lblTextoResultado"));
    lblConsumo.setText(sf.getString("lblTextoResultado"));

    //Cria janela
    stage.setTitle("LiraPhysics - " + sf.getString("btnEletricidade"));

    scr.setContent(layout);
    scr.setPrefHeight(450);
    scr.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    //scr.setOrientation(Orientation.VERTICAL);

    // pnlResistencia.setText("Calcular Resistência");
    layout.getChildren().addAll(vb1, vb2, vb3, vb4, vb5);
    vb1.getChildren().addAll(lblCalcularResistencia, hb1, lblResistencia);
    hb1.getChildren().addAll(txtUResistencia, txtIResistencia, btnCalcularResistencia);

    vb2.getChildren().addAll(lblCalcularPotencia, hb2, lblPotencia);
    hb2.getChildren().addAll(txtIPotencia, txtUPotencia, btnCalcularPotencia);

    vb3.getChildren().addAll(lblCalcularCorrente, hb3, lblCorrente);
    hb3.getChildren().addAll(txtUCorrente, txtRCorrente, btnCalcularCorrente);

    vb4.getChildren().addAll(lblCalcularTensao, hb4, lblTensao);
    hb4.getChildren().addAll(txtITensao, txtRTensao, btnCalcularTensao);

    vb5.getChildren().addAll(lblCalcularConsumo, hb5, lblConsumo);
    hb5.getChildren().addAll(txtPConsumo, txtTConsumo, btnCalcularConsumo);

    //Posições
    layout.setAlignment(Pos.TOP_CENTER); layout.setPrefWidth(291); layout.setPrefHeight(675);

    vb1.setTranslateY(30); vb1.setAlignment(Pos.CENTER); vb1.setMaxWidth(270) ; vb1.setMinHeight(100);
    txtUResistencia.setTranslateX(5);
    txtIResistencia.setTranslateX(10);
    btnCalcularResistencia.setTranslateX(15);
    lblCalcularResistencia.setTranslateY(-15);
    lblResistencia.setTranslateY(15);

    txtIResistencia.setMaxWidth(70); txtIResistencia.setPromptText("I");
    txtUResistencia.setMaxWidth(70); txtUResistencia.setPromptText("U");

    vb2.setTranslateY(60); vb2.setAlignment(Pos.CENTER); vb2.setMaxWidth(270) ; vb2.setMinHeight(100);
    txtIPotencia.setTranslateX(5);
    txtUPotencia.setTranslateX(10);
    btnCalcularPotencia.setTranslateX(15);
    lblCalcularPotencia.setTranslateY(-15);
    lblPotencia.setTranslateY(15);

    txtIPotencia.setMaxWidth(70); txtIPotencia.setPromptText("I");
    txtUPotencia.setMaxWidth(70); txtUPotencia.setPromptText("U");

    vb3.setTranslateY(90); vb3.setAlignment(Pos.CENTER); vb3.setMaxWidth(270) ; vb3.setMinHeight(100);
    txtUCorrente.setTranslateX(5);
    txtRCorrente.setTranslateX(10);
    btnCalcularCorrente.setTranslateX(15);
    lblCalcularCorrente.setTranslateY(-15);
    lblCorrente.setTranslateY(15);

    txtUCorrente.setMaxWidth(70); txtUCorrente.setPromptText("U");
    txtRCorrente.setMaxWidth(70); txtRCorrente.setPromptText("R");

    vb4.setTranslateY(120); vb4.setAlignment(Pos.CENTER); vb4.setMaxWidth(270) ; vb4.setMinHeight(100);
    txtITensao.setTranslateX(5);
    txtRTensao.setTranslateX(10);
    btnCalcularTensao.setTranslateX(15);
    lblCalcularTensao.setTranslateY(-15);
    lblTensao.setTranslateY(15);

    txtITensao.setMaxWidth(70); txtITensao.setPromptText("I");
    txtRTensao.setMaxWidth(70); txtRTensao.setPromptText("R");

    vb5.setTranslateY(150); vb5.setAlignment(Pos.CENTER); vb5.setMaxWidth(270) ; vb5.setMinHeight(100);
    txtPConsumo.setTranslateX(5);
    txtTConsumo.setTranslateX(10);
    btnCalcularConsumo.setTranslateX(15);
    lblCalcularConsumo.setTranslateY(-15);
    lblConsumo.setTranslateY(15);

    txtPConsumo.setMaxWidth(70); txtPConsumo.setPromptText("P");
    txtTConsumo.setMaxWidth(70); txtTConsumo.setPromptText("ΔT");

    //layout
    layout.getStyleClass().add("layout");
    vb1.getStyleClass().add("vbEletricidade");
    vb2.getStyleClass().add("vbEletricidade");
    vb3.getStyleClass().add("vbEletricidade");
    vb4.getStyleClass().add("vbEletricidade");
    vb5.getStyleClass().add("vbEletricidade");



    Scene scn = new Scene(scr, 310, 450);
    scn.getStylesheets().add("/styles/geral.css");
    stage.setScene(scn);
    stg = stage;
    stg.setResizable(false);
    stg.show();

    btnCalcularResistencia.setOnAction(e-> exibirResistencia());
    btnCalcularPotencia.setOnAction(e-> exibirPotencia());
    btnCalcularCorrente.setOnAction(e-> exibirCorrente());
    btnCalcularTensao.setOnAction(e-> exibirTensao());
    btnCalcularConsumo.setOnAction(e-> exibirConsumo());
  }

  private void exibirResistencia() {
    df.setDecimalSeparatorAlwaysShown(false);

    double u = Double.parseDouble(txtUResistencia.getText());
    double i = Double.parseDouble(txtIResistencia.getText());

		double r = Formulas.resistencia(u, i);

    lblResistencia.setText("R = " + String.valueOf(df.format(Double.parseDouble(nf.format(r)))) + "Ω");
	}

  private void exibirPotencia() {
    df.setDecimalSeparatorAlwaysShown(false);

    double i = Double.parseDouble(txtIPotencia.getText());
    double u = Double.parseDouble(txtUPotencia.getText());

    double p = Formulas.potencia(i, u);

    lblPotencia.setText("P = " + String.valueOf(df.format(Double.parseDouble(nf.format(p)))) + "W");
  }

  private void exibirCorrente() {
    df.setDecimalSeparatorAlwaysShown(false);

    double u = Double.parseDouble(txtUCorrente.getText());
    double r = Double.parseDouble(txtRCorrente.getText());

		double i = Formulas.corrente(u, r);

    lblCorrente.setText("I = " + String.valueOf(df.format(Double.parseDouble(nf.format(i)))) + "A");
  }

  private void exibirTensao() {
    df.setDecimalSeparatorAlwaysShown(false);

    double i = Double.parseDouble(txtITensao.getText());
    double r = Double.parseDouble(txtRTensao.getText());

		double u = Formulas.tensao(i, r);

    lblTensao.setText("U = " + String.valueOf(df.format(Double.parseDouble(nf.format(u)))) + "V");
  }

  private void exibirConsumo() {
    df.setDecimalSeparatorAlwaysShown(false);

    double p = Double.parseDouble(txtPConsumo.getText());
    double dt = Double.parseDouble(txtTConsumo.getText());

		double c = Formulas.consumo(p, dt);

    lblConsumo.setText("C = " + String.valueOf(df.format(Double.parseDouble(nf.format(c)))) + "kWh");
  }
}
