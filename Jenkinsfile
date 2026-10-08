
pipeline {

    agent any

    tools {
        maven 'Maven 3.9.x'
        jdk 'Java17'
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
                    sudo rm -rf /var/lib/tomcat10/webapps/student-result
                    sudo rm -f /var/lib/tomcat10/webapps/student-result.war
                    sudo cp target/student-result.war /var/lib/tomcat10/webapps/
                '''
            }
        }

    }
}

