package org.nd4j.linalg.ops.transforms;

import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.complex.IComplexNumber;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.BaseElementWiseOp;
import org.nd4j.linalg.util.ComplexUtil;

/**
 * Floor function
 * @author Adam Gibson
 */
public class Floor extends BaseElementWiseOp {
    /**
     * The transformation for a given value (a scalar ndarray)
     *
     * @param value the value to applyTransformToOrigin (a scalar ndarray)
     * @param i     the index of the element being acted upon
     * @return the transformed value based on the input
     */
    @Override
    public Object apply(INDArray from,Object value, int i) {
        if(value instanceof IComplexNumber) {
            IComplexNumber c = (IComplexNumber) value;
            return Nd4j.scalar(ComplexUtil.floor(c));
        }
        if(from.data().dataType().equals(DataBuffer.FLOAT)) {
            float val = (float) value;
            return (float) Math.floor(val);
        }

        double val = (double) value;
        return Math.floor(val);
    }
}
