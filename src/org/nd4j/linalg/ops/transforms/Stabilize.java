package org.nd4j.linalg.ops.transforms;

import org.apache.commons.math3.util.FastMath;
import org.nd4j.linalg.api.complex.IComplexNumber;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.BaseElementWiseOp;

/**
 * Ensures numerical stability.
 * Clips values of input such that
 * exp(k * in) is within single numerical precision
 *
 * @author Adam Gibson
 */
public class Stabilize extends BaseElementWiseOp {
    private double k = 1;

    public Stabilize(Double k) {
        this.k = k;
    }

    public Stabilize(Float k) {
        this.k = k;
    }

    public Stabilize(float k) {
        this.k = k;
    }
    public Stabilize() {
    }

    /**
     * The transformation for a given value (a scalar ndarray)
     *
     * @param value the value to applyTransformToOrigin (a scalar ndarray)
     * @param i     the index of the element being acted upon
     * @return the transformed value based on the input
     */
    @Override
    public Object apply(INDArray from,Object value, int i) {
        float realMin =  1.1755e-38f;
        float cutOff = (float) FastMath.log(realMin);
        if(value instanceof IComplexNumber) {
            IComplexNumber c = (IComplexNumber) value;
            float curr = c.realComponent().floatValue();
            if(curr * k > -cutOff)
                return Nd4j.createDouble(-cutOff / k, c.imaginaryComponent().floatValue());
            else if(curr * k < cutOff)
                return Nd4j.createDouble(cutOff / k, c.imaginaryComponent().floatValue());


        }
        else {
            double curr =  (double) value;
            if(curr * k > -cutOff)
                return  -cutOff / k;
            else if(curr * k < cutOff)
                return  cutOff / k;

        }



        return  value;
    }
}
