# BigDataExamples

##Apache Beam
###Java

Used Gitbash to run all below commands 

1. Command used to generate the maven project 
     $ mvn archetype:generate \
      -DarchetypeGroupId=org.apache.beam \
      -DarchetypeArtifactId=beam-sdks-java-maven-archetypes-examples \
      -DarchetypeVersion=2.36.0 \
      -DgroupId=org.example \
      -DartifactId=word-count-beam \
      -Dversion="0.1" \
      -Dpackage=org.apache.beam.examples \
      -DinteractiveMode=false
 
 2. Commands used for routing into directory
        $cd word-count-beam/

        $ ls
        pom.xml	src

        $ ls src/main/java/org/apache/beam/examples/
        DebuggingWordCount.java	WindowedWordCount.java	common
        MinimalWordCount.java	WordCount.java
  
  3. To run the maven project with created java file
        $ mvn compile exec:java -Dexec.mainClass=org.apache.beam.examples.WordCount \
     -Dexec.args="--inputFile=sample.txt --output=counts" -Pdirect-runner
  
  4. To view the output
        $ ls counts*
