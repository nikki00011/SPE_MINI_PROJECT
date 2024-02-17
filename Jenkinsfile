pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/nikki00011/SPE_MINI_PROJECT.git']])
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t nikki00011/spe_mini .'
                }
            }
        }
        stage('Push Image to Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerspe', variable: 'dockerspe')]) {
                        sh 'docker login -u nikki00011 -p ${dockerspe}'
                    }
                    sh 'docker push nikki00011/spe_mini'
                }
            }
        }
        // Stage to stop and remove existing Docker container
                stage('Stop and Remove Existing Container') {
                    steps {
                        script {
                            // Stop and remove existing Docker container named miniProject if it exists then
                            sh 'docker rm -f spe_mini || true'
                        }
                    }
                }
        stage('Run Ansible Playbook') {
            steps {
                script {
                    ansiblePlaybook(
                        playbook: 'deploy.yml',
                        inventory: 'inventory'
                    )
                }
            }
        }
    }
}
