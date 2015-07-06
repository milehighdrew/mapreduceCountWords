import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


/**
 * Created by petersoa on 7/5/15.
 */
public class CountWordsDescendingReducer  extends Reducer<IntWritable,Text,Text,IntWritable > {


    @Override
    public void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        for(Text value: values) {
            context.write(new Text(value),key);
        }

    }


    }
