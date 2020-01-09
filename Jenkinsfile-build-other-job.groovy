pipeline {
  agent any
  
  stages {
    stage('trigger job') {
      steps {
        // please modify the job path
        build job: 'other-job', parameters:
          [string(name: 'name', value: 'rick'), booleanParam(name: 'DEBUG', value: true)]
      }
    }
  }
}
