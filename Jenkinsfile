pipeline {
    agent any

    stages {
        stage ('Maven build') {
            withMaven {
                sh "mvn clean package"
            }
        }

        stage('Build docker image') {
        /* This stage builds the actual image; synonymous to
           docker build on the command line */
            steps {
            sh "sudo docker build . -t demoapp:1"
            }
        }

        stage('Push image to OCIR') {
         /* Final stage of build; Push the
            docker image to our OCI private Registry*/
        steps {
            sh "sudo docker login -u 'seelaiwong/oracleidentitycloudservice/seelai.wong@outlook.com' -p '+_yl(H#6+iUO)6r_rqk>' hyd.ocir.io"
            sh "sudo docker tag demoapp:1 hyd.ocir.io/seelaiwong/demoapp:demo"
            sh 'sudo docker push hyd.ocir.io/seelaiwong/demoapp:demo'

           }
         }
         stage('Deploy to OKE') {
         /* Deploy the image to OKE*/

        steps {
            /*sh "'sudo cp /var/lib/jenkins/workspace/deploy.sh /var/lib/jenkins/workspace/jenkins-oci_master'"*/
            sh 'sh ../../demo-deploy.sh'
           }
         }
    }
}