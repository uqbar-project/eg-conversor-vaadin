package org.uqbar

import java.text.NumberFormat
import java.util.Locale
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class ConversorDomain {
	double millas = 0
	double kilometros = 0
	
	def void convertir() {
		this.kilometros = this.millas * 1.60934
	}
	
	def kilometrosAsString() {
		NumberFormat.getInstance(new Locale("es")).format(this.kilometros)
	}
	
}