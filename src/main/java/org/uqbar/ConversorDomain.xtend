package org.uqbar

import java.io.Serializable
import java.time.LocalDateTime
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data

import static extension org.uqbar.UIFormatter.*

@Accessors
class ConversorDomain implements Serializable {
	double millas = 0
	double kilometros = 0
	List<Conversion> conversiones = newArrayList
	
	def void convertir() {
		this.kilometros = this.millas * 1.60934
		conversiones.add(new Conversion(LocalDateTime.now, this.millas, this.kilometros))
	}
	
	def kilometrosAsString() {
		this.kilometros.asString
	}
	
}

@Data
class Conversion {
	LocalDateTime fecha
	double millas
	double kilometros
	
	def getFechaAsString() {
		this.fecha.asString
	}
	
	def getMillasAsString() {
		this.millas.asString
	}
	
	def getKilometrosAsString() {
		this.kilometros.asString
	}
}

