/*
** Use below script if you have installed Maven through jenkins plugin **
*/

node {
   def mvnHome
   stage('Checkout') {
        // Get some code from a GitHub repository
        checkout([$class: 'GitSCM', branches: [[name: '*/develop']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/SreeniYC/WebGoat.git']]])
        
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.           
        mvnHome = tool 'M3'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' compile test package"
      } else {
         bat(/"${mvnHome}\bin\mvn" compile test package/)
      }
   }
   stage("Results"){
        //Display test results
        junit 'webgoat-container/target/surefire-reports/TEST*.xml'
        
        //Artifacts
        archiveArtifacts 'webgoat-container/target/webgoat-container-7.1-SNAPSHOT.war'
    }
}

//Get approval from user before deployment
input 'Ready to Deploy??'

node{
    stage("Deploy"){
    //Deploy Code here
    }
}
