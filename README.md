This project is aim to provide an easy way to try Jenkins pipeline.

According to different use cases, we provide several Jenkinsfile for you:

|File|Requirement|Description|
|---|---|---|
|[Jenkinsfile-junit-k8s](Jenkinsfile-junit-k8s)|It requires an agent which has a label `maven`. The agent should be a pod which contains a container named `java`.|Generate junit report.|
|[Jenkinsfile-input](Jenkinsfile-input)|Any types of agent.|Require a user to input something, then the Pipeline will keep going.|
|[Jenkinsfile.jmeter](Jenkinsfile.jmeter)|A kubernetes environment|Running a JMeter test in Jenkins|

See also https://jenkins-zh.cn/about/course/#1
