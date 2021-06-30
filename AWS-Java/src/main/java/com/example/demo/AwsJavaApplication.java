package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.InstanceType;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.amazonaws.services.ec2.model.Tag;
import com.amazonaws.services.ec2.model.CreateSecurityGroupRequest;
import com.amazonaws.services.ec2.model.CreateSecurityGroupResult;
import com.amazonaws.services.ec2.model.CreateTagsRequest;
import com.amazonaws.services.ec2.model.CreateTagsResult;

//This is a simple demo for using Java to create an aws instance
@SpringBootApplication
public class AwsJavaApplication {

	public static void main(String[] args) {
		final AWSCredentials credentials = new BasicAWSCredentials(
				  "Access key ID", 
				  "Secret access key"
				);


		final AmazonEC2 ec2 = AmazonEC2ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.US_EAST_2)
				.build();;

		CreateSecurityGroupRequest createSecurityGroupRequest = new CreateSecurityGroupRequest()
				.withGroupName("AWS_Java_Qi")
				.withDescription("Java manipulate AWS");
		
		CreateSecurityGroupResult createSecurityGroupResult = ec2.createSecurityGroup(
				  createSecurityGroupRequest);
		
		RunInstancesRequest run_request = new RunInstancesRequest()
	            .withImageId("ami-0277b52859bac6f4b")
	            .withInstanceType(InstanceType.T2Micro)
	            .withSecurityGroups("AWS_Java_Qi")
	            .withMaxCount(1)
	            .withMinCount(1)
	            .withKeyName("GAOQI");
		
		RunInstancesResult run_response = ec2.runInstances(run_request);

        String instance_id = run_response.getReservation().getInstances().get(0).getInstanceId();

        Tag tag = new Tag()
            .withKey("Name")
            .withValue("Java_AWS");

        CreateTagsRequest tag_request = new CreateTagsRequest()
            .withResources(instance_id)
            .withTags(tag);

        CreateTagsResult tag_response = ec2.createTags(tag_request);
        
        System.out.printf(
                "Successfully started EC2 instance %s", instance_id);
		SpringApplication.run(AwsJavaApplication.class, args);
	}

}
