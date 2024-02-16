pipeline {
    agent any
    tools{
        maven 'maven'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/nikki00011/SPE_MINI_PROJECT.git']])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image')
        {
            steps
            {
                script
                {
                    sh 'docker build -t nikki00011/spe_mini .'
                }
            }
        }
        stage('Push image to hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerspe', variable: 'dockerspe')]) {
                        sh 'docker login -u nikki00011 -p ${dockerspe}'
                    }
                    sh 'docker push nikki00011/spe_mini'
                }
            }
        }
    }
}