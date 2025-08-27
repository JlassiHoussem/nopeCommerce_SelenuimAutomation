pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/JlassiHoussem/nopeCommerce_SelenuimAutomation.git'
            }
        }

        stage('Run Regression Suite') {
            steps {
                bat """ "${tool 'MAVEN_HOME'}/bin/mvn" clean test -P regression """
            }
        }

        stage('Results') {
            steps {
                // Publish test results
                junit '**/target/surefire-reports/TEST-*.xml'

                // Archive useful reports instead of .jar
                archiveArtifacts artifacts: 'target/surefire-reports/*.xml', fingerprint: true
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
