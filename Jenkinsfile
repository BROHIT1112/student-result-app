
pipeline {

    agent any

    tools {
        maven 'Maven 3.9.x'
        jdk 'Java21'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Archive WAR') {
            steps {
                archiveArtifacts artifacts: 'target/student-result.war',
                                     fingerprint: true
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                sh '''
                    rm -rf /var/lib/tomcat10/webapps/student-result
                    rm -f /var/lib/tomcat10/webapps/student-result.war
                    cp target/student-result.war /var/lib/tomcat10/webapps/
                '''
            }
        }

    }
}

