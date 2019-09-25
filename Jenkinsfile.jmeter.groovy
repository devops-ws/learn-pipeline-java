// this case requires docker image egaillardon/jmeter
// you should run this pipeline under the kubernetes, and a container named jmeter is required
// In order to execute this successfuly, please install plugins using below command
// jcli plugin install kubernetes htmlpublisher pipeline-restful-api
pipeline{
    agent{
        label 'jmeter'
    }
    
    stages{
        stage('test'){
            steps{
                script{
                    container('jmeter'){
                        sh 'rm -rf result && rm -rf result.jtl && jmeter -n -t src/test/resources/baidu-jmeter.jmx -l result.jtl -e -o result'

                        // below is an example for sending test report to a generic artifact server
                        // see more details from https://github.com/mayth/go-simple-upload-server/pull/14
                        // sh 'curl http://10.0.129.98:12345'
                        // def files = findFiles glob: 'result/**/*'
                        // for(file in files) {
                        //     def path = file.path.replaceAll('result/', '').replaceAll(file.name, '')
                        //     path = currentBuild.fullProjectName + '/' + currentBuild.number + '/' + path
                        //     sh 'curl  -Ffile=@' + file.path + ' "http://10.0.129.98:12345/upload?token=testtoken&path=' + path + '"'
                        // }

                        // echo 'http://10.0.129.98:12345/' + currentBuild.fullProjectName + '/' + currentBuild.number + '/index.html'
                    }
                }
            }
        }
        
        stage('report'){
            steps{
                script{
                    container('jmeter'){
                        publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'result', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])
                    }
                }
            }
        }

        stage('artifacts') {
            steps {
                container('jmeter') {
                    sh 'tar czf result.tar.gz result'
                    archiveArtifacts 'result.tar.gz'
                }
            }
        }
    }
}
