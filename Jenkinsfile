pipeline {
  agent any
  
  stages {
    stage('one') {
      steps {
        echo 'first stage'
        echo env.CHANGE_ID
      }
    }
    stage('two') {
      steps {
        sh 'echo test > log.txt'
        
        archiveArtifacts artifacts: 'log.txt', followSymlinks: false
      }
    }
    stage('three') {
      steps {
        sh 'echo test > three.txt'
        
        archiveArtifacts artifacts: 'three.txt', followSymlinks: false
      }
    }
  }
}
