package com.freightcom.clickship.model.exchange.rates;

import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRate implements Serializable {

	private static final long serialVersionUID = 4316633291858438982L;
	
	@XmlElement(name= "observations", required = true)
	private ExchangeRate.Observations observations;

	public ExchangeRate() {
		super();
	}

    public ExchangeRate.Observations getObservations() {
		return observations;
	}

	public void setObservations(ExchangeRate.Observations observations) {
		this.observations = observations;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
	public static class Observations {
		
		@XmlElement(name= "o", required = true)
		private List<O> o;
		
		public List<O> getO() {
			return o;
		}

		public Observations setO(List<O> o) {
			this.o = o;
			return this;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
	    @XmlType(name = "", propOrder = {

	    })
		public static class O {
			
			@XmlAttribute(name = "d")
			private String d;
			
			@XmlElement(name= "v", required = true)
			private List<V> v;
			
			public String getD() {
				return d;
			}

			public void setD(String d) {
				this.d = d;
			}

			public List<V> getV() {
				return v;
			}

			public void setV(List<V> v) {
				this.v = v;
			}

			@XmlAccessorType(XmlAccessType.FIELD)
		    @XmlType(name = "", propOrder = {

		    })
			public static class V {
				
				@XmlAttribute(name = "s")
				private String s;
				
				@XmlValue
				private double value;

				public String getS() {
					return s;
				}

				public void setS(String s) {
					this.s = s;
				}

				public double getValue() {
					return value;
				}

				public void setValue(double value) {
					this.value = value;
				}
				
			}
		}
	}	

}
