该项目旨在提供一种轻松的方法来体验 Jenkins 流水线。

根据不同的使用场景，我们提供了一些 Jenkinsfile：

|文件|需求|描述|
|---|---|---|
|[Jenkinsfile-parameters.groovy](Jenkinsfile-parameters.groovy)|没有特别需要依赖的。|在 Jenkinsfile 中使用参数化流水线的例子。|
|[Jenkinsfile-junit-k8s](Jenkinsfile-junit-k8s)|需要有一个带 `maven` 标签的代理节点。这个节点必须是在一个包含 `java` 容器的 pod 中。|生成 junit 报告。|
|[Jenkinsfile-input](Jenkinsfile-input)|任何类型的节点。|需要用户输入，然后流水线才可以继续。|
|[Jenkinsfile.jmeter.groovy](Jenkinsfile.jmeter.groovy)|一个 kubernetes 环境|在 Jenkins 中运行 JMeter 测试|
|[Jenkinsfile-milestone.groovy](Jenkinsfile-milestone.groovy)|无|当有新的构建任务时，把已经运行的停止|

查看更多 https://jenkins-zh.cn/about/course/#1
