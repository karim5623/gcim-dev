package org.opensha2.TestCodes_KT;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.opensha2.eq.model.HazardModel;

public class TestHazCurveCalcHeir {
	
	
	public static void main (String args[])  {
		
		
		Path modelPath = Paths.get("..","gcim-dev","src","org","opensha2","gmm","FiniteFaultModel");
		HazardModel model = HazardModel.load(modelPath);
	}

}
