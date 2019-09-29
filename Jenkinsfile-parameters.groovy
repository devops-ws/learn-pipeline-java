pipeline {
  agent any
  
  parameters {
    string defaultValue: 'rick', description: 'just for testing', name: 'name', trim: true
    booleanParam defaultValue: false, description: 'You can use this flag to debug your Pipeline', name: 'debug'
  }

  stages{
    stage('simple'){
      steps{
        echo "My name is ${params.name}."

        script {
          if ("${params.debug}" == "true") {
            echo "You can put some debug info at here."
            echo "Another way to use param: " + params.name
          }
        }
      }
    }

    stage('debug stage') {
      when {
        equals expected: true, actual: params.debug
      }
      steps {
        echo "It's joke, there're debug info here."
      }
    }
  }
}
