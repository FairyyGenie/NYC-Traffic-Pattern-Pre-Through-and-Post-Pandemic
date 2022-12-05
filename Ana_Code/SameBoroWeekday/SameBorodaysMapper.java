import java.io.IOException;
import org.apache.hadoop.io.IntWritable; import org.apache.hadoop.io.LongWritable; import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class SameBorodaysMapper
extends Mapper<LongWritable, Text, Text, IntWritable> {
public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
String valuestr=value.toString();
String[] content=valuestr.split(",");
float commuters;
if (content.length<5){}
else{
    String year=content[0];
    String boro = content[1];
    String subwaycommute=content[2];
    String bool=content[4];
    commuters=Float.parseFloat(subwaycommute);
    if (bool=="no"){
        context.write(new Text("In "+ boro+" "+year+" during weekends, people riding the subway:"), new IntWritable(Math.round(commuters)));
    }
    else{
        context.write(new Text("In "+ boro+" "+year+" during weekdays, people riding the subway:"), new IntWritable(Math.round(commuters)));

    }
    } }
    }
