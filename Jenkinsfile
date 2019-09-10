pipeline {
    agent any
    stages {         
        stage('--- clean ---') {
            def mavenPath = 'Maven'
            withEnv( ["PATH+MAVEN=${tool mavenPath}/bin"] ) {
                sh "mvn clean"
            }
        }
        stage('-- package --') {
            steps {
                sh "mvn package"
            }
        }
        stage('-- sonar --') {
            steps {
                sh "mvn sonar:sonar -Dsonar.jdbc.url=jdbc:h2:tcp://192.168.1.37:9000/sonar -Dsonar.host.url=http://192.168.1.37:9000"
            }
        }
    }
}
