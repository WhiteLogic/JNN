package org.nd4j.linalg.api.dimensionfunctions;

import com.google.common.base.Function;
import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.reduceops.Ops;

/**
 * Dimension wise functions
 *
 * @author Adam Gibson
 */
public class DimensionFunctions {
    public static Function<INDArray,INDArray> normmax(final int dimension) {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return input.normmax(dimension);
            }
        };
    }
    public static Function<INDArray,INDArray> norm2(final int dimension) {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return input.norm2(dimension);
            }
        };
    }

    public static Function<INDArray,INDArray> norm1(final int dimension) {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return input.norm1(dimension);
            }
        };
    }


    public static Function<INDArray,INDArray> sum(final int dimension) {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {

                return input.sum(dimension);
            }
        };
    }

    public static Function<INDArray,INDArray> var(final int dimension) {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {

                return input.var(dimension);
            }
        };
    }

    public static Function<INDArray,INDArray> std(final int dimension) {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {

                return input.std(dimension);
            }
        };
    }

    public static Function<INDArray,INDArray> prod(final int dimension) {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return input.prod(dimension);
            }
        };
    }

    public static Function<INDArray,INDArray> cumsum(final int dimension) {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return input.cumsum(dimension);
            }
        };
    }


    public static Function<INDArray,INDArray> mean(final int dimension) {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return input.mean(dimension);
            }
        };
    }

    public static Function<INDArray,INDArray> min(final int dimension) {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return input.min(dimension);
            }
        };
    }

    public static Function<INDArray,INDArray> max(final int dimension) {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return input.max(dimension);
            }
        };
    }



    public static Function<INDArray,INDArray> norm2() {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return  Nd4j.scalar(Ops.norm2(input));
            }
        };
    }

    public static Function<INDArray,INDArray> norm1() {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return Nd4j.scalar(Ops.norm1(input));
            }
        };
    }


    public static Function<INDArray,INDArray> sum() {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return Nd4j.scalar(Ops.sum(input));
            }
        };
    }

    public static Function<INDArray,INDArray> var() {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {

                return  Nd4j.scalar(Ops.var(input));
            }
        };
    }

    public static Function<INDArray,INDArray> std() {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return Nd4j.scalar(Ops.std(input));
            }
        };
    }

    public static Function<INDArray,INDArray> prod() {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return Nd4j.scalar(Ops.prod(input));
            }
        };
    }

    public static Function<INDArray,INDArray> cumsum() {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                double s = 0.0;
                for (int i = 0; i < input.length(); i++) {
                    if(input.data().dataType().equals(DataBuffer.FLOAT))
                        s += input.getDouble(i);
                    else
                        s+= input.getDouble(i);
                    input.putScalar(i, s);
                }

                return input;
            }
        };
    }


    public static Function<INDArray,INDArray> mean() {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return Nd4j.scalar(Ops.mean(input));
            }
        };
    }

    public static Function<INDArray,INDArray> min() {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return Nd4j.scalar(Ops.min(input));
            }
        };
    }

    public static Function<INDArray,INDArray> max() {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return Nd4j.scalar(Ops.max(input));
            }
        };
    }

    public static Function<INDArray,INDArray> normmax() {
        return new Function<INDArray, INDArray>() {
            @Override
            public INDArray apply(INDArray input) {
                return Nd4j.scalar(Ops.normmax(input));
            }
        };
    }



}
