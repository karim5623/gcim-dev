package org.opensha2.gmm;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;

import org.opensha2.calc.InputList;
import org.opensha2.calc.Site;
import org.opensha2.eq.model.HazardModel;
import org.opensha2.eq.model.Source;
import org.opensha2.eq.model.SourceSet;
import org.opensha2.gmm.Gmm;
import org.opensha2.gmm.GmmInput;
import org.opensha2.programs.HazardCurve;

public class TestGmm {

	public static void main (String args[]) throws IOException {
		
		double siteLat = 34.053, siteLon = -118.243, siteDepth = 0.0, siteVs30 = 250, depth1p0=0.2; String siteName = "LosAngeles";
		
		Site site = Site.builder()
				.location(siteLat,siteLon)
				.vs30(siteVs30)
				.z1p0(depth1p0)
				.build();
		
		//Imt imt = new Imt.PGA;
		//GroundMotionModel gmm = Gmm.CY_08.instance(Imt.PGA)
		GmmInput gmmInput = GmmInput.builder()
				.withDefaults()
				.mag(7.5)
				.z1p0(depth1p0)
				.build();
		System.out.println(gmmInput);	
		
//		Logging.init();
		
		Path modelPath = Paths.get("..","nshmp-haz","etc","peer","models","Set1-Case1"); // add more as needed	
		
		Path test = Paths.get("etc");
		System.out.println(test.toRealPath());
		
//		Path modelPath = Paths.get("etc","peer","models","Set1-Case1"); // add more as needed	

		HazardModel model = HazardModel.load(modelPath);
		System.out.println(model);
//		for (SourceSet<? extends Source> sourceSet : model) {
//			System.out.println(sourceSet);
//			
//			for (Source source : sourceSet) {
//				System.out.println(source.name());
//				
////				Function<Source, InputList> f = Transforms.sourceToInputs(site);
//			}
//		}
		
//		HazardResult result = HazardCurve.calc(model, config, site, executor);
	}
			
}
