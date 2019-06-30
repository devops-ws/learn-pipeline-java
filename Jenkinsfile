pipeline {
  agent any 
  
  stages{
    stage('one'){
      steps{
        echo 'sdf'
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
