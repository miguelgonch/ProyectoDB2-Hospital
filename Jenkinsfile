pipeline {
    agent any
    stages {

        stage('--- clean ---')  withEnv( ["PATH+MAVEN=${tool Maven}/bin"])  {
            steps {
                sh "mvn clean"
            }
        }
        stage('-- package --')  withEnv( ["PATH+MAVEN=${tool Maven}/bin"]) {
            steps {
                sh "mvn package"
            }
        }
        stage('-- sonar --')  withEnv( ["PATH+MAVEN=${tool Maven}/bin"]) {
            steps {
                sh "mvn sonar:sonar -Dsonar.jdbc.url=jdbc:h2:tcp://192.168.1.37:9000/sonar -Dsonar.host.url=http://192.168.1.37:9000"
            }
        }
    }
}
