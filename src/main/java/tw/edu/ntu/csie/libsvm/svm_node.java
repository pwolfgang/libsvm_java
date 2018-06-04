package tw.edu.ntu.csie.libsvm;
public class svm_node implements java.io.Serializable
{
	public int index;
	public double value;

        @Override
        public String toString() {
            return String.format("%d:%f", index, value);
        }
}
