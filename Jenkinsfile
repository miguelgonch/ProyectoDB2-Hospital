pipeline {
    agent any
    stages {         
        stage('--- clean ---') {
            steps{
                withEnv( ["JAVA_HOME=${ tool 'jdk-1.8.0_64bits' }", "PATH+MAVEN=${tool Maven}/bin"] ) {
                    sh "echo \$JAVA_HOME"
                    sh "mvn clean"
                }
            }
        }
        stage('-- package --') {
            steps {
                withEnv( ["PATH+MAVEN=${tool Maven}/bin"] ) {
                    sh "mvn package"
                }
            }
        }
        stage('-- sonar --') {
            steps {
                withEnv( ["PATH+MAVEN=${tool Maven}/bin"] ) {
                    sh "mvn sonar:sonar -Dsonar.jdbc.url=jdbc:h2:tcp://192.168.1.37:9000/sonar -Dsonar.host.url=http://192.168.1.37:9000"
                }
            }
        }
    }
}
