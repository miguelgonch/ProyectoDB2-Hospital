def qgError = ''
def git_commit_email = ''
def git_commit_name = ''
def git_commit_date = ''
def git_commit_subject = ''
def failure_stage = ''
pipeline{
    agent any
    stages {      
        stage('Get git info'){
            steps{
                sh "echo ${env.GIT_COMMIT}"
                sh "echo ${env.GIT_BRANCH}"
                script{
                    git_commit_email = sh returnStdout: true, script: "git --no-pager show -s --format='%ce' $GIT_COMMIT"
                    git_commit_name = sh returnStdout: true, script: "git --no-pager show -s --format='%cn' $GIT_COMMIT"
                    git_commit_date = sh returnStdout: true, script: "git --no-pager show -s --format='%cD' $GIT_COMMIT"
                    git_commit_subject = sh returnStdout: true, script: "git --no-pager show -s --format='%s' $GIT_COMMIT"
                    failure_stage=env.STAGE_NAME
                }
            }
        }
        stage('Clean & Package') {
            steps {                
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin"]) {
                    sh "mvn clean package -Dmaven.test.skip"
                }
                script{
                    failure_stage=env.STAGE_NAME
                }
            }
        }
        stage('Unit Tests') {
            steps {
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin"]) {
                    sh "mvn test"
                }
                script{
                    failure_stage=env.STAGE_NAME
                }
            }
        }
        stage("SonarQube Analysis") {
            steps {
                withSonarQubeEnv('sonar') {
                    withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin","PATH+NODE=${tool 'Node'}/bin"]) {
                        sh "mvn sonar:sonar -Dsonar.projectName=ProyectoDB2-Hospital-"+ env.JOB_BASE_NAME + " -Dsonar.projectKey=proyectoDB2-Hospital-"+ env.JOB_BASE_NAME
                    }
                }  
                script{
                    failure_stage=env.STAGE_NAME
                } 
            }
        }
        stage("Quality Gate") {
            steps {
                timeout(time: 15, unit: 'MINUTES') {
                    //waitForQualityGate abortPipeline: true
                    script {
                        def qg = waitForQualityGate()
                        gpError = qg.status
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to a quality gate failure: ${qg.status}"
                        }
                        failure_stage=env.STAGE_NAME
                    }
                }
            }
        }
        stage('Deploy'){
            steps{
                deploy adapters: [tomcat9(credentialsId: '3', path: '', url: 'http://172.10.0.4:8080')], contextPath: null, war: '**/*.war'
                script{
                    failure_stage=env.STAGE_NAME
                }
            }
        }
       
    }
    post {
        success {
            emailext to: 'gonzalez161256@unis.edu.gt',
            subject: "${currentBuild.fullDisplayName} - ${git_commit_date} - Success",
            body: "The build was successfull with ${env.BUILD_URL}\n Commiter: ${git_commit_name} (${git_commit_email})\n Commit: ${git_commit_subject} (${GIT_COMMIT}) \n Branch: ${GIT_BRANCH}"
        }
        failure {
            script {
                def bodyText = "There was a problem with ${env.BUILD_URL} \n Failure in stage: ${failure_stage}\n Commiter: ${git_commit_name} (${git_commit_email})\nCommit: ${git_commit_subject} (${GIT_COMMIT}) \n Branch: ${GIT_BRANCH}"
                if (gpError=='ERROR'){
                    bodyText = bodyText + " \n Error: Did not followed the Quality Gate Rules"
                }
                emailext to: 'gonzalez161256@unis.edu.gt,jflores@unis.edu.gt,'+git_commit_email,
                subject: "${currentBuild.fullDisplayName} - ${git_commit_date} - ${failure_stage} Failure",
                body: bodyText
            }
        }
    }
}