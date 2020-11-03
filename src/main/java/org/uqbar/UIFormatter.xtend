package org.uqbar

import java.text.NumberFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class UIFormatter {
	
	def static asString(double number) {
		NumberFormat.getInstance(new Locale("es")).format(number)
	}
	
	def static asString(LocalDateTime moment) {
		moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
	}
}
