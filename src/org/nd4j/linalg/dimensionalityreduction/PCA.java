package org.nd4j.linalg.dimensionalityreduction;

import org.nd4j.linalg.api.complex.IComplexNDArray;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.eigen.Eigen;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.indexing.NDArrayIndex;

/**
 *
 * PCA class for dimensionality reduction
 * @author Adam Gibson
 */
public class PCA {

    /**
     * Reduce the dimension of x
     * to the specified number of dimensions.
     *
     * Happily based on the great work done in the tsne paper here:
     * http://homepage.tudelft.nl/19j49/t-SNE.html
     *
     *
     * @param X the x to reduce
     * @param nDims the number of dimensions to reduce to
     * @param normalize normalize
     * @return the reduced dimension
     */
    public static INDArray pca(INDArray X,int nDims,boolean normalize) {
        if(normalize) {
            INDArray mean = X.mean(0);
            X = X.subiRowVector(mean);

        }

        INDArray C;
        if(X.size(1) < X.size(0))
            C = X.transpose().mmul(X);

        else
            C = X.mmul(X.transpose()).muli(1 / X.size(0));

        IComplexNDArray[] eigen = Eigen.eigenvectors(C);

        IComplexNDArray M = eigen[1];
        IComplexNDArray lambda = eigen[0];
        IComplexNDArray diagLambda = Nd4j.diag(lambda);
        INDArray[] sorted = Nd4j.sortWithIndices(diagLambda, 0, false);
        //change lambda to be the indexes
        lambda = Nd4j.createComplex(sorted[1]);

        INDArray indices =  sorted[0];

        NDArrayIndex[] indices2 = NDArrayIndex.create(indices.get(
                new NDArrayIndex[]{
                        NDArrayIndex.interval(0,nDims)
                }));

        NDArrayIndex[] rowsAndColumnIndices = new NDArrayIndex[]{
                NDArrayIndex.interval(0,M.rows()),indices2[0]
        };

        M = M.get(rowsAndColumnIndices);

        X = Nd4j.createComplex(X.subRowVector(X.mean(0))).mmul(M);


        return X;


    }


}
