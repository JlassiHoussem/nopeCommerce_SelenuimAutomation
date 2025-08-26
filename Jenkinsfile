pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'   // Use the Maven installation you configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/JlassiHoussem/nopeCommerce_SelenuimAutomation.git'
            }
        }

        stage('Build & Test') {
            steps {
                // Run Maven tests with your regression profile
                bat """ "${tool 'MAVEN_HOME'}/bin/mvn" clean test -Pregression """
            }
        }

        stage('Results') {
            steps {
                // Collect test results
                junit '**/target/surefire-reports/TEST-*.xml'
                // Optionally archive built artifacts
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo " Build succeeded"
        }
        failure {
            echo " Build failed"
        }
    }
}
