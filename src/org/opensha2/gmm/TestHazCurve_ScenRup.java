package org.opensha2.gmm;

import java.io.IOException;

import org.opensha2.calc.Site;

public class TestHazCurve_ScenRup {

	public static void main (String args[]) throws IOException {
		
		// set up input parameters
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
		
		Site site = Site.builder()
				.name(siteName)
				.location(siteLat,siteLon)
				.vs30(siteVs30)
				.vsInferred(true)
				.z1p0(depth1p0)
				.z2p5(depth2p5)
				.build();
		System.out.println(site);
		
		// look into the GmmInput file to see the other parameters 
		GmmInput gmmInput = GmmInput.builder()
				.withDefaults()
				.mag(mag)
				.rJB(rJB)
				.rRup(rRup)
				.z1p0(depth1p0)
				.dip(dip)
				.build();
		System.out.println("gmmInput: "+ gmmInput);	
		
		
		Gmm gmm = Gmm.BA_08;
		Imt imt = Imt.PGA;
		
		// look into the Imt enum to see the possible Ims that u can use in the approach
		//Imt imt = Imt.SA2P5; 
		
		//a group of Gmms and Ims
//		Set<Gmm> gmms = EnumSet.of(ASK_14, BSSA_14, CB_14, CY_14, IDRISS_14);
//		Set<Imt> imts = EnumSet.of(PGA, SA0P02, SA0P2, SA1P0, SA3P0);
		
		GroundMotionModel gmModel = gmm.instance(imt);
		ScalarGroundMotion sgm = gmModel.calc(gmmInput);
		
		String median = String.format("%.6f", Math.exp(sgm.mean()));
		String sigma = String.format("%.6f", sgm.sigma());
		
		System.out.println("median: "+median);
		System.out.println("sigma: "+sigma);		
		
	}
			
}
