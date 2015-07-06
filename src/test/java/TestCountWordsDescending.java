import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by petersoa on 7/6/15.
 */
public class TestCountWordsDescending {


    @Test
    public void ProcessValidWordCountMap() throws IOException, InterruptedException {
        Text value = new Text("it"+"\t"+ "200");

        new MapDriver<LongWritable, Text,IntWritable, Text>()
                .withMapper(new CountWordsDescendingMapper())
                .withInput(new LongWritable(0),value)
                .withOutput(new IntWritable(200),new Text("it"))
                .runTest();
    }

    @Test
    public void returnsCountforWord () throws IOException, InterruptedException {
        Text value = new Text("The The the");

        new ReduceDriver<IntWritable,Text,Text,IntWritable >()
                .withReducer(new CountWordsDescendingReducer())
                .withInput(new IntWritable(200), Arrays.asList(new Text("it")))
                .withOutput(new Text("it"), new IntWritable(200))
                .runTest();
    }


}
