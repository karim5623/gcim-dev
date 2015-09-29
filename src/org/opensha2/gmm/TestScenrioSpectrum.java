package org.opensha2.gmm;

import static com.google.common.base.StandardSystemProperty.LINE_SEPARATOR;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.opensha2.programs.DeterministicSpectra;
import org.opensha2.programs.DeterministicSpectra.MultiResult;
import org.opensha2.programs.DeterministicSpectra.Result;


public class TestScenrioSpectrum {
	
	public static void main (String args[])  {	
		
		Gmm gmm1 = Gmm.BA_08;
		Gmm gmm2 = Gmm.CY_08;
		Gmm gmm3 = Gmm.CB_14;
	
		Set<Gmm> gmmSet = new HashSet<Gmm>();
		gmmSet.add(gmm1);
		gmmSet.add(gmm2);
		gmmSet.add(gmm3);
		
		
		
		double siteLat = 38.0;
		double siteLon = -122.0;
		double siteDepth = 0.0;
		double siteVs30 = 250;
		double depth1p0=0.2; //in km
		double depth2p5=0.6; //in km
		String siteName = "Test Site";
		double mag = 7.5;
		double rJB = 10.0;
		double rRup = 10.3;
		double dip = 90;
		double rake = 0;
		double zTop = 0.1;
		
		GmmInput gmmInput = GmmInput.builder()
				.withDefaults()
				.mag(mag)
				.rJB(rJB)
				.rRup(rRup)
				.dip(dip)
				.rake(rake)
				.vs30(siteVs30)
				.vsInf(true)
				.zTop(zTop)
				.z1p0(depth1p0)
				.z2p5(depth2p5)
				.build();
		
		// for multiple gmms 
		MultiResult multiGmmResults = DeterministicSpectra.spectra(gmmSet, gmmInput);
		System.out.println((multiGmmResults.meanMap));
		
//		// for a single gmm 
//		Result singleGmmResults = DeterministicSpectra.spectrum(gmm1, gmmInput);
//
//		StringBuilder sb = new StringBuilder();
//		sb.append("periods=").append(Arrays.toString(singleGmmResults.periods));
//		sb.append(LINE_SEPARATOR.value());
//		sb.append("means=").append(Arrays.toString(singleGmmResults.means));
//		sb.append(LINE_SEPARATOR.value());
//		sb.append("sigmas=").append(Arrays.toString(singleGmmResults.sigmas));
//		
//		System.out.println(sb.toString());
//		System.out.println(LINE_SEPARATOR.value());	
		
		
	}
}
