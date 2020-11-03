package org.uqbar;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.Conversion;
import org.uqbar.UIFormatter;

@Accessors
@SuppressWarnings("all")
public class ConversorDomain implements Serializable {
  private double millas = 0;
  
  private double kilometros = 0;
  
  private List<Conversion> conversiones = CollectionLiterals.<Conversion>newArrayList();
  
  public void convertir() {
    this.kilometros = (this.millas * 1.60934);
    LocalDateTime _now = LocalDateTime.now();
    Conversion _conversion = new Conversion(_now, this.millas, this.kilometros);
    this.conversiones.add(_conversion);
  }
  
  public String kilometrosAsString() {
    return UIFormatter.asString(this.kilometros);
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
  
  @Pure
  public List<Conversion> getConversiones() {
    return this.conversiones;
  }
  
  public void setConversiones(final List<Conversion> conversiones) {
    this.conversiones = conversiones;
  }
}
