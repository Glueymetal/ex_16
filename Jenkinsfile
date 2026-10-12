pipeline{
    agent any 
    environment{
        TAG = 'maven-app'
        VERSION = "${env.BUILD_NUMBER}"
    }
    stages{
        stage('Checkout')
        {
            steps{
                checkout scm
            }
        }
        stage('Compile')
        {
            steps{
                bat 'mvn clean compile'
            }
        }
        stage('Test')
        {
            steps{
                bat 'mvn test'
            }
        }
        stage('Package')
        {
            steps{
                bat 'mvn package -DskipTests'
            }
        }
        stage('Build')
        {
            steps{
                bat 'docker build -t %TAG%:%VERSION% .'
            }
        }
        stage('Run')
        {
            steps{
                bat 'docker run --rm %TAG%:%VERSION%'
            }
        }
    }

    post{
        always{
            junit 'target/surefire-reports/*.xml'
        }
    }
}