package tw.edu.ntu.csie.libsvm;

import java.util.StringJoiner;

public class svm_problem implements java.io.Serializable
{
	public int l;
	public double[] y;
	public svm_node[][] x;

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
