import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class TestCountWords {

    @Test
    public void processesValidWord() throws IOException, InterruptedException {
        Text value = new Text("the");

        new MapDriver<LongWritable, Text, Text, IntWritable>()
                .withMapper(new CountWordsMapper())
                .withInput(new LongWritable(0),value)
                .withOutput(new Text("the"), new IntWritable(1))
                .runTest();
    }

    @Test
    public void removePunctuationFromWord() throws IOException, InterruptedException {
        Text value = new Text("The?");

        new MapDriver<LongWritable, Text, Text, IntWritable>()
                .withMapper(new CountWordsMapper())
                .withInput(new LongWritable(0), value)
                .withOutput(new Text("the"), new IntWritable(1))
                .runTest();
    }

    @Test
    public void removeCaseFromWord() throws IOException, InterruptedException {
        Text value = new Text("The");

        new MapDriver<LongWritable, Text, Text, IntWritable>()
                .withMapper(new CountWordsMapper())
                .withInput(new LongWritable(0),value)
                .withOutput(new Text("the"), new IntWritable(1))
                .runTest();
    }

    @Test
    public void removeDigitFromWord() throws IOException, InterruptedException {
        Text value = new Text("The1987");

        new MapDriver<LongWritable, Text, Text, IntWritable>()
                .withMapper(new CountWordsMapper())
                .withInput(new LongWritable(0),value)
                .withOutput(new Text("the"), new IntWritable(1))
                .runTest();
    }

    @Test
    public void removeUnderScoreFromWord() throws IOException, InterruptedException {
        Text value = new Text("The_");

        new MapDriver<LongWritable, Text, Text, IntWritable>()
                .withMapper(new CountWordsMapper())
                .withInput(new LongWritable(0), value)
                .withOutput(new Text("the"), new IntWritable(1))
                .runTest();
    }


    @Test
    public void returnsCountforWord () throws IOException, InterruptedException {
        Text value = new Text("The The the");

        new ReduceDriver<Text, IntWritable, Text, IntWritable>()
                .withReducer(new CountWordsReducer())
                .withInput(new Text("the"),
                        Arrays.asList(new IntWritable(1), new IntWritable(1), new IntWritable(1)))
                .withOutput(new Text("the"), new IntWritable(3))
                .runTest();
    }

}