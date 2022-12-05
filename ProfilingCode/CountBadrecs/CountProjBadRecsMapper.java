import java.io.IOException;
import org.apache.hadoop.io.IntWritable; import org.apache.hadoop.io.LongWritable; import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class CountProjBadRecsMapper
extends Mapper<LongWritable, Text, Text, IntWritable> {
public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
String write="BadRecords";
int count=1;
String valuestr=value.toString();
String[] content=valuestr.split("!");
if (content.length!=15){context.write(new Text(write), new IntWritable(count));}
 }
}
