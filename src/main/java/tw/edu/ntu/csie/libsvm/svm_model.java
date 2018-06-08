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

/**
 * Encapsulation of an SVM model.
 *
 * @author Chih-Chung Chang and Chih-Jen Lin
 * @author Paul Wolfgang -- added comments.
 */
public class svm_model implements java.io.Serializable {

    /**
     * parameter
     */
    public svm_parameter param;

    /**
     * number of classes, = 2 in regression/one class svm.
     */
    public int nr_class;

    /**
     * total #SV
     */
    public int l;

    /**
     * SVs (SV[l])
     */
    public svm_node[][] SV;

    /**
     * coefficients for SVs in decision functions (sv_coef[k-1][l]).
     */
    public double[][] sv_coef;

    /**
     * constants in decision functions (rho[k*(k-1)/2]).
     */
    public double[] rho;

    /**
     * pariwise probability information A.
     */
    public double[] probA;

    /**
     * pariwise probability information B.
     */
    public double[] probB;

    /**
     * sv_indices[0,...,nSV-1] are values in [1,...,num_traning_data] to
     * indicate SVs in the training set.
     */
    public int[] sv_indices;

    // for classification only
    /**
     * label of each class (label[k]).
     */
    public int[] label;

    /**
     * number of SVs for each class (nSV[k]) nSV[0] + nSV[1] + ... + nSV[k-1] =
     * l
     */
    public int[] nSV;

};
