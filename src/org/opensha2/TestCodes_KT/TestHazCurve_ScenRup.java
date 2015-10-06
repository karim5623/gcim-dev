package org.opensha2.TestCodes_KT;

import static org.opensha2.gmm.GmmInput.Field.DIP;
import static org.opensha2.gmm.GmmInput.Field.MAG;
import static org.opensha2.gmm.GmmInput.Field.RAKE;
import static org.opensha2.gmm.GmmInput.Field.RJB;
import static org.opensha2.gmm.GmmInput.Field.RRUP;
import static org.opensha2.gmm.GmmInput.Field.RX;
import static org.opensha2.gmm.GmmInput.Field.VS30;
import static org.opensha2.gmm.GmmInput.Field.VSINF;
import static org.opensha2.gmm.GmmInput.Field.WIDTH;
import static org.opensha2.gmm.GmmInput.Field.Z1P0;
import static org.opensha2.gmm.GmmInput.Field.Z2P5;
import static org.opensha2.gmm.GmmInput.Field.ZHYP;
import static org.opensha2.gmm.GmmInput.Field.ZTOP;

import java.io.IOException;

import org.opensha2.calc.Site;
import org.opensha2.gmm.Gmm;
import org.opensha2.gmm.GmmInput;
import org.opensha2.gmm.GroundMotionModel;
import org.opensha2.gmm.Imt;
import org.opensha2.gmm.ScalarGroundMotion;

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
		double rake = 0;
		double zTop = 0.1;
		
		// no need to have a site parameter for this calculation, because everything is set in GmmInput
//		Site site = Site.builder()
//				.name(siteName)
//				.location(siteLat,siteLon)
//				.vs30(siteVs30)
//				.vsInferred(true)
//				.z1p0(depth1p0)
//				.z2p5(depth2p5)
//				.build();
//		System.out.println(site);
		
		// parameters that u can set to a Gmm:
		// mag rJB rRup rX dip width zTop zHyp rake vs30 vsInf vs30 z1p0 z2p5 
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
