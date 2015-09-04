package org.nd4j.linalg.ops.reduceops.complex;

import org.nd4j.linalg.api.complex.IComplexNDArray;
import org.nd4j.linalg.api.complex.IComplexNumber;
import org.nd4j.linalg.factory.Nd4j;

/**
 * Sum over an ndarray
 *
 * @author Adam Gibson
 */
public class Sum extends BaseScalarOp {

    public Sum() {
        super(Nd4j.createDouble(0, 0));
    }

    @Override
    public IComplexNumber accumulate(IComplexNDArray arr, int i, IComplexNumber soFar) {
        IComplexNumber d = arr.getComplex(i);
        soFar.addi(d);
        return soFar;
    }
}
