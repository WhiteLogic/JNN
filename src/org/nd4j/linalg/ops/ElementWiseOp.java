package org.nd4j.linalg.ops;


import org.nd4j.linalg.api.ndarray.INDArray;

/**
 * An element wise operation over an ndarray.
 *
 *
 *
 * @author Adam Gibson
 */
public interface ElementWiseOp {



    /**
     * The input matrix
     * @return
     */
    public INDArray from();


    /**
     * Apply the transformation at from[i]
     * @param origin the origin ndarray
     * @param i the index of the element to applyTransformToOrigin
     */
    void applyTransformToOrigin(INDArray origin,int i);


    /**
     * Apply the transformation at from[i] using the supplied value (a scalar ndarray)
     * @param origin the origin ndarray
     * @param i the index of the element to applyTransformToOrigin
     * @param valueToApply the value to apply to the given index
     */
    void applyTransformToOrigin(INDArray origin,int i, Object valueToApply);

    /**
     * Get the element at from
     * at index i
     * @param origin the origin ndarray
     * @param i the index of the element to retrieve
     * @return the element at index i
     */
    <E> E getFromOrigin(INDArray origin,int i);

    /**
     * The transformation for a given value (a scalar)
     * @param origin the origin ndarray
      * @param value the value to apply (a scalar)
     *  @param i the index of the element being acted upon
     * @return the transformed value based on the input
     */

    <E> E apply(INDArray origin,Object value, int i);

    /**
     * Apply the transformation
     */
    void exec();


}
