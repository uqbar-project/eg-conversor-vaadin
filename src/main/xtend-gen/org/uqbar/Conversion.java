package org.uqbar;

import java.time.LocalDateTime;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.uqbar.UIFormatter;

@Data
@SuppressWarnings("all")
public class Conversion {
  private final LocalDateTime fecha;
  
  private final double millas;
  
  private final double kilometros;
  
  public String getFechaAsString() {
    return UIFormatter.asString(this.fecha);
  }
  
  public String getMillasAsString() {
    return UIFormatter.asString(this.millas);
  }
  
  public String getKilometrosAsString() {
    return UIFormatter.asString(this.kilometros);
  }
  
  public Conversion(final LocalDateTime fecha, final double millas, final double kilometros) {
    super();
    this.fecha = fecha;
    this.millas = millas;
    this.kilometros = kilometros;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.fecha== null) ? 0 : this.fecha.hashCode());
    result = prime * result + (int) (Double.doubleToLongBits(this.millas) ^ (Double.doubleToLongBits(this.millas) >>> 32));
    return prime * result + (int) (Double.doubleToLongBits(this.kilometros) ^ (Double.doubleToLongBits(this.kilometros) >>> 32));
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Conversion other = (Conversion) obj;
    if (this.fecha == null) {
      if (other.fecha != null)
        return false;
    } else if (!this.fecha.equals(other.fecha))
      return false;
    if (Double.doubleToLongBits(other.millas) != Double.doubleToLongBits(this.millas))
      return false; 
    if (Double.doubleToLongBits(other.kilometros) != Double.doubleToLongBits(this.kilometros))
      return false; 
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("fecha", this.fecha);
    b.add("millas", this.millas);
    b.add("kilometros", this.kilometros);
    return b.toString();
  }
  
  @Pure
  public LocalDateTime getFecha() {
    return this.fecha;
  }
  
  @Pure
  public double getMillas() {
    return this.millas;
  }
  
  @Pure
  public double getKilometros() {
    return this.kilometros;
  }
}
