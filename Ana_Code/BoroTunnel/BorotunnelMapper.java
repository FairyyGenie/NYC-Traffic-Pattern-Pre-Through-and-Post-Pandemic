import java.io.IOException;
import org.apache.hadoop.io.IntWritable; import org.apache.hadoop.io.LongWritable; import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class BorotunnelMapper
extends Mapper<LongWritable, Text, Text, IntWritable> {
public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
String valuestr=value.toString();
String[] content=valuestr.split(",");
float commuters;
if (content.length<5){}
else{
    String year=content[0];
    String boro = content[1];
    String tunnelcommute=content[3];
    commuters=Float.parseFloat(tunnelcommute);
    context.write(new Text("In "+ boro+" "+year+" , people using the tunnel:"), new IntWritable(Math.round(commuters)));
    } }
    }
