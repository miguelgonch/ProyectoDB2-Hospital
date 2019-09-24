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
                failure_stage=env.STAGE_NAME
                sh "echo ${env.GIT_COMMIT}"
                sh "echo ${env.GIT_BRANCH}"
                script{
                    git_commit_email = sh returnStdout: true, script: "git --no-pager show -s --format='%ce' $GIT_COMMIT"
                    git_commit_name = sh returnStdout: true, script: "git --no-pager show -s --format='%cn' $GIT_COMMIT"
                    git_commit_date = sh returnStdout: true, script: "git --no-pager show -s --format='%cD' $GIT_COMMIT"
                    git_commit_subject = sh returnStdout: true, script: "git --no-pager show -s --format='%s' $GIT_COMMIT"
                }
            }
        }
        stage('Clean & Package') {
            steps {
                failure_stage=env.STAGE_NAME
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin"]) {
                    sh "mvn clean package -Dmaven.test.skip"
                }
            }
        }
        stage('Unit Tests') {
            steps {
                failure_stage=env.STAGE_NAME
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin"]) {
                    sh "mvn test"
                }
            }
        }
        stage("SonarQube Analysis") {
            steps {
                failure_stage=env.STAGE_NAME
                withSonarQubeEnv('sonar') {
                    withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin","PATH+NODE=${tool 'Node'}/bin"]) {
                        sh "mvn sonar:sonar -Dsonar.projectName=ProyectoDB2-Hospital-"+ env.JOB_BASE_NAME
                    }
                }   
            }
        }
        stage("Quality Gate") {
            steps {
                failure_stage=env.STAGE_NAME
                timeout(time: 10, unit: 'MINUTES') {
                    //waitForQualityGate abortPipeline: true
                    script {
                        def qg = waitForQualityGate()
                        gpError = qg.status
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to a quality gate failure: ${qg.status}"
                        }
                    }
                }
            }
        }
        stage('Deploy'){
            steps{
                failure_stage=env.STAGE_NAME
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
            script {
                if (gpError=='ERROR'){
                    emailext to: 'gonzalez161256@unis.edu.gt,'+git_commit_email,
                    subject: "Finished Pipeline: ${currentBuild.fullDisplayName} - Failure - ${git_commit_date} - Quality Gate Failure",
                    body: "There was a problem with ${env.BUILD_URL} \n Failure in stage: ${failure_stage} \n It looks like Commiter: ${git_commit_name} Commit: ${git_commit_subject} (${GIT_COMMIT}) \n Branch: ${GIT_BRANCH} \n did not followed the Quality Gate Rules"            
                }
                else{
                    emailext to: 'gonzalez161256@unis.edu.gt,'+git_commit_email,
                    subject: "Finished Pipeline: ${currentBuild.fullDisplayName} - Failure - ${git_commit_date}",
                    body: "There was a problem with ${env.BUILD_URL} \n Failure in stage: ${failure_stage} \n Commiter: ${git_commit_name} Commit: ${git_commit_subject} (${GIT_COMMIT}) \n Branch: ${GIT_BRANCH}"
                }
            }
        }
    }
}
