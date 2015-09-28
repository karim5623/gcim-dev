package org.opensha2.gmm;

import static org.opensha2.gmm.Gmm.ASK_14;
import static org.opensha2.gmm.Gmm.BSSA_14;
import static org.opensha2.gmm.Gmm.CB_14;
import static org.opensha2.gmm.Gmm.CY_14;
import static org.opensha2.gmm.Gmm.IDRISS_14;
import static org.opensha2.gmm.Imt.PGA;
import static org.opensha2.gmm.Imt.SA0P02;
import static org.opensha2.gmm.Imt.SA0P2;
import static org.opensha2.gmm.Imt.SA1P0;
import static org.opensha2.gmm.Imt.SA3P0;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.Function;

import org.opensha2.calc.Calcs;
import org.opensha2.calc.HazardResult;
import org.opensha2.calc.InputList;
import org.opensha2.calc.Site;
import org.opensha2.eq.model.HazardModel;
import org.opensha2.eq.model.Source;
import org.opensha2.eq.model.SourceSet;
import org.opensha2.gmm.Gmm;
import org.opensha2.gmm.GmmInput;
import org.opensha2.programs.HazardCurve;
import org.opensha2.util.Parsing.Delimiter;

import com.google.common.base.Optional;

public class TestHazCurve_ScenRup {

	public static void main (String args[]) throws IOException {
		
//		// set up input parameters
//		double siteLat = 38.0;
//		double siteLon = -122.0;
//		double siteDepth = 0.0;
//		double siteVs30 = 250;
//		double depth1p0=0.2;
//		String siteName = "Test Site";
//		double mag = 7.5;
//		double rRup = 10;
//		
//		
//		Site site = Site.builder()
//				.location(siteLat,siteLon)
//				.vs30(siteVs30)
//				.z1p0(depth1p0)
//				.build();
//		System.out.println(site);
//		
//		
//		GmmInput gmmInput = GmmInput.builder()
//				.withDefaults()
//				.mag(mag)
//				.rRup(rRup)
//				.z1p0(depth1p0)
//				.build();
//		System.out.println("gmmInput: "+ gmmInput);	
//		
//		
//		Gmm gmm = Gmm.BA_08;
//		Imt imt = Imt.PGA;
//		
////		Set<Gmm> gmms = EnumSet.of(ASK_14, BSSA_14, CB_14, CY_14, IDRISS_14);
////		Set<Imt> imts = EnumSet.of(PGA, SA0P02, SA0P2, SA1P0, SA3P0);
//		
//		GroundMotionModel gmModel = gmm.instance(imt);
//		ScalarGroundMotion sgm = gmModel.calc(gmmInput);
//		
//		String median = String.format("%.6f", Math.exp(sgm.mean()));
//		String sigma = String.format("%.6f", sgm.sigma());
//		
//		System.out.println("median: "+median);
//		System.out.println("sigma: "+sigma);		
		
		
		
		
		Path modelPath = Paths.get("..","nshmp-haz","etc","peer","models","Set1-Case1"); // add more as needed	
		HazardModel model = HazardModel.load(modelPath);
		System.out.println(model);
		
//		HazardResult result = HazardCurve.calc(
//				model, 
//				model.config(),
//				site,
//				Optional.<Executor>absent());
//		
//		System.out.println(result);
//		System.out.println(result.curves());
		
		String[] calcArgs = new String[] {
				modelPath.toString()
		};
		HazardCurve.main(calcArgs);
		
		
		
//		for (SourceSet<? extends Source> sourceSet : model) {
//			System.out.println(sourceSet);
//			
//			for (Source source : sourceSet) {
//				System.out.println(source.name());
//				
////				Function<Source, InputList> f = Transforms.sourceToInputs(site);
//			}
//		}
				
		
	}
			
}
