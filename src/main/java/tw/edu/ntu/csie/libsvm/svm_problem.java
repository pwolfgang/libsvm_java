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

import java.util.StringJoiner;

/**
 * Encapsulation of an SVM problem.
 *
 * @author Chih-Chung Chang and Chih-Jen Lin
 * @author Paul Wolfgang -- added comments
 */
public class svm_problem implements java.io.Serializable {

    /**
     * The number of training data items.
     */
    public int l;

    /**
     * The target value for each item.
     */
    public double[] y;

    /**
     * The sparse representation of the training vector.
     */
    public svm_node[][] x;

    /**
     * Create a string representation of the problem.
     * The representation consists a line for each training item with the
     * y value first followed by each of the svm nodes.
     * @return String representation of the problem.
     */
    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < l; i++) {
            StringJoiner sj = new StringJoiner(" ");
            stb.append(y[i]).append(" ");
            for (int j = 0; j < x[i].length; j++) {
                sj.add(x[i][j].toString());
            }
            stb.append(sj).append("\n");
        }
        return stb.toString();
    }
}
