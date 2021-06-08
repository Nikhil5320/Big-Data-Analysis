package temp_max;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import java.io.IOException;

public class max_reducer extends Reducer <Text, IntWritable,Text, IntWritable>
{
	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException,InterruptedException
	{
		int max_temp = 0;
		for (IntWritable value : values)
		{
			if(max_temp<value.get()) {
				max_temp = value.get();
			}
		}
		context.write(key, new IntWritable(max_temp));
	}
}