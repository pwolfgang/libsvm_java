package tw.edu.ntu.csie.libsvm;

import java.lang.reflect.Field;

public class svm_parameter implements Cloneable,java.io.Serializable
{
	/* svm_type */
	public static final int C_SVC = 0;
	public static final int NU_SVC = 1;
	public static final int ONE_CLASS = 2;
	public static final int EPSILON_SVR = 3;
	public static final int NU_SVR = 4;

	/* kernel_type */
	public static final int LINEAR = 0;
	public static final int POLY = 1;
	public static final int RBF = 2;
	public static final int SIGMOID = 3;
	public static final int PRECOMPUTED = 4;

	public int svm_type;
	public int kernel_type;
	public int degree;	// for poly
	public double gamma;	// for poly/rbf/sigmoid
	public double coef0;	// for poly/sigmoid

	// these are for training only
	public double cache_size; // in MB
	public double eps;	// stopping criteria
	public double C;	// for C_SVC, EPSILON_SVR and NU_SVR
	public int nr_weight;		// for C_SVC
	public int[] weight_label;	// for C_SVC
	public double[] weight;		// for C_SVC
	public double nu;	// for NU_SVC, ONE_CLASS, and NU_SVR
	public double p;	// for EPSILON_SVR
	public int shrinking;	// use the shrinking heuristics
	public int probability; // do probability estimates

	public Object clone() 
	{
		try 
		{
			return super.clone();
		} catch (CloneNotSupportedException e) 
		{
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
                } catch (IllegalAccessException | IllegalArgumentException ex) {} //ignore
                stb.append("\n");
            }
            return stb.toString();
        }
}
