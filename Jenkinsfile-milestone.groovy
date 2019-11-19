// inspired from https://stackoverflow.com/questions/40760716/jenkins-abort-running-build-if-new-one-is-started

def buildNumber = env.BUILD_NUMBER as int
if (buildNumber > 1) milestone(buildNumber - 1)
milestone(buildNumber)

sleep 20