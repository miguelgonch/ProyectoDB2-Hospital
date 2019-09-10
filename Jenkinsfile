pipeline {
    agent any
    stages {     
        stage('--- clean ---') {
            steps{
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin"]) {
                    sh "mvn clean"
                }
            }
        }
        stage('-- package --') {
            steps {
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin"]) {
                    sh "mvn package"
                }
            }
        }
        stage('-- sonar --') {
            steps {
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin"]) {
                    
                        sh "mvn sonar:sonar -Dsonar.jdbc.url=jdbc:h2:tcp://192.168.1.37:9000/sonar -Dsonar.host.url=http://192.168.1.37:9000"
                        step([$class: 'Mailer', recipients: 'gonzalez161256@unis.edu.gt',body:'This is a test'])
                }
            }
        }
        stage('-- Merge to QA --') {
            steps {
                sh "git checkout QA && git merge dev && git push && git checkout dev"
            }
        }
    }
}
