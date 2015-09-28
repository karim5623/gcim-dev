package org.opensha2.gmm;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.opensha2.eq.model.HazardModel;
import org.opensha2.programs.HazardCurve;

public class TestHazCurve_InputFiles {

	public static void main (String args[]) throws IOException {	

		//Path modelPath = Paths.get("..","nshmp-haz","etc","peer","models","Set1-Case1"); 
		Path modelPath = Paths.get("..","gcim-dev","src","org","opensha2","gmm","FiniteFaultModel");	

		HazardModel model = HazardModel.load(modelPath);
		System.out.println(model);

		String[] calcArgs = new String[] {
				modelPath.toString()
		};
		HazardCurve.main(calcArgs);
		
		
		
// -----------------------------------------------------------------------------------------------
//		// if u want to set the site here, u can use the following codes 
//		double siteLat = 38.0, siteLon = -122.0, siteDepth = 0.0, siteVs30 = 250, depth1p0=0.2, depth2p5=0.6;
//		String siteName = "Test Site";
//		
//		Site site = Site.builder()
//				.name(siteName)
//				.location(siteLat,siteLon)
//				.vs30(siteVs30)
//				.vsInferred(true)
//				.z1p0(depth1p0)
//				.z2p5(depth2p5)
//				.build();
//		System.out.println(site);			
//		HazardResult result = HazardCurve.calc(
//				model, 
//				model.config(),
//				site,
//				Optional.<Executor>absent());
//		
//		System.out.println(result);
//		System.out.println(result.curves());	
// -----------------------------------------------------------------------------------------------
		
		
		
		
		
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
