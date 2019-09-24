def qgErrorStat = false
def git_commit_email = ''
def git_commit_name = ''
pipeline{
    agent any
    stages {      
        stage('-- Get git info --'){
            steps{
                sh "echo ${env.GIT_COMMIT}"
                sh "echo ${env.GIT_BRANCH}"
                sh "git --no-pager show -s --format='%an' $GIT_COMMIT"
                sh "git --no-pager show -s --format='%as' $GIT_COMMIT"
                script{
                    git_commit_email = sh returnStdout: true, script: "git --no-pager show -s --format='%an' $GIT_COMMIT"
                    git_commit_name = sh returnStdout: true, script: "git --no-pager show -s --format='%as' $GIT_COMMIT"
                }
            }
        }
        stage('-- Clean, Package & Unit Tests--') {
            steps {
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin"]) {
                    sh "mvn clean package"
                }
            }
        }
        stage("-- SonarQube Analysis --") {
            steps {
                withSonarQubeEnv('sonar') {
                    withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin","PATH+NODE=${tool 'Node'}/bin"]) {
                        sh "mvn sonar:sonar -Dsonar.projectName=ProyectoDB2-Hospital-"+ env.JOB_BASE_NAME
                    }
                }   
            }
        }
        stage("-- Quality Gate --") {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    script {
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to a quality gate failure: ${qg.status}"
                            qgErrorStat = true
                        }
                    }
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
            
            script{
                when{
                    expression{
                        qgErrorStat
                    }
                }
                emailext to: 'gonzalez161256@unis.edu.gt',
                subject: "Finished Pipeline: ${currentBuild.fullDisplayName} - Failure",
                body: "There was a problem with ${env.BUILD_URL} \n It looks like ${GIT_NAME} with ${GIT_COMMIT} in ${GIT_BRANCH} did not followed the Quality Gate Rules"
            }
            script{
                when{
                    expression{
                        !qgErrorStat
                    }
                }
                emailext to: 'gonzalez161256@unis.edu.gt',
                subject: "Finished Pipeline: ${currentBuild.fullDisplayName} - Failure",
                body: "There was a problem with ${env.BUILD_URL}"
            }
        }
    }
}
