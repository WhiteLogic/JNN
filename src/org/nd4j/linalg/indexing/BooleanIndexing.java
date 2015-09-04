package org.nd4j.linalg.indexing;

import com.google.common.base.Function;
import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.complex.IComplexNDArray;
import org.nd4j.linalg.api.complex.IComplexNumber;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.indexing.conditions.Condition;

/**
 * Boolean indexing
 * @author Adam Gibson
 */
public class BooleanIndexing {
    /**
     * And
     * @param n
     * @param cond
     * @return
     */
    public static boolean and(IComplexNDArray n,Condition cond) {
        boolean ret = true;
        IComplexNDArray linear = n.linearView();
        for(int i = 0; i < linear.length(); i++) {
            ret = ret && cond.apply(linear.getComplex(i));
        }

        return ret;
    }

    /**
     * Or over the whole ndarray given some condition
     * @param n
     * @param cond
     * @return
     */
    public static boolean or(IComplexNDArray n,Condition cond) {
        boolean ret = true;
        IComplexNDArray linear = n.linearView();
        for(int i = 0; i < linear.length(); i++) {
            ret = ret || cond.apply(linear.getComplex(i));
        }

        return ret;
    }


    /**
     * And over the whole ndarray given some condition
     * @param n
     * @param cond
     * @return
     */
    public static boolean and(INDArray n,Condition cond) {
        boolean ret = true;
        INDArray linear = n.linearView();
        for(int i = 0; i < linear.length(); i++) {
            ret = ret && cond.apply(linear.getFloat(i));
        }

        return ret;
    }

    /**
     * Or over the whole ndarray given some condition
     * @param n
     * @param cond
     * @return
     */
    public static boolean or(INDArray n,Condition cond) {
        boolean ret = true;
        INDArray linear = n.linearView();
        for(int i = 0; i < linear.length(); i++) {
            ret = ret || cond.apply(linear.getFloat(i));
        }

        return ret;
    }

    /**
     * Based on the matching elements
     * transform to based on condition to with function function
     * @param to the ndarray to transform
     * @param condition  the condition on transform
     * @param function the function to apply the transform to
     */
    public static void applyWhere(INDArray to,Condition condition,Function<Number,Number> function) {
        INDArray linear = to.linearView();
        for(int i = 0; i < linear.linearView().length(); i++) {
            if(linear.data().dataType().equals(DataBuffer.FLOAT)) {
                if (condition.apply(linear.getFloat(i))) {
                    linear.putScalar(i, function.apply(linear.getFloat(i)).floatValue());
                }
            }
            else  if(condition.apply(linear.getDouble(i)))
                linear.putScalar(i,function.apply(linear.getDouble(i)).doubleValue());


        }
    }


    /**
     * Based on the matching elements
     * transform to based on condition to with function function
     * @param to the ndarray to transform
     * @param condition  the condition on transform
     * @param function the function to apply the transform to
     */
    public static void applyWhere(IComplexNDArray to,Condition condition,Function<IComplexNumber,IComplexNumber> function) {
        IComplexNDArray linear = to.linearView();
        for(int i = 0; i < linear.linearView().length(); i++) {
            if(condition.apply(linear.getFloat(i))) {
                linear.putScalar(i,function.apply(linear.getComplex(i)));
            }
        }
    }



}
