/*
 *
 * Copyright (c) 2000-2014 Chih-Chung Chang and Chih-Jen Lin
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * 3. Neither name of copyright holders nor the names of its contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package tw.edu.ntu.csie.libsvm;

import java.lang.reflect.Field;

/**
 * Encapsulation of SVM parameter.
 *
 * @author Chih-Chung Chang and Chih-Jen Lin
 * @author Paul Wolfgang -- added comments.
 */
public class svm_parameter implements Cloneable, java.io.Serializable {

    /* svm_type */
    /**
     * C-SVM classification.
     */
    public static final int C_SVC = 0;
    /**
     * nu-SVM classification.
     */
    public static final int NU_SVC = 1;
    /**
     * one-class-SVM.
     */
    public static final int ONE_CLASS = 2;
    /**
     * epsilon-SVM regression.
     */
    public static final int EPSILON_SVR = 3;
    /**
     * nu-SVM regression.
     */
    public static final int NU_SVR = 4;

    /* kernel_type */
    /**
     * LINEAR:	u'*v
     */
    public static final int LINEAR = 0;
    /**
     * POLY:	(gamma*u'*v + coef0)^degree
     */
    public static final int POLY = 1;
    /**
     * RBF:	exp(-gamma*|u-v|^2)
     */
    public static final int RBF = 2;
    /**
     * SIGMOID:	tanh(gamma*u'*v + coef0)
     */
    public static final int SIGMOID = 3;
    /**
     * PRECOMPUTED: kernel values in training_set_file
     */
    public static final int PRECOMPUTED = 4;

    /**
     * svm_type can be one of C_SVC, NU_SVC, ONE_CLASS, EPSILON_SVR, NU_SVR.
     */
    public int svm_type;
    /**
     * kernel_type can be one of LINEAR, POLY, RBF, SIGMOID.
     */
    public int kernel_type;
    /**
     * For POLLY kernel type
     */
    public int degree;
    /**
     * for poly/rbf/sigmoid
     */
    public double gamma;
    /**
     * for poly/sigmoid
     */
    public double coef0;

    // these are for training only
    /**
     * cache_size is the size of the kernel cache, specified in megabytes.
     */
    public double cache_size;
    /**
     * eps is the stopping criterion. (we usually use 0.00001 in nu-SVC, 0.001
     * in others).
     */
    public double eps;
    /**
     * C is the cost of constraints violation. 
     */
    public double C;	// for C_SVC, EPSILON_SVR and NU_SVR
    /**
     * nr_weight, weight_label, and weight are used to change the penalty
     * for some classes. (If the weight for a class is not changed, it is
     * set to 1). This is useful for training classifier using unbalanced
     * input data or with asymmetric misclassification cost. nr_weight is 
     * the number of elements in the array weight_label and weight. If you do 
     * not want to change penalty for any of the classes, just set nr_weight to 0.
     */
    public int nr_weight;
    /**
     * Label of the class whose weight is changed.
     */
    public int[] weight_label;	// for C_SVC
    /**
     * Each weight[i] corresponds to weight_label[i]. Meaning that
     * the penalty of class weight_label[i] is scaled by a factor of weight[i].
     */
    public double[] weight;		// for C_SVC
    /**
     * nu is the parameter in nu-SVM, nu-SVR, and one-class-SVM.
     */
    public double nu;
    /**
     * p is the epsilon in epsilon-insensitive loss function of epsilon-SVM
     * regression.
     */
    public double p;
    /**
     * shrinking = 1 means shrinking is conducted; = 0 otherwise.
     */
    public int shrinking;
    /**
     * probability = 1 means model with probability information is obtained; = 0
     * otherwise.
     */
    public int probability; // do probability estimates

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        Class<?> myClass = this.getClass();
        Field[] fields = myClass.getDeclaredFields();
        StringBuilder stb = new StringBuilder();
        for (Field field : fields) {
            stb.append(field.getName());
            stb.append(" : ");
            try {
                stb.append(field.get(this));
            } catch (IllegalAccessException | IllegalArgumentException ex) {
            } //ignore
            stb.append("\n");
        }
        return stb.toString();
    }
}
