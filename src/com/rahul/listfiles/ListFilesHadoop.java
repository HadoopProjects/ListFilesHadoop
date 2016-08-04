package com.rahul.listfiles;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

public class ListFilesHadoop {

	public static void main(String[] args) throws IOException {
		
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create("hdfs://localhost:54310/user/hadoop/"),conf);
		
		FileStatus[] stats = fs.listStatus(new Path("hdfs://localhost:54310/user/hadoop/"));
		Path[] paths = FileUtil.stat2Paths(stats);
		for(Path path: paths){
			System.out.println(path);
		}
		
	}

}
