node{
    stage("Checkout"){
        // Checkout the source code
        checkout([$class: 'GitSCM', branches: [[name: '*/develop']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/SreeniYC/WebGoat.git']]])
    }
    
   stage('Build') {
        // Run the maven build
        if (isUnix()) {
            sh "mvn compile test package"
        } else {
            bat "mvn compile test package"
        }
    }
    
    stage("Results"){
        //Display test results
        junit 'webgoat-container/target/surefire-reports/TEST*.xml'
        
        //Artifacts
        archiveArtifacts 'webgoat-container/target/webgoat-container-7.1-SNAPSHOT.war'
    }
}

input 'Ready to Deploy??'

node{
    //Deploy Code here
}
