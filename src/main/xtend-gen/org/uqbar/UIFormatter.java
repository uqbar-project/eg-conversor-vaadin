package org.uqbar;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@SuppressWarnings("all")
public class UIFormatter {
  public static String asString(final double number) {
    Locale _locale = new Locale("es");
    return NumberFormat.getInstance(_locale).format(number);
  }
  
  public static String asString(final LocalDateTime moment) {
    return moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
  }
}
