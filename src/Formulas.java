public class Formulas{

  //Mecanica dos gases e líquidos
  public static double pressaoP(double fn, double a) {
    double p = fn / a;
    return p;
  }

  public static double pressaoFn(double p, double a) {
    double fn = p * a;
    return fn;
  }

  public static double pressaoA(double p, double fn) {
    double a = fn / p;
    return a;
  }

  //public static double boyleP1(double p2, double v1, double v2) {}
  //public static double boyleP2(double p1, double v1, double v2) {}
  //public static double boyleV1(double p1, double p2, double v2) {}
  //public static double boyleV2(double p1, double p2, double v2) {}

  //schweredruck
  //auftriebskraft
  //gezetz von stokes

  public static double leiTorricelli(double g, double h) {
    double v = Math.sqrt(2*g*h);
    return v;
  }
  // torricelliG, torricelliH -> talvez

  //Calculos de Eletricidade
  public static double resistencia(double u, double i) {
    double r = u / i;
		return r;
	}

  public static double potencia(double i, double u) {
    double p = i * u;
    return p;
  }

  public static double corrente(double u, double r) {
    double i = u / r;
    return i;
  }

  public static double tensao(double i, double r) {
    double u = i * r;
    return u;
  }

  public static double consumo(double p, double dt) {
    double c = p / 1000 * dt;
    return c;
  }

  //Mecânica Elementar
  public static double velocidadeV(double s, double t) {
    double v = s / t;
    return v;
  }

  public static double velocidadeS(double t, double v) {
    double s = v * t;
    return s;
  }

  public static double velocidadeT(double v, double s) {
    double t = s / v;
    return t;
  }

  //Haftreibungskraft
  //Atrito de deslizamento
  //Hookeschess Gesetz

  // public static double

}//Classe
