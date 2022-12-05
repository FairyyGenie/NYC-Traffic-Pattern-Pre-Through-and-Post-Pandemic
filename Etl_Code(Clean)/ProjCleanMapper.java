import java.io.IOException;
import org.apache.hadoop.io.IntWritable; import org.apache.hadoop.io.LongWritable; import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class ProjCleanMapper
extends Mapper<LongWritable, Text, Text, Text> {
public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
String valuestr=value.toString();
String[] content=valuestr.split("!");
if (content.length<15){}
else{
    context.write(new Text(valuestr), new Text(""));
}
}
}
