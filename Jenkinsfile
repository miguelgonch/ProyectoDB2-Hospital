pipeline {
    agent any
    stages {  
        stage('first') {
            agent { label 'master' }
            steps {
               sh "printenv | sort"
            }
        }       
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
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin","PATH+NODE=${tool 'Node'}/bin"]) {
                    sh "node -v"
                }
            }
        }
        stage('-- Merge to QA --') {
            steps {
                script {
                    if(!build.result.toString().equals('FAILURE')){
                       sh "git checkout origin/QA && git merge dev && git push && git checkout dev"
                    }
                }
                step([$class: 'Mailer', recipients: 'gonzalez161256@unis.edu.gt'])
            }
        }
    }
}
