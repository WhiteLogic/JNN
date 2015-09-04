package org.nd4j.linalg.solvers.api;


/**
 * Optimizer that handles optimizing parameters. Handles line search
 * and all the components involved with early stopping
 */
public interface OptimizerMatrix {

    /**
     * Run optimize
     * @return whether the algorithm converged properly
     */
	public boolean optimize();

    /**
     * Run optimize up to the specified number of epochs
     * @param numIterations the max number of epochs to run
     * @return whether the algorihtm converged properly
     */
	public boolean optimize(int numIterations);

    /**
     * Whether the algorithm is converged
     * @return true if the algorithm converged, false otherwise
     */
    public boolean isConverged();

    /**
     * The default max number of iterations to run
     * @param maxIterations
     */
	void setMaxIterations(int maxIterations);

    /**
     * The tolerance for change when running
     * @param tolerance
     */
    void setTolerance(double tolerance);




}
