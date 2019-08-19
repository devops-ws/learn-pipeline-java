pipeline {
  agent any
  
  stages{
    stage('simple'){
      steps{
        input message: 'Please input your name!', ok: 'Confirm',
          parameters: [string(defaultValue: 'rick',
            description: 'This should not be your real name.', name: 'name', trim: true)]
      }
    }
    
    stage('complex'){
      parallel {
        stage('channel-1'){
          steps{
            input message: 'Please input your age!', ok: 'Confirm',
              parameters: [string(defaultValue: '18',
                description: 'Just a joke.', name: 'age', trim: true)]
          }
        }
        stage('channel-2'){
          steps{
            input message: 'Please input your weight!', ok: 'Confirm',
              parameters: [string(defaultValue: '50',
                description: 'Just a joke.', name: 'weight', trim: true)]
          }
        }
      }
    }
    
    stage('use result'){
      parallel {
        stage('one param'){
          steps{
            script{
              result = input message: 'Please input the git branch name!', ok: 'Confirm',
                parameters: [string(defaultValue: 'master',
                  description: 'The branch name of git repo', name: 'branchName', trim: true)]

              git branch: result, url: 'https://github.com/devops-workspace/demo-junit'
            }
          }
        }
        
        stage('multi-param'){
          steps{
            script{
              result = input message: 'Please input the git branch name with debug info!', ok: 'Confirm',
                parameters: [string(defaultValue: 'master',
                  description: 'The branch name of git repo', name: 'branchName', trim: true),
                  string(defaultValue: 'debug info',
                  description: 'Output the debug info', name: 'debugInfo', trim: true)]

              git branch: result.branchName, url: 'https://github.com/devops-workspace/demo-junit'
              echo result.debugInfo
            }
          }
        }
        
        stage('param-boolean'){
          steps{
            script{
              result = input message: 'Please input the git branch name with debug info!', ok: 'Confirm',
                parameters: [string(defaultValue: 'master',
                  description: 'The branch name of git repo', name: 'branchName', trim: true),
                  string(defaultValue: 'debug info',
                  description: 'Output the debug info', name: 'debugInfo', trim: true),
                  booleanParam(defaultValue: false, description: 'Run this Pipeline in debug mode.', name: 'debug')]

              git branch: result.branchName, url: 'https://github.com/devops-workspace/demo-junit'
              echo result.debugInfo
            }
          }
        }
        
      }
    }

  }
}
