package org.opensha2.gmm;

import static com.google.common.base.CaseFormat.UPPER_CAMEL;
import static com.google.common.base.CaseFormat.UPPER_UNDERSCORE;

import org.opensha2.gmm.GmmInput.Field;

import com.google.common.base.CaseFormat;

public class TestEnum {
	
	private enum GmmElement {

		GROUND_MOTION_MODELS,
		UNCERTAINTY,
		MODEL_SET,
		MODEL;
		
		public String toString() { 
			return UPPER_UNDERSCORE.to(UPPER_CAMEL, name());
		}

		public static GmmElement fromString(String s) {
			return valueOf(UPPER_CAMEL.to(UPPER_UNDERSCORE, s));
		}
		
	}
	
//	test enums with fields in them
//	note: in order to access the fields of each enum, u need to define enum varaibles similar to
//	class variables and then define a contructor. An enum constructor has to be either private or package private
//	then u can have methods to access the enum fields
	
	private enum Field {

		MAG(
				"Magnitude",
				"The moment magnitude of an earthquake",
				null,
				6.5),

		RJB(
				"Joyner-Boore Distance",
				"The shortest distance from a site to the surface projection of a rupture, in kilometers",
				"km",
				10.0),

		RRUP(
				"Rupture Distance",
				"The shortest distance from a site to a rupture, in kilometers",
				"km",
				10.3);
		
		// enum fields
		public final String label;
		public final String info;
		public final String unit;
		public final double defaultValue;

		// enum constructor 
		private Field(String label, String info, String unit, double defaultValue) {
			this.label = label;
			this.info = info;
			this.unit = unit;
			this.defaultValue = defaultValue;
		}
		
		public String getLabel() {
			return this.label;
		}
		public String getInfo() {
			return this.info;
		}
		public String getUnit() {
			return this.unit;
		}	
		public double getDefaultValue() {
			return this.defaultValue;
		}
		
	}

	
	public static void main (String[] args) {
		
		// test first enum
		for (GmmElement gmmEl : GmmElement.values()) {		
		     System.out.println(gmmEl);     
		     gmmEl.toString();
		     System.out.println(gmmEl);    
		 }
		GmmElement x = GmmElement.fromString("GroundMotionModels");
	    System.out.println(x);	
	    
	    
		// test second enum
	    Field myField = Field.MAG;
	    System.out.println(myField.getLabel());
	}
	

}
