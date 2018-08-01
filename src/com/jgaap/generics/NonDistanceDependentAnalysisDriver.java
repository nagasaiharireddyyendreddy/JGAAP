package com.jgaap.generics;

/**
 * Class for analysis drivers that do not depend on a distance, but are dependent
 * on other non-distance analysis drivers.
 * 
 * @author David Berdik
 */
public abstract class NonDistanceDependentAnalysisDriver extends AnalysisDriver {
	public AnalysisDriver analysisDriver;
	
	public void setAnalysisDriver(AnalysisDriver analysisDriver) {
		// Even though LeaveOneOutNoDistance is an AnalysisDriver itself, it is dependent upon a second
		// AnalysisDriver to function.
		this.analysisDriver = analysisDriver;
	}
	
	public String getAnalysisDependencyName() {
		// Get the name of the analysis driver upon which this analysis driver is dependent.
		if(analysisDriver == null)
			return "";
		return " with " + analysisDriver.displayName();
	}
}
