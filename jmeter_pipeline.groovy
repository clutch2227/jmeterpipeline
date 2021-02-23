pipeline {
   agent any
   stages {
    stage('Checkout') {
      steps {
        script {
           sh "rm -rf jmeter"
           sh "mkdir jmeter"
           sh "cd jmeter"
           // The below will clone your repo and will be checked out to master branch by default.
           git credentialsId: 'Git', url: 'https://github.com/clutch2227/JMeter.git'
           // Do a ls -lart to view all the files are cloned. It will be clonned. This is just for you to be sure about it.
           sh "ls -lart ./*" 
           // List all branches in your repo. 
           sh "git branch -a"
           // Checkout to a specific branch in your repo.
           sh "git checkout main"
          }
       }
    }
    stage('Install JMeter') {
      steps {
        script {
            sh "cd jmeter"
            def response = sh 'curl http://mirror.cc.columbia.edu/pub/sof...​ -o apache-jmeter-5.3.tgz'
            echo '=========================Response===================' + response
           }
        }
        }
    }    
}