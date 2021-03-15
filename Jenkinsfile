pipeline {
    agent any
    tools {
            // Install the Maven version configured as "M3" and add it to the path.
            maven "M3"
            jdk "JDK8"
        }

    stages {
        stage('Build jar files') {
            steps {
                git 'https://github.com/seelai/dropwizard-helloworld'
                sh "mvn clean package"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }

        stage('Build docker image') {
            steps {
                sh "sudo docker build . -t demoapp:1"
            }
        }

        stage('Push image to OCIR') {
            steps {
                sh "sudo docker login -u 'axu6suxpi2nw/oracleidentitycloudservice/seelai.wong@outlook.com' -p '+_yl(H#6+iUO)6r_rqk>' hyd.ocir.io"
                sh "sudo docker tag demoapp:1 hyd.ocir.io/axu6suxpi2nw/demoapp:demo"
                sh 'sudo docker push hyd.ocir.io/axu6suxpi2nw/demoapp:demo'

               }
         }
         stage('Deploy to OKE') {
         /* Deploy the image to OKE*/

        steps {
            sh 'sh ../../demo-deploy.sh'
           }
         }
    }
}