pipeline {
   agent any
   stages {
    stage('Download JMeter & Plugins') {
      steps {
        script {
           // The below will clone your repo and will be checked out to master branch by default.
           sh "curl https://mirrors.ocf.berkeley.edu/apache//jmeter/binaries/apache-jmeter-5.4.1.tgz"
           sh "tar -xvzf apache-jmeter-5.4.1/bin"
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
            sh "./jmeter.sh -n -t test_scripts/Sample_Test.jmx -l test_result.csv"
            perfReport 'test_result.csv'
          }
       }
       step([$class: 'ArtifactArchiver', artifacts: '**/test_result.csv'])
      }
}
}
}
