def runCleanBuild(user) {
    def maven = docker.image("maven:3.3.3-jdk-8")

    stage 'clone project'

    echo "Cloning Project"
    git "https://github.com/${user}/sample-spring-cloud-svc-ci.git"

    stage 'Compile, Test and Package'
    maven.inside {
        sh './gradlew clean build'
    }
}

return this;
