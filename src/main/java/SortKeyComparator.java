import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * Created by petersoa on 7/6/15.
 */
public class SortKeyComparator extends WritableComparator{

    protected SortKeyComparator() {
        super(IntWritable.class, true);
    }

    /**
     * Compares in the descending order of the keys.
     */
    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        IntWritable o1 = (IntWritable) a;
        IntWritable o2 = (IntWritable) b;
        if(o1.get() < o2.get()) {
            return 1;
        }else if(o1.get() > o2.get()) {
            return -1;
        }else {
            return 0;
        }
    }


}
