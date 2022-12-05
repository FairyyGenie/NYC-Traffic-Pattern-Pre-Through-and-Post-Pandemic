import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat; 
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class ProjClean {
public static void main(String[] args) throws Exception  {
Job job = new Job(); 
job.setJarByClass(ProjClean.class); 
job.setJobName("Clean");
job.setNumReduceTasks(1); 
FileInputFormat.addInputPath(job, new Path(args[0])); FileOutputFormat.setOutputPath(job, new Path(args[1]));
    job.setMapperClass(ProjCleanMapper.class);
    //job.setReducerClass(CleanReducer.class);
     job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
         System.exit(job.waitForCompletion(true) ? 0 : 1); 
            }
            }
    
