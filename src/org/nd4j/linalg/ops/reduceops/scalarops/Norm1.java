package org.nd4j.linalg.ops.reduceops.scalarops;

import org.nd4j.linalg.api.ndarray.INDArray;

/**
 *
 * Overall norm1 of an ndarray
 *
 * @author Adam Gibson
 */
public class Norm1 extends BaseScalarOp {
    public Norm1() {
        super(0);
    }

    @Override
    public double accumulate(INDArray arr, int i, double soFar) {
        return soFar + Math.abs(arr.getFloat(i));
    }
}
