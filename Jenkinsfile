def qgErrorStat = false
def qgError = ''
def git_commit_email = ''
def git_commit_name = ''
def git_commit_date = ''
def git_commit_subject = ''
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
                }
            }
        }
        stage('Clean & Package') {
            steps {
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin"]) {
                    sh "mvn clean package -Dmaven.test.skip"
                }
            }
        }
        stage('Unit Tests') {
            steps {
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin"]) {
                    sh "mvn test"
                }
            }
        }
        stage("SonarQube Analysis") {
            steps {
                withSonarQubeEnv('sonar') {
                    withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin","PATH+NODE=${tool 'Node'}/bin"]) {
                        sh "mvn sonar:sonar -Dsonar.projectName=ProyectoDB2-Hospital-"+ env.JOB_BASE_NAME
                    }
                }   
            }
        }
        stage("Quality Gate") {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    script {
                        def qg = waitForQualityGate()
                        qgError = qg.qualityGate['status']
                        //sh "echo ${qgError}"
                        //sh "echo ${qg}"
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to a quality gate failure: ${qg.status}"
                            qgErrorStat = true
                        }
                    }
                }
            }
        }
        stage('Deploy'){
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
            sh "echo ${qgError}"
            script {
                if (qgErrorStat){
                    emailext to: 'gonzalez161256@unis.edu.gt,'+git_commit_email,
                    subject: "Finished Pipeline: ${currentBuild.fullDisplayName} - Failure - ${git_commit_date} - Quality Gate Failure",
                    body: "There was a problem with ${env.BUILD_URL} \n It looks like Commiter: ${git_commit_name} \n Commit: ${git_commit_subject} (${GIT_COMMIT}) \n Branch: ${GIT_BRANCH} \n did not followed the Quality Gate Rules"            
                }
                else{
                     emailext to: 'gonzalez161256@unis.edu.gt,'+git_commit_email,
                    subject: "Finished Pipeline: ${currentBuild.fullDisplayName} - Failure - ${git_commit_date}",
                    body: "There was a problem with ${env.BUILD_URL} \n Commiter: ${git_commit_name} \n Commit: ${git_commit_subject} (${GIT_COMMIT}) \n Branch: ${GIT_BRANCH}"
                }
            }
        }
    }
}
