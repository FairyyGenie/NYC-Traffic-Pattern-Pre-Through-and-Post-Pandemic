import java.io.IOException;
import org.apache.hadoop.io.IntWritable; import org.apache.hadoop.io.LongWritable; import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class FChangeMapper
extends Mapper<LongWritable, Text, Text, IntWritable> {
public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
String valuestr=value.toString();
String[] content=valuestr.split("!");
boolean stay=true;
int change3=0;
if (content.length<15){}
else{
    String station=content[0];
    String boro = content[1];
    String change=content[4];
    change = change.replace(",","");
    try { 

        change3=Integer.parseInt(change);
    } 
    catch(NumberFormatException e) { 
        stay= false;} 
        catch(NullPointerException e) {
        stay= false;
    }

    if (stay=true){context.write(new Text("The Biggest Changes in 2018-2019 in "+ boro), new IntWritable(change3));}
    } }
    }
