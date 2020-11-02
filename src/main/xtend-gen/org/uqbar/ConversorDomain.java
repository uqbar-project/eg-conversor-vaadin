package org.uqbar;

import java.text.NumberFormat;
import java.util.Locale;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class ConversorDomain {
  private double millas = 0;
  
  private double kilometros = 0;
  
  public void convertir() {
    this.kilometros = (this.millas * 1.60934);
  }
  
  public String kilometrosAsString() {
    Locale _locale = new Locale("es");
    return NumberFormat.getInstance(_locale).format(this.kilometros);
  }
  
  @Pure
  public double getMillas() {
    return this.millas;
  }
  
  public void setMillas(final double millas) {
    this.millas = millas;
  }
  
  @Pure
  public double getKilometros() {
    return this.kilometros;
  }
  
  public void setKilometros(final double kilometros) {
    this.kilometros = kilometros;
  }
}
