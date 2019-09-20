pipeline{
    agent any
    stages {  
        /*stage('first') {
            agent { label 'master' }
            steps {
            sh "printenv | sort"
            }
        }*/       
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
        stage('-- Unit Test --') {
            steps {
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin"]) {
                    sh "mvn -Dtest=gio.co.hospitales.GetUsuarioTest test"
                }
            }
        }
        stage('-- sonar --') {
            steps {
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin","PATH+NODE=${tool 'Node'}/bin"]) {
                    sh "mvn sonar:sonar -Dsonar.jdbc.url=jdbc:h2:tcp://172.10.0.4:9000/sonar -Dsonar.host.url=http://172.10.0.4:9000"
                }
            }
        }
       
    }
    post {
        success {
            emailext to: 'gonzalez161256@unis.edu.gt',
            subject: "Finished Pipeline: ${currentBuild.fullDisplayName} - Success",
            body: "The build was successfull with ${env.BUILD_URL}"
            deploy adapters: [tomcat9(credentialsId: '3', path: '', url: 'http://172.10.0.3:8080')], contextPath: null, war: '**/*.war'
        }
        failure {
            emailext to: 'gonzalez161256@unis.edu.gt',
            subject: "Finished Pipeline: ${currentBuild.fullDisplayName} - Failure",
            body: "There was a problem with ${env.BUILD_URL}"
        }
    }
}