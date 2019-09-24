pipeline{
    agent any
    stages {      
        stage('-- clean, package & Unit Tests--') {
            steps {
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin"]) {
                    sh "mvn clean package"
                }
            }
        }
        /*
        stage('-- sonar --') {
            steps {
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin","PATH+NODE=${tool 'Node'}/bin"]) {
                    sh "mvn sonar:sonar -Dsonar.jdbc.url=jdbc:h2:tcp://172.10.0.5:9000/sonar -Dsonar.host.url=http://172.10.0.5:9000"
                }
            }
        }*/
        stage("build & SonarQube analysis") {
            steps {
                withSonarQubeEnv('sonar') {
                    withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin","PATH+NODE=${tool 'Node'}/bin"]) {
                        sh "mvn sonar:sonar -Dsonar.branch.name="+ env.BRANCH_NAME
                    }
                }   
            }
        }
        stage("Quality Gate") {
            steps {
                timeout(time: 15, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage('-- Deploy --'){
            steps{
                deploy adapters: [tomcat9(credentialsId: '3', path: '', url: 'http://172.10.0.4:8080')], contextPath: null, war: '**/*.war'
            }
        }
       
    }
    post {
        success {
            emailext to: 'gonzalez161256@unis.edu.gt',
            subject: "Finished Pipeline: ${currentBuild.fullDisplayName} - Success",
            body: "The build was successfull with ${env.BUILD_URL}"
        }
        failure {
            emailext to: 'gonzalez161256@unis.edu.gt',
            subject: "Finished Pipeline: ${currentBuild.fullDisplayName} - Failure",
            body: "There was a problem with ${env.BUILD_URL}"
        }
    }
}
