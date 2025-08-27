pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'   // Must match Maven installation name in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/JlassiHoussem/nopeCommerce_SelenuimAutomation.git'
            }
        }

        stage('Run Regression Suite') {
            steps {
                // Run regression profile
                bat """ "${tool 'MAVEN_HOME'}/bin/mvn" clean test -P regression """
            }
        }

        stage('Results') {
            steps {
                junit '**/target/surefire-reports/TEST-*.xml'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo "✅ Regression suite executed successfully!"
        }
        failure {
            echo "❌ Regression suite failed!"
        }
    }
}
