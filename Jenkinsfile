pipeline {
    agent any

    environment {
        IMAGE_NAME = "ishakumarii/scientific-calculator:latest"
    }

    stages {

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
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                        echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
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
                 subject: "SUCCESS: Scientific Calculator Pipeline",
                 body: """
Pipeline executed successfully.

Docker Image: ${IMAGE_NAME}
Build Number: ${BUILD_NUMBER}
Job Name: ${JOB_NAME}
"""
        }

        failure {
            mail to: 'singhisha116@gmail.com',
                 subject: "FAILED: Scientific Calculator Pipeline",
                 body: """
Pipeline failed.

Check Jenkins console:
${BUILD_URL}
"""
        }
    }
}
