package org.nd4j.linalg.ops.reduceops.complex;

import org.nd4j.linalg.api.complex.IComplexNDArray;
import org.nd4j.linalg.api.complex.IComplexNumber;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.util.ArrayUtil;

/**
 * Return the overall standard deviation of an ndarray
 *
 * @author Adam Gibson
 */
public class StandardDeviation extends BaseScalarOp {
    public StandardDeviation() {
        super(Nd4j.createDouble(0, 0));
    }

    public IComplexNumber std(IComplexNDArray arr) {
        org.apache.commons.math3.stat.descriptive.moment.StandardDeviation dev = new org.apache.commons.math3.stat.descriptive.moment.StandardDeviation();
        double std = dev.evaluate(arr.ravel().data().asDouble());
        return Nd4j.createDouble(std, 0);
    }


    @Override
    public IComplexNumber apply(IComplexNDArray input) {
        return std(input);
    }

    @Override
    public IComplexNumber accumulate(IComplexNDArray arr, int i, IComplexNumber soFar) {
        return Nd4j.createDouble(0, 0);
    }
}
