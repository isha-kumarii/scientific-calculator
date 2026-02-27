pipeline {
    agent any

    environment {
        IMAGE_NAME = "ishakumarii/scientific-calculator:latest"
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/<isha-kumarii>/scientific-calculator.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Push to DockerHub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'DockerHubCred',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS')]) {

                    sh '''
                    echo $PASS | docker login -u $USER --password-stdin
                    docker push $IMAGE_NAME
                    '''
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook deploy.yml'
            }
        }
    }

    post {
        success {
            mail to: 'singhisha116@gmail.com',
                 subject: "Build SUCCESS",
                 body: "Scientific Calculator Pipeline executed successfully."
        }

        failure {
            mail to: 'singhisha116@gmail.com',
                 subject: "Build FAILED",
                 body: "Pipeline failed. Check Jenkins console."
        }
    }
}
