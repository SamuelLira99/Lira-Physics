import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.*;
import java.text.*;
import javafx.scene.input.*;
import javafx.event.Event;

public class Conversor extends Application {
  static Stage stg = new Stage(); //Variavel usada pela classe principal para chamar esta janela
                                  //Variable used by main class to call this window

                                                              /********English Translations */
  private ComboBox<String> cmbEscInicial = new ComboBox<String>();  //cmbInitialScale  (cmb is from ComboBox)
  private ComboBox<String> cmbEscFinal = new ComboBox<String>();    //cmbFinalScale
  private Label lblInicial = new Label();                           //lblStart //Starting label
  private Label lblFinal = new Label();                             //lblFinal //Final label
	private Label lblTextoResultado = new Label();                    //lblResultText
	private Label lblResultado = new Label();                         //lblResult
	private Button btnConverter = new Button();                       //btnConvert
	private Button btnInverter = new Button();                        //btnReverse
	private Button btnLimpar = new Button();                          //btnClean
  private TextField txtValor = new TextField();                     //txtValue

  private VBox layout = new VBox();
  private HBox hb1 = new HBox();
  private HBox hb2 = new HBox();
  private HBox hb3 = new HBox();
  private HBox hb4 = new HBox();

  @Override
  public void start(Stage stage){
    //Descobre o idioma do Sistema Operacional
    Locale loc = Locale.getDefault();
    String lang = loc.getLanguage();
    String cntr = loc.getCountry();

    //Chama arquivo de strings com o idioma detectado
    loc = new Locale(lang, cntr);
    ResourceBundle sf = ResourceBundle.getBundle("lang.strings", loc);

    //Nomear componentes
    lblInicial.setText(sf.getString("lblInicial"));
    lblFinal.setText(sf.getString("lblFinal"));
    lblTextoResultado.setText(sf.getString("lblTextoResultado"));
    btnInverter.setText(sf.getString("btnInverter"));
    btnConverter.setText(sf.getString("btnConverter"));
    btnLimpar.setText(sf.getString("btnLimpar"));

    //Cria janela
    stage.setTitle("LiraPhysics - " + sf.getString("btnConversor"));

    layout.getChildren().addAll(hb1, hb2, hb3, hb4);
    hb1.getChildren().addAll(lblInicial, txtValor, cmbEscInicial);
    hb2.getChildren().addAll(lblFinal, cmbEscFinal);
    hb3.getChildren().addAll(btnInverter, btnConverter, btnLimpar);
    hb4.getChildren().addAll(lblTextoResultado, lblResultado);

    cmbEscInicial.getItems().addAll("ºC", "ºF", "K");
    cmbEscInicial.setValue("ºC");

    cmbEscFinal.getItems().addAll("ºC", "ºF", "K");
    cmbEscFinal.setValue("ºF");

    hb1.setTranslateY(25);
    hb2.setTranslateY(50);
    hb3.setTranslateY(75);
    hb4.setTranslateY(100);

    //Definição dos componentes
    lblInicial.setTranslateX(50); lblInicial.setPrefWidth(120);
    txtValor.setTranslateX(80); txtValor.setMaxWidth(75);
    cmbEscInicial.setTranslateX(100);

    lblFinal.setTranslateX(50); lblFinal.setPrefWidth(150);
    cmbEscFinal.setTranslateX(144);

    btnInverter.setTranslateX(12);
    btnConverter.setTranslateX(24);
    btnLimpar.setTranslateX(36);

    lblTextoResultado.setTranslateX(115);
    lblResultado.setTranslateX(125);

    //Define as classes para uso no CSS
    layout.getStyleClass().add("layout");

    //Tratamento de eventos
    btnConverter.setOnAction(e-> converter());

    btnInverter.setOnAction(e-> inverter());

    btnLimpar.setOnAction(e-> {
      lblResultado.setText("");
      txtValor.setText("");
      cmbEscInicial.setValue("ºC");
      cmbEscFinal.setValue("ºF");
    });

    txtValor.setOnKeyPressed(e-> {
      String anterior = txtValor.getText();
      // if(!((e.getCharacter().matches("[0-9]*") || (e.getCode() == KeyCode.PERIOD) || (e.getCode() == KeyCode.MINUS)))) {
      //   e.consume(); // não está funcionando


        // e.consume();
        // System.out.println(e.getCode());
        // txtValor.setText(anterior);
        // txtValor.setText("");

      if(e.getCode() == KeyCode.ENTER) {
        converter();
      } else if(e.getCode() == KeyCode.ESCAPE) {
        stg.close();
      }
    //}
    });
    //});

    Scene scn = new Scene(layout, 410, 200);
    scn.getStylesheets().add("/styles/geral.css");
    stage.setScene(scn);
    stg = stage;
    stg.setResizable(false);
    stg.show();
  }

  //Métodos

  public void inverter() {
    String cmb1 = cmbEscInicial.getValue();
    String cmb2 = cmbEscFinal.getValue();

    cmbEscInicial.setValue(cmb2);
    cmbEscFinal.setValue(cmb1);
  }

  //Metodos que calculam as formulas
	double converterCelsiusEmFahrenheit(double valor) {
		return valor * 1.8 + 32;
	}

	double converterFahrenheitEmCelsius(double valor) {
		return (valor - 32) / 1.8;
	}

	double converterCelsiusEmKelvin(double valor) {
		return valor + 273.15;
	}

	double converterKelvinEmCelsius(double valor) {
		return valor - 273.15;
	}

	double converterFahrenheitEmKelvil(double valor) {
		return (valor + 459.67) /1.8;
	}

	double converterKelvimEmFahrenheit(double valor) {
		return valor * 1.8 - 459.67;
	}

	//Método que exibe o resultado
	public void converter() {
		double valor = Double.parseDouble(txtValor.getText());
		String escala1 = (String) cmbEscInicial.getValue();
		String escala2 = (String) cmbEscFinal.getValue();
		double resultado = 0;

		//Define as variáveis para ter apenas 2 casas decimais
		NumberFormat nf = new DecimalFormat("##.##");
		double valorDecimal = Double.parseDouble(nf.format(valor));
		double resultadoDecimal = 0;

		//Define as variávis para não exibir casas decimais se for um número inteiro
		DecimalFormat df = new DecimalFormat();
		df.setDecimalSeparatorAlwaysShown(false);

		//Escolhe qual fórmula utilizar
		if(escala1 == "ºC" && escala2 == "ºF") {
			resultado = converterCelsiusEmFahrenheit(valor);
		}
		else if(escala1 == "ºF" && escala2 == "ºC") {
			resultado = converterFahrenheitEmCelsius(valor);
		}

		else if(escala1 == "ºC" && escala2 == "K") {
			resultado = converterCelsiusEmKelvin(valor);
		}

		else if(escala1 == "K" && escala2 == "ºC") {
			resultado = converterKelvinEmCelsius(valor);
		}

		else if(escala1 == "ºF" && escala2 == "K") {
			resultado = converterFahrenheitEmKelvil(valor);
		}

		else if (escala1 == "K" && escala2 == "ºF") {
			resultado = converterKelvimEmFahrenheit(valor);
		}

		resultadoDecimal = Double.parseDouble(nf.format(resultado));
		lblResultado.setText(String.valueOf(df.format(valorDecimal)) + " " + escala1 + " = " + String.valueOf(df.format(resultadoDecimal)) + " " + escala2);
	}
}
