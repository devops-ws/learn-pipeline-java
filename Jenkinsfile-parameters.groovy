pipeline {
  agent any
  
  parameters {
    string defaultValue: 'rick', description: 'just for testing', name: 'name', trim: true
    booleanParam defaultValue: false, description: 'You can use this flag to debug your Pipeline', name: 'debug'
  }

  stages{
    stage('simple'){
      steps{
        echo "My name is $name."

        if $debug {
          echo "You can put some debug info at here."
        }
      }
    }

    stage('debug stage') {
      when {
        equals expected: true, actual: $debug
      }
      steps {
        echo "It's joke, there're debug info here."
      }
    }
  }
}
