package org.opensha2.TestCodes_KT;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executor;

import org.opensha2.calc.HazardResult;
import org.opensha2.calc.Site;
import org.opensha2.eq.model.HazardModel;
import org.opensha2.programs.HazardCurve;

import com.google.common.base.Optional;

public class TestHazCurve_InputFiles {

	public static void main (String args[]) throws IOException {	

		
// -----------------------------------------------------------------------------------------------
		// approach one: 
		
		//put the gmm.xml, source.xml, and config.json in a folder and give the directory info to Path
		// then use main method of HazardCurve class to do the calculations
		// the out put will be flushed into the result folder that is automatically generated 
		
		//Path modelPath = Paths.get("..","nshmp-haz","etc","peer","models","Set1-Case1"); 
		Path modelPath = Paths.get("..","gcim-dev","src","org","opensha2","gmm","FiniteFaultModel");	

		HazardModel model = HazardModel.load(modelPath);
		
		System.out.println(model);
		System.out.println(model.name());
		System.out.println(model.size());
		System.out.println(model.config());
		System.out.println(model.toString());

		String[] calcArgs = new String[] {
				modelPath.toString()
		};
		
		System.out.println("calcArgs[0]"+ calcArgs[0]);
//		System.out.println("calcArgs[1]"+ calcArgs[1]);
//		System.out.println("calcArgs[2]"+ calcArgs[2]);

		HazardCurve.main(calcArgs);
		
		
//// -----------------------------------------------------------------------------------------------
		// approach two: 
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
//// -----------------------------------------------------------------------------------------------
//		
		
			
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
