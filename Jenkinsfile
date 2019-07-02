pipeline {
  agent any 
  
  options {
  disableConcurrentBuilds()
}

  
  stages{
    stage('one'){
      steps{
        echo 'sdf'
        sleep 10
      }
    }
    
    stage('two'){
      when {
  allOf {
    branch 'master'
  }
}
      steps{
        echo 'sf'
      }
    }
  }
}
