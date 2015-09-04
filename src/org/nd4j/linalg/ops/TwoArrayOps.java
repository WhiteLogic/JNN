package org.nd4j.linalg.ops;

import org.nd4j.linalg.api.ndarray.INDArray;

/**
 * Builder for two array (possibly plus scalar operations)
 *
 * @author Adam Gibson
 */
public class TwoArrayOps  {


    private INDArray from,to,other;
    private Object scalar;
    private Class<? extends BaseTwoArrayElementWiseOp> clazz;


    public TwoArrayOps op(Class<? extends BaseTwoArrayElementWiseOp> clazz) {
        this.clazz = clazz;
        return this;
    }


    public TwoArrayOps other(INDArray other) {

        this.other = other;
        return this;
    }

    public TwoArrayOps from(INDArray from) {

        this.from = from;
        return this;
    }

    public TwoArrayOps to(INDArray to) {

        this.to = to;
        return this;
    }

    public TwoArrayOps scalar(Object scalar) {
        if(scalar instanceof  Number) {
            Number n = (Number) scalar;
            this.scalar = n.floatValue();
        }
        else if(scalar instanceof INDArray) {
            INDArray a = (INDArray) scalar;
            if(!a.isScalar())
                throw new IllegalArgumentException("Only scalar nd arrays allowed");
            Number n = a.getFloat(0);
            this.scalar = n.floatValue();
        }

        else {
            throw new IllegalArgumentException("Illegal type passed in: Only ndarrays and scalars allowed");
        }


        return this;
    }


    public BaseTwoArrayElementWiseOp build() {
        try {
            BaseTwoArrayElementWiseOp op = clazz.newInstance();
            op.from = from;
            op.to = to;
            op.other = other;
            op.scalarValue = scalar;
            return op;
        }catch (Exception e) {
            throw new RuntimeException(e);

        }
    }


}
