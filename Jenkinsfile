pipeline {
   agent { label 'aws-task'}
   stages {
    stage('Code Checkout') {
      steps {
        script {
           // The below will clone your repo and will be checked out to master branch by default.
           git credentialsId: 'Git', url: 'https://github.com/clutch2227/JMeter.git'
           // Checkout to a specific branch in your repo.
           sh "git checkout master"
          }
       }
    }
    stage('JMeter Performance Test') {
      steps {
       dir('/var/jenkins_home/workspace/Jmeter/bin'){
        script {
            sh "echo jmeter.save.saveservice.output_format=xml >> user.properties"
            //sh "cat user.properties"
            sh "./jmeter.sh -n -t test_scripts/Sample_Test.jmx -l test_result.jtl"
            perfReport 'test_result.jtl'
          }
       }
       step([$class: 'ArtifactArchiver', artifacts: '**/test_result.jtl'])
      }
}
}
}
