node ('Dev') {  
        try{
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
                        sh "mvn sonar:sonar -Dsonar.jdbc.url=jdbc:h2:tcp://192.168.1.37:9000/sonar -Dsonar.host.url=http://192.168.1.37:9000"
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
                }
            }
        } 
        catch (err){
            throw err
        }
        Finally{
                stage('Email')
            {
                env.ForEmailPlugin = env.WORKSPACE      
                emailext body: 'Test Notificacion', 
                subject: currentBuild.currentResult + " : " + env.JOB_NAME, 
                to: 'gonzalez161256@unis.edu.gt'
            }
        }
}