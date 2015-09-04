package org.nd4j.linalg.jblas.complex;

import org.nd4j.linalg.api.complex.IComplexDouble;
import org.nd4j.linalg.api.complex.IComplexFloat;
import org.nd4j.linalg.api.complex.IComplexNumber;
import org.nd4j.linalg.factory.Nd4j;

/**
 * Complex float
 * @author Adam Gibson
 */
public class ComplexFloat extends org.jblas.ComplexFloat implements IComplexFloat {


    public final static ComplexFloat UNIT = new ComplexFloat(1,0);
    public final static ComplexFloat NEG = new ComplexFloat(-1,0);
    public final static ComplexFloat ZERO = new ComplexFloat(0,0);

    public ComplexFloat(org.jblas.ComplexFloat c) {
        super(c.real(),c.imag());
    }

    public ComplexFloat(float real, float imag) {
        super(real, imag);
    }

    public ComplexFloat(float real) {
        super(real);
    }
    @Override
    public IComplexNumber eqc(IComplexNumber num) {
        double val = num.realComponent().doubleValue();
        double imag = num.imaginaryComponent().doubleValue();
        double otherVal = num.realComponent().doubleValue();
        double otherImag = num.imaginaryComponent().doubleValue();
        if(val == otherVal)
            return Nd4j.createComplexNumber(1,0);
        else if(val != otherVal)
            return Nd4j.createComplexNumber(0,0);
        else if(imag == otherImag)
            return Nd4j.createComplexNumber(1,0);
        else
            return Nd4j.createComplexNumber(0,0);
    }

    @Override
    public IComplexNumber neqc(IComplexNumber num) {
        double val = num.realComponent().doubleValue();
        double imag = num.imaginaryComponent().doubleValue();
        double otherVal = num.realComponent().doubleValue();
        double otherImag = num.imaginaryComponent().doubleValue();
        if(val != otherVal)
            return Nd4j.createComplexNumber(1,0);
        else if(val == otherVal)
            return Nd4j.createComplexNumber(0,0);
        else if(imag != otherImag)
            return Nd4j.createComplexNumber(1,0);
        else
            return Nd4j.createComplexNumber(0,0);
    }

    @Override
    public IComplexNumber gt(IComplexNumber num) {
        double val = num.realComponent().doubleValue();
        double imag = num.imaginaryComponent().doubleValue();
        double otherVal = num.realComponent().doubleValue();
        double otherImag = num.imaginaryComponent().doubleValue();
        if(val > otherVal)
            return Nd4j.createComplexNumber(1,0);
        else if(val < otherVal)
            return Nd4j.createComplexNumber(0,0);
        else if(imag > otherImag)
            return Nd4j.createComplexNumber(1,0);
        else
            return Nd4j.createComplexNumber(0,0);
    }

    @Override
    public IComplexNumber lt(IComplexNumber num) {
        double val = num.realComponent().doubleValue();
        double imag = num.imaginaryComponent().doubleValue();
        double otherVal = num.realComponent().doubleValue();
        double otherImag = num.imaginaryComponent().doubleValue();
        if(val < otherVal)
            return Nd4j.createComplexNumber(1,0);
        else if(val > otherVal)
            return Nd4j.createComplexNumber(0,0);
        else if(imag < otherImag)
            return Nd4j.createComplexNumber(1,0);
        else
            return Nd4j.createComplexNumber(0,0);
    }

    /**
     * Returns the argument of a complex number.
     */
    @Override
    public float arg() {
        return super.arg();
    }

    /**
     * Return the absolute value
     */
    @Override
    public float abs() {
        return super.abs();
    }

    /**
     * Convert to a double
     *
     * @return this complex number as a double
     */
    @Override
    public IComplexDouble asDouble() {
        return Nd4j.createDouble(realComponent(), imaginaryComponent());
    }

    /**
     * Convert to a float
     *
     * @return this complex number as a float
     */
    @Override
    public ComplexFloat asFloat() {
        return this;
    }

    @Override
    public ComplexFloat dup() {
        return new ComplexFloat(realComponent(), imaginaryComponent());
    }


    @Override
    public ComplexFloat conji() {
        super.set(realComponent(), -imaginaryComponent());
        return this;
    }

    @Override
    public ComplexFloat conj() {
        return dup().conji();
    }

    @Override
    public IComplexNumber set(Number real, Number imag) {
        super.set(real.floatValue(),imag.floatValue());
        return this;
    }

    @Override
    public IComplexNumber copy(IComplexNumber other) {

        return null;

    }

    /**
     * Add two complex numbers in-place
     *
     * @param c
     * @param result
     */
    @Override
    public IComplexNumber addi(IComplexNumber c, IComplexNumber result) {
        if (this == result) {
            set(real() + c.realComponent().floatValue(),imag() + result.imaginaryComponent().floatValue());
        } else {
            result.set(result.realComponent().floatValue() + c.realComponent().floatValue(),result.imaginaryComponent().floatValue() + c.imaginaryComponent().floatValue());

        }
        return this;
    }

    /**
     * Add two complex numbers in-place storing the result in this.
     *
     * @param c
     */
    @Override
    public IComplexNumber addi(IComplexNumber c) {
        return addi(c,this);
    }

    /**
     * Add two complex numbers.
     *
     * @param c
     */
    @Override
    public IComplexNumber add(IComplexNumber c) {
        return dup().addi(c);
    }

    /**
     * Add a realComponent number to a complex number in-place.
     *
     * @param a
     * @param result
     */
    @Override
    public IComplexNumber addi(Number a, IComplexNumber result) {
        if (this == result) {
            set(real() + a.floatValue(),imag() + a.floatValue());
        } else {
            result.set(result.realComponent().floatValue() + a.floatValue(),imaginaryComponent() + a.floatValue());

        }
        return result;
    }


    /**
     * Add a realComponent number to complex number in-place, storing the result in this.
     *
     * @param c
     */
    @Override
    public IComplexNumber addi(Number c) {
        return addi(c,this);
    }

    /**
     * Add a realComponent number to a complex number.
     *
     * @param c
     */
    @Override
    public IComplexNumber add(Number c) {
        return dup().addi(c);
    }

    /**
     * Subtract two complex numbers, in-place
     *
     * @param c
     * @param result
     */
    @Override
    public IComplexNumber subi(IComplexNumber c, IComplexNumber result) {
        if (this == result) {
            set(real() - c.realComponent().floatValue(),imag() - result.imaginaryComponent().floatValue());
        } else {
            result.set(result.realComponent().floatValue() - c.realComponent().floatValue(),result.imaginaryComponent().floatValue() - c.imaginaryComponent().floatValue());

        }
        return this;
    }

    @Override
    public IComplexNumber subi(IComplexNumber c) {
        return subi(c,this);
    }

    /**
     * Subtract two complex numbers
     *
     * @param c
     */
    @Override
    public IComplexNumber sub(IComplexNumber c) {
        return dup().subi(c);
    }

    @Override
    public IComplexNumber subi(Number a, IComplexNumber result) {
        if (this == result) {
            set(real() - a.floatValue(),imag() - a.floatValue());
        } else {
            result.set(result.realComponent().floatValue() - a.floatValue(),imaginaryComponent().floatValue() - a.floatValue());

        }
        return result;
    }

    @Override
    public IComplexNumber subi(Number a) {
        return subi(a,this);
    }

    @Override
    public IComplexNumber sub(Number r) {
        return dup().subi(r);
    }

    /**
     * Multiply two complex numbers, inplace
     *
     * @param c
     * @param result
     */
    @Override
    public IComplexNumber muli(IComplexNumber c, IComplexNumber result) {
        float newR = real() * c.realComponent().floatValue() - imag() * c.imaginaryComponent().floatValue();
        float newI = real() * c.imaginaryComponent().floatValue() + imag() * c.realComponent().floatValue();
        result.set(newR,newI);
        return result;
    }

    @Override
    public IComplexNumber muli(IComplexNumber c) {
        return muli(c,this);
    }

    /**
     * Multiply two complex numbers
     *
     * @param c
     */
    @Override
    public IComplexNumber mul(IComplexNumber c) {
        return dup().muli(c);
    }

    @Override
    public IComplexNumber mul(Number v) {
        return dup().muli(v);
    }

    @Override
    public IComplexNumber muli(Number v, IComplexNumber result) {
        if (this == result) {
            set(real() * v.floatValue(),imag() * v.floatValue());
        } else {
            result.set(result.realComponent().floatValue() * v.floatValue(),imaginaryComponent().floatValue() * v.floatValue());

        }
        return result;
    }

    @Override
    public IComplexNumber muli(Number v) {
        return muli(v,this);
    }

    /**
     * Divide two complex numbers
     *
     * @param c
     */
    @Override
    public IComplexNumber div(IComplexNumber c) {
        return dup().divi(c);
    }

    /**
     * Divide two complex numbers, in-place
     *
     * @param c
     * @param result
     */
    @Override
    public IComplexNumber divi(IComplexNumber c, IComplexNumber result) {
        float d = c.realComponent().floatValue() * c.realComponent().floatValue() + c.imaginaryComponent().floatValue() * c.imaginaryComponent().floatValue();
        float newR = (real() * c.realComponent().floatValue() + imag() * c.imaginaryComponent().floatValue()) / d;
        float newI = (imag() * c.realComponent().floatValue() - real() * c.imaginaryComponent().floatValue()) / d;
        result.set(newR,newI);
        return result;
    }

    @Override
    public IComplexNumber divi(IComplexNumber c) {
        return divi(c,this);
    }

    @Override
    public IComplexNumber divi(Number v, IComplexNumber result) {
        if (this == result) {
            set(real() / v.floatValue(),imag());
        } else {
            result.set(result.realComponent().floatValue() / v.floatValue(),imaginaryComponent());

        }
        return result;
    }

    @Override
    public IComplexNumber divi(Number v) {
        return divi(v,this);
    }

    @Override
    public IComplexNumber div(Number v) {
        return dup().divi(v);
    }

    @Override
    public boolean eq(IComplexNumber c) {
        return false;
    }

    @Override
    public boolean ne(IComplexNumber c) {
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public org.jblas.ComplexFloat set(float real, float imag) {
        return super.set(real, imag);
    }

    @Override
    public float real() {
        return super.real();
    }

    @Override
    public float imag() {
        return super.imag();
    }

    @Override
    public Float realComponent() {
        return super.real();
    }

    @Override
    public Float imaginaryComponent() {
        return super.imag();
    }

    @Override
    public org.jblas.ComplexFloat copy(org.jblas.ComplexFloat other) {
        return super.copy(other);
    }

    /**
     * Add two complex numbers in-place
     *
     * @param c
     * @param result
     */
    @Override
    public org.jblas.ComplexFloat addi(org.jblas.ComplexFloat c, org.jblas.ComplexFloat result) {
        return super.addi(c, result);
    }

    /**
     * Add two complex numbers in-place storing the result in this.
     *
     * @param c
     */
    @Override
    public org.jblas.ComplexFloat addi(org.jblas.ComplexFloat c) {
        return super.addi(c);
    }

    /**
     * Add two complex numbers.
     *
     * @param c
     */
    @Override
    public org.jblas.ComplexFloat add(org.jblas.ComplexFloat c) {
        return super.add(c);
    }

    /**
     * Add a realComponent number to a complex number in-place.
     *
     * @param a
     * @param result
     */
    @Override
    public org.jblas.ComplexFloat addi(float a, org.jblas.ComplexFloat result) {
        return super.addi(a, result);
    }

    /**
     * Add a realComponent number to complex number in-place, storing the result in this.
     *
     * @param c
     */
    @Override
    public org.jblas.ComplexFloat addi(float c) {
        return super.addi(c);
    }

    /**
     * Add a realComponent number to a complex number.
     *
     * @param c
     */
    @Override
    public org.jblas.ComplexFloat add(float c) {
        return super.add(c);
    }

    /**
     * Subtract two complex numbers, in-place
     *
     * @param c
     * @param result
     */
    @Override
    public org.jblas.ComplexFloat subi(org.jblas.ComplexFloat c, org.jblas.ComplexFloat result) {
        return super.subi(c, result);
    }

    @Override
    public org.jblas.ComplexFloat subi(org.jblas.ComplexFloat c) {
        return super.subi(c);
    }

    /**
     * Subtract two complex numbers
     *
     * @param c
     */
    @Override
    public org.jblas.ComplexFloat sub(org.jblas.ComplexFloat c) {
        return super.sub(c);
    }

    @Override
    public org.jblas.ComplexFloat subi(float a, org.jblas.ComplexFloat result) {
        return super.subi(a, result);
    }

    @Override
    public org.jblas.ComplexFloat subi(float a) {
        return super.subi(a);
    }

    @Override
    public org.jblas.ComplexFloat sub(float r) {
        return super.sub(r);
    }

    /**
     * Multiply two complex numbers, inplace
     *
     * @param c
     * @param result
     */
    @Override
    public org.jblas.ComplexFloat muli(org.jblas.ComplexFloat c, org.jblas.ComplexFloat result) {
        return super.muli(c, result);
    }

    @Override
    public org.jblas.ComplexFloat muli(org.jblas.ComplexFloat c) {
        return super.muli(c);
    }

    /**
     * Multiply two complex numbers
     *
     * @param c
     */
    @Override
    public org.jblas.ComplexFloat mul(org.jblas.ComplexFloat c) {
        return super.mul(c);
    }

    @Override
    public org.jblas.ComplexFloat mul(float v) {
        return super.mul(v);
    }

    @Override
    public org.jblas.ComplexFloat muli(float v, org.jblas.ComplexFloat result) {
        return super.muli(v, result);
    }

    @Override
    public org.jblas.ComplexFloat muli(float v) {
        return super.muli(v);
    }

    /**
     * Divide two complex numbers
     *
     * @param c
     */
    @Override
    public ComplexFloat div(org.jblas.ComplexFloat c) {
        return dup().divi(c);

    }

    /**
     * Divide two complex numbers, in-place
     *
     * @param c
     * @param result
     */
    @Override
    public org.jblas.ComplexFloat divi(org.jblas.ComplexFloat c, org.jblas.ComplexFloat result) {
        return super.divi(c, result);
    }

    @Override
    public ComplexFloat divi(org.jblas.ComplexFloat c) {
        super.divi(c);
        return this;
    }

    @Override
    public ComplexFloat divi(float v, org.jblas.ComplexFloat result) {
        super.divi(v, result);
        return this;
    }

    @Override
    public ComplexFloat divi(float v) {
        super.divi(v);
        return this;
    }

    @Override
    public ComplexFloat div(float v) {
        super.div(v);
        return this;
    }

    /**
     * Return the absolute value
     */
    @Override
    public Float absoluteValue() {
        return super.abs();
    }

    /**
     * Returns the argument of a complex number.
     */
    @Override
    public Float complexArgument() {
        return (float) Math.acos(realComponent()/ absoluteValue());
    }

    @Override
    public ComplexFloat invi() {
        float d = realComponent() * realComponent() + imaginaryComponent() * imaginaryComponent();
        set(realComponent() / d,-imaginaryComponent() / d);
        return this;
    }

    @Override
    public ComplexFloat inv() {
        return dup().invi();
    }

    @Override
    public ComplexFloat neg() {
        return dup().negi();
    }

    @Override
    public ComplexFloat negi() {
        set(-realComponent(),-imaginaryComponent());
        return this;
    }

    @Override
    public ComplexFloat sqrt() {
        float a = absoluteValue();
        float s2 = (float)Math.sqrt(2);
        float p = (float)Math.sqrt(a + realComponent())/s2;
        float q = (float)Math.sqrt(a - realComponent())/s2 * Math.signum(imaginaryComponent());
        return new ComplexFloat(p, q);
    }

    /**
     * Comparing two floatComplex values.
     *
     * @param o
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public boolean eq(org.jblas.ComplexFloat c) {
        return super.eq(c);
    }

    @Override
    public boolean ne(org.jblas.ComplexFloat c) {
        return super.ne(c);
    }

    @Override
    public boolean isZero() {
        return super.isZero();
    }

    @Override
    public boolean isReal() {
        return imaginaryComponent() == 0.0;
    }

    @Override
    public boolean isImag() {
        return realComponent() == 0.0;
    }
    
    
    
    
}
