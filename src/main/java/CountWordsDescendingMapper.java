import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by petersoa on 7/5/15.
 */
public class CountWordsDescendingMapper extends Mapper<LongWritable, Text,IntWritable, Text > {



    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String values[] = value.toString().split("\t");
        int count = Integer.parseInt(values[1]);
        String word = values[0];

        context.write(new IntWritable(count),new Text(word));
    }


}
