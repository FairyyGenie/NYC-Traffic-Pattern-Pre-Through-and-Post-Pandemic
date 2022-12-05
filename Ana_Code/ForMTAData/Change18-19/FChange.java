import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat; 
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class FChange{
public static void main(String[] args) throws Exception  {
Job job = new Job(); 
job.setJarByClass(FChange.class); 
job.setJobName("Rate");
job.setNumReduceTasks(1); 
FileInputFormat.addInputPath(job, new Path(args[0])); FileOutputFormat.setOutputPath(job, new Path(args[1]));
    job.setMapperClass(FChangeMapper.class);
    job.setReducerClass(FChangeReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
System.exit(job.waitForCompletion(true) ? 0 : 1); 
}
}
