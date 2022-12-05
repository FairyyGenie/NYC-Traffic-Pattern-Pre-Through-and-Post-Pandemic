import java.io.IOException;
import org.apache.hadoop.io.IntWritable; import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable; import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class ChangePMapper
extends Mapper<LongWritable, Text, Text, FloatWritable> {
public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
String valuestr=value.toString();
String[] content=valuestr.split(",");
float Tcommuters;
float Scommuters;
if (content.length<5){}
else{
    String year=content[0];
    String boro = content[1];
    String tunnelcommute=content[3];
    String subwaycommute=content[2];
    String boo=content[4];
    Tcommuters=Float.parseFloat(tunnelcommute);
    Scommuters=Float.parseFloat(subwaycommute);
    if (boo.length()==2)
    {context.write(new Text("In "+ boro+" "+year+" weekends, correlation between subway commute and tunnel commute:"), new FloatWritable(Scommuters/Tcommuters));}
    else if (boo.length()==3){
            {context.write(new Text("In "+ boro+" "+year+" weekdays, correlation between subway commute and tunnel commute:"), new FloatWritable(Scommuters/Tcommuters));}

    }
    } }
    }
